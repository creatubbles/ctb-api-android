package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.ContentType;
import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.creation.ToybooDetails;
import com.creatubbles.api.model.image_manipulation.ImageManipulation;
import com.creatubbles.api.model.upload.UploadState;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.response.UploadResponseCallback;

import java.io.File;
import java.util.List;

/**
 * Interface defining methods operating on creations.
 * To create an instance use {@link CreationRepositoryBuilder}.
 */
public interface CreationRepository {

    /**
     * @param page       number of the page
     * @param onlyPublic set true to get only approved Creations
     */
    void getRecent(@Nullable Integer page, @Nullable Boolean onlyPublic,
                   @Nullable ResponseCallback<CreatubblesResponse<List<Creation>>> callback);

    /**
     * @param page       number of the page
     * @param galleryId  the ID of Gallery from which the Creations should be returned
     * @param onlyPublic set true to get only approved Creations
     */
    void getFromGallery(@Nullable Integer page, @NonNull String galleryId, @Nullable Boolean onlyPublic,
                        @Nullable ResponseCallback<CreatubblesResponse<List<Creation>>> callback);

    /**
     * @param page       number of the page
     * @param userId     the ID of the User whom's Creations should be returned
     * @param onlyPublic set true to get only approved Creations
     */
    void getByUser(@Nullable Integer page, @NonNull String userId, @Nullable Boolean onlyPublic,
                   @Nullable ResponseCallback<CreatubblesResponse<List<Creation>>> callback);

    /**
     * @param page       number of the page
     * @param name       keyword to filter Creations by name
     * @param onlyPublic set true to get only approved Creations
     */
    void getByName(@Nullable Integer page, @NonNull String name, @Nullable Boolean onlyPublic,
                   @Nullable ResponseCallback<CreatubblesResponse<List<Creation>>> callback);


    void getById(@NonNull String creationId, @Nullable ResponseCallback<CreatubblesResponse<Creation>> callback);

    /**
     * Method used to obtain a list of recommended Creations by given Creation.
     *
     * @param page       number of the page
     * @param onlyPublic set true to get only approved Creations
     */
    void getRecommendedByCreation(@Nullable Integer page, @NonNull String creationId, @Nullable Boolean onlyPublic,
                                  @Nullable ResponseCallback<CreatubblesResponse<List<Creation>>> callback);

    /**
     * Method used to obtain a list of recommended creations added by given user.
     *
     * @param page       number of the page
     * @param onlyPublic set true to get only approved Creations
     */
    void getRecommendedByUser(@Nullable Integer page, @NonNull String creationId, @Nullable Boolean onlyPublic,
                              @Nullable ResponseCallback<CreatubblesResponse<List<Creation>>> callback);

    /**
     * Method used to obtain a list of creations by Partner Application.
     */
    void getByPartnerApplication(@Nullable Integer page, @NonNull String partnerApplicationId,
                                 @Nullable ResponseCallback<CreatubblesResponse<List<Creation>>> callback);

    /**
     * Method used to update Creation with a given ID.
     *
     * @param creationId the ID of Creation to update
     * @param creation   Creation object with values to update. Only a few properties can be modified.
     *                   To create this object use {@link com.creatubbles.api.model.creation.Creation.Builder}
     *                   and set only the properties you want to update.
     */
    void update(@NonNull String creationId, @NonNull Creation creation, @Nullable ResponseCallback<Void> callback);

    /**
     * Method used to create a new Creation.
     *
     * @param creation Creation instance created using {@link com.creatubbles.api.model.creation.Creation.Builder}.
     */
    void create(@NonNull Creation creation, @Nullable ResponseCallback<CreatubblesResponse<Creation>> callback);

    /**
     * @param creationId the ID of Creation that should be removed
     */
    void remove(@NonNull String creationId, @Nullable ResponseCallback<Void> callback);

    /**
     * Creates a creation, manages the upload of the file, and updates the server
     * @param creation Creation instance created using {@link com.creatubbles.api.model.creation.Creation.Builder}.
     * @param file File to be used for upload
     * @param contentType Content type of the file
     * @param galleryIds Galleries this creation should belong to
     * @param callback Callback
     */
    void uploadCreation(@NonNull Creation creation, @NonNull File file, @NonNull ContentType contentType, @Nullable List<String> galleryIds, @Nullable UploadResponseCallback<Creation> callback);


    /**
     * Resumes operations of creating, uploading, updating server.
     *
     * @param creation    Creation instance created using {@link com.creatubbles.api.model.creation.Creation.Builder}.
     * @param file        File to be used for upload
     * @param contentType Content type of the file
     * @param galleryIds  Galleries this creation should belong to
     * @param uploadState The last upload state reported by the callback on your last try
     * @param callback    Callback
     */
    void resumeUploadCreation(@NonNull Creation creation, @NonNull File file,
                              @NonNull ContentType contentType, @Nullable List<String> galleryIds,
                              @NonNull UploadState uploadState,
                              @Nullable UploadResponseCallback<Creation> callback);

    /**
     * Method used to modify image of a creation identified by {@code creationId}.
     *
     * @param imageManipulation object describing operations to perform on an image
     */
    void updateImage(@NonNull String creationId, @NonNull ImageManipulation imageManipulation, @Nullable ResponseCallback<Void> callback);

    /**
     * Method used to obtain toyboo details for specific creation
     *
     * @param creationId the ID of Creation
     */
    void getToybooDetails(@NonNull String creationId, @Nullable ResponseCallback<CreatubblesResponse<ToybooDetails>> callback);

    /**
     * Method used to update creation views count
     *
     * @param creationId the ID of Creation
     */
    void updateViewsCount(@NonNull String creationId, @Nullable ResponseCallback<Void> callback);
}
