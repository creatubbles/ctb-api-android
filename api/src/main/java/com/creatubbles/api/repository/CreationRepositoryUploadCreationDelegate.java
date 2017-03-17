package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.ContentType;
import com.creatubbles.api.exception.Error;
import com.creatubbles.api.exception.ErrorResponse;
import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.GallerySubmission;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.upload.Upload;
import com.creatubbles.api.model.upload.UploadState;
import com.creatubbles.api.model.upload.UploadStep;
import com.creatubbles.api.request.ProgressRequestBody;
import com.creatubbles.api.request.UploadRequest;
import com.creatubbles.api.response.BaseResponseMapper;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.response.UploadResponseCallback;
import com.creatubbles.api.service.CreationService;
import com.creatubbles.api.service.GalleryService;
import com.creatubbles.api.service.UploadService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import retrofit2.Call;

public class CreationRepositoryUploadCreationDelegate {

    private final ObjectMapper objectMapper;
    private final CreationService creationService;
    private final UploadService uploadService;
    private final GalleryService galleryService;
    private final Creation creationData;
    private final File file;
    private final ContentType contentType;
    private final List<String> galleryIds;
    private final UploadResponseCallback<Creation> callback;

    // Collect multiple errors before delivery
    private final List<String> errorMessages = new ArrayList<>();
    private final List<ErrorResponse> serverErrors = new ArrayList<>();

    // Exposed to callbacks, to be delivered
    private UploadState uploadState;
    private Creation fetchedCreation;

    public CreationRepositoryUploadCreationDelegate(@NonNull ObjectMapper objectMapper,
                                                    @NonNull CreationService creationService,
                                                    @NonNull UploadService uploadService,
                                                    @NonNull GalleryService galleryService,
                                                    @NonNull Creation creationData,
                                                    @NonNull File file,
                                                    @NonNull ContentType contentType,
                                                    @Nullable List<String> galleryIds,
                                                    @Nullable UploadResponseCallback<Creation> callback) {
        this.objectMapper = objectMapper;
        this.creationService = creationService;
        this.uploadService = uploadService;
        this.galleryService = galleryService;
        this.creationData = creationData;
        this.file = file;
        this.contentType = contentType;
        this.galleryIds = galleryIds;
        this.callback = callback;
        this.uploadState = new UploadState();

        if (galleryIds != null) {
            this.uploadState.getUnUpdatedGalleries().addAll(galleryIds);
        }
    }

    void resume(UploadState lastState) {
        this.uploadState = lastState;
        upload();
    }

    void upload() {
        allocateCreation(() ->
                obtainUploadPath(() ->
                        uploadFile(() ->
                                updateCreationUploadSucceeded(() ->
                                        updateGalleries(() ->
                                                fetchCreation(() ->
                                                        deliverSuccessResult()))))));
    }

    private void allocateCreation(Runnable onSuccess) {
        if (uploadState.getAllocatedCreationId() != null) {
            onSuccess.run();
        } else {
            Call<JSONAPIDocument<Creation>> call = creationService.createCreation(creationData);
            call.enqueue(new JsonApiResponseMapper<>(objectMapper, new ResponseCallback<CreatubblesResponse<Creation>>() {
                @Override public void onSuccess(CreatubblesResponse<Creation> response) {
                    updateUploadStep(UploadStep.CREATION_ALLOCATED);
                    updateAllocatedCreationId(response.getData().getId());
                    onSuccess.run();
                }

                @Override public void onServerError(ErrorResponse errorResponse) {
                    addServerError(errorResponse);
                    deliverErrors();
                }

                @Override public void onError(String message) {
                    addError(message);
                    deliverErrors();
                }
            }));
        }
    }

    private void obtainUploadPath(Runnable onSuccess) {
        if (uploadState.getUploadMeta() != null) {
            onSuccess.run();
        } else {
            UploadRequest request = new UploadRequest(contentType);
            Call<JSONAPIDocument<Upload>> call = creationService.createUpload(uploadState.getAllocatedCreationId(), request);
            call.enqueue(new JsonApiResponseMapper<>(objectMapper, new ResponseCallback<CreatubblesResponse<Upload>>() {
                @Override public void onSuccess(CreatubblesResponse<Upload> response) {
                    updateUploadStep(UploadStep.FILE_UPLOAD_CONFIGURED);
                    updateUploadMeta(response.getData());
                    onSuccess.run();
                }

                @Override public void onServerError(ErrorResponse errorResponse) {
                    addServerError(errorResponse);
                    deliverErrors();
                }

                @Override public void onError(String message) {
                    addError(message);
                    deliverErrors();
                }
            }));
        }
    }

    private void uploadFile(Runnable onSuccess) {
        if (isDone(UploadStep.FILE_UPLOAD_UPLOADED)) {
            onSuccess.run();
        } else {
            MediaType mediaType = MediaType.parse(uploadState.getUploadMeta().getContentType());
            ProgressRequestBody requestBody = new ProgressRequestBody(mediaType, file,
                    progress -> updateUploadProgress(progress));
            Call<Void> call = uploadService.uploadFile(uploadState.getUploadMeta().getUrl(), requestBody);
            call.enqueue(new BaseResponseMapper<>(objectMapper, new ResponseCallback<Void>() {
                @Override public void onSuccess(Void response) {
                    updateUploadStep(UploadStep.FILE_UPLOAD_UPLOADED);
                    onSuccess.run();
                }

                @Override public void onServerError(ErrorResponse errorResponse) {
                    addServerError(errorResponse);
                    updateCreationUploadFailed();
                }

                @Override public void onError(String message) {
                    addError(message);
                    updateCreationUploadFailed();
                }
            }));
        }
    }

    private void updateCreationUploadSucceeded(Runnable onSuccess) {
        if (isDone(UploadStep.FILE_UPLOAD_SERVER_NOTIFIED)) {
            onSuccess.run();
        } else {
            Call<Void> call = creationService.updateCreationUpload(uploadState.getUploadMeta().getPingUrl(), null);
            call.enqueue(new BaseResponseMapper<>(objectMapper, new ResponseCallback<Void>() {
                @Override public void onSuccess(Void response) {
                    updateUploadStep(UploadStep.FILE_UPLOAD_SERVER_NOTIFIED);
                    onSuccess.run();
                }

                @Override public void onServerError(ErrorResponse errorResponse) {
                    addServerError(errorResponse);
                    deliverErrors();
                }

                @Override public void onError(String message) {
                    addError(message);
                    deliverErrors();
                }
            }));
        }
    }

    private void updateCreationUploadFailed() {
        StringBuilder compositeError = new StringBuilder();
        compositeError.append("Local(android) errors:").append("\n");
        for (String errorMessage : errorMessages) {
            compositeError.append(errorMessage).append("\n");
        }
        compositeError.append("Server errors:").append("\n");
        for (ErrorResponse serverError : serverErrors) {
            compositeError.append(serverError).append("\n");
        }

        Call<Void> call = creationService.updateCreationUpload(uploadState.getUploadMeta().getPingUrl(), compositeError.toString());
        call.enqueue(new BaseResponseMapper<>(objectMapper, new ResponseCallback<Void>() {
            @Override public void onSuccess(Void response) {
                updateUploadStep(UploadStep.FILE_UPLOAD_FAIL_REPORTED);
                deliverErrors();
            }

            @Override public void onServerError(ErrorResponse errorResponse) {
                addServerError(errorResponse);
                deliverErrors();
            }

            @Override public void onError(String message) {
                addError(message);
                deliverErrors();
            }
        }));
    }

    private void updateGalleries(Runnable onSuccess) {
        if (isDone(UploadStep.SUBMITTED_TO_GALLERIES)) {
            onSuccess.run();
        } else {
            if (uploadState.getUnUpdatedGalleries().isEmpty()) {
                updateUploadStep(UploadStep.SUBMITTED_TO_GALLERIES);
                onSuccess.run();
            } else {
                String galleryId = uploadState.getUnUpdatedGalleries().pop();
                Call<JSONAPIDocument<GallerySubmission>> call =
                        galleryService.postSubmission(new GallerySubmission(galleryId, uploadState.getAllocatedCreationId()));
                call.enqueue(new JsonApiResponseMapper<>(objectMapper, new ResponseCallback<CreatubblesResponse<GallerySubmission>>() {
                    @Override
                    public void onSuccess(CreatubblesResponse<GallerySubmission> response) {
                        updateGalleries(onSuccess);
                    }

                    @Override public void onServerError(ErrorResponse errorResponse) {
                        addServerError(errorResponse);
                        deliverErrors();
                    }

                    @Override public void onError(String message) {
                        addError(message);
                        deliverErrors();
                    }
                }));
            }
        }
    }

    private void fetchCreation(Runnable onSuccess) {
        Call<JSONAPIDocument<Creation>> call = creationService.getCreation(uploadState.getAllocatedCreationId());
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, new ResponseCallback<CreatubblesResponse<Creation>>() {
            @Override public void onSuccess(CreatubblesResponse<Creation> response) {
                fetchedCreation = response.getData();
                onSuccess.run();
            }

            @Override public void onServerError(ErrorResponse errorResponse) {
                addServerError(errorResponse);
                deliverErrors();
            }

            @Override public void onError(String message) {
                addError(message);
                deliverErrors();
            }
        }));
    }

    private boolean isDone(UploadStep state) {
        return state.getOrder() <= uploadState.getUploadStep().getOrder();
    }

    private void updateUploadStep(UploadStep state) {
        uploadState.setUploadStep(state);
        deliverStateChanged();
    }

    private void updateAllocatedCreationId(String allocatedCreationId) {
        uploadState.setAllocatedCreationId(allocatedCreationId);
        deliverStateChanged();
    }

    private void updateUploadMeta(Upload uploadMeta) {
        uploadState.setUploadMeta(uploadMeta);
        deliverStateChanged();
    }

    private void updateUploadProgress(float progress) {
        uploadState.setUploadProgress(progress);
        deliverStateChanged();
    }

    private void deliverStateChanged() {
        if (callback != null) {
            callback.onStateChanged(uploadState);
        }
    }

    private void addServerError(ErrorResponse errorResponse) {
        serverErrors.add(errorResponse);
    }

    private void addError(String message) {
        errorMessages.add(message);
    }

    private void deliverErrors() {
        if (callback != null) {
            if (!errorMessages.isEmpty()) {
                StringBuilder errorMessagesJoin = new StringBuilder();
                for (String errorMessage : errorMessages) {
                    errorMessagesJoin.append(errorMessage).append("\n");
                }
                callback.onError(errorMessagesJoin.toString());
            }

            if (!serverErrors.isEmpty()) {
                List<Error> allErrors = new ArrayList<>();
                for (ErrorResponse serverError : serverErrors) {
                    allErrors.addAll(serverError.getErrors());
                }
                callback.onServerError(new ErrorResponse(allErrors));
            }
        }
    }

    private void deliverSuccessResult() {
        if (callback != null) {
            callback.onSuccess(fetchedCreation);
        }
    }
}
