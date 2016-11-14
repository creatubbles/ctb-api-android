package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.ContentType;
import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.creation.ToybooDetails;
import com.creatubbles.api.model.image_manipulation.ImageManipulation;
import com.creatubbles.api.model.upload.Upload;
import com.creatubbles.api.response.ResponseCallback;

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
                   ResponseCallback<CreatubblesResponse<List<Creation>>> callback);

    /**
     * @param page       number of the page
     * @param galleryId  the ID of Gallery from which the Creations should be returned
     * @param onlyPublic set true to get only approved Creations
     */
    void getFromGallery(@Nullable Integer page, @NonNull String galleryId, @Nullable Boolean onlyPublic,
                        ResponseCallback<CreatubblesResponse<List<Creation>>> callback);

    /**
     * @param page       number of the page
     * @param userId     the ID of the User whom's Creations should be returned
     * @param onlyPublic set true to get only approved Creations
     */
    void getByUser(@Nullable Integer page, @NonNull String userId, @Nullable Boolean onlyPublic,
                   ResponseCallback<CreatubblesResponse<List<Creation>>> callback);

    /**
     * @param page       number of the page
     * @param name       keyword to filter Creations by name
     * @param onlyPublic set true to get only approved Creations
     */
    void getByName(@Nullable Integer page, @NonNull String name, @Nullable Boolean onlyPublic,
                   ResponseCallback<CreatubblesResponse<List<Creation>>> callback);


    void getById(@NonNull String creationId, ResponseCallback<CreatubblesResponse<Creation>> callback);

    /**
     * Method used to obtain a list of recommended Creations by given Creation.
     *
     * @param page       number of the page
     * @param onlyPublic set true to get only approved Creations
     */
    void getRecommendedByCreation(@Nullable Integer page, @NonNull String creationId, @Nullable Boolean onlyPublic,
                                  ResponseCallback<CreatubblesResponse<List<Creation>>> callback);

    /**
     * Method used to obtain a list of recommended creations added by given user.
     *
     * @param page       number of the page
     * @param onlyPublic set true to get only approved Creations
     */
    void getRecommendedByUser(@Nullable Integer page, @NonNull String creationId, @Nullable Boolean onlyPublic,
                              ResponseCallback<CreatubblesResponse<List<Creation>>> callback);

    /**
     * Method used to obtain a list of creations by Partner Application.
     */
    void getByPartnerApplication(@Nullable Integer page, @NonNull String partnerApplicationId,
                                 ResponseCallback<CreatubblesResponse<List<Creation>>> callback);

    /**
     * Method used to update Creation with a given ID.
     *
     * @param creationId the ID of Creation to update
     * @param creation   Creation object with values to update. Only a few properties can be modified.
     *                   To create this object use {@link com.creatubbles.api.model.creation.Creation.Builder}
     *                   and set only the properties you want to update.
     */
    void update(@NonNull String creationId, @NonNull Creation creation, ResponseCallback<Void> callback);

    /**
     * Method used to create a new Creation.
     *
     * @param creation Creation instance created using {@link com.creatubbles.api.model.creation.Creation.Builder}.
     */
    void create(@NonNull Creation creation, ResponseCallback<CreatubblesResponse<Creation>> callback);

    /**
     * @param creationId the ID of Creation that should be removed
     */
    void remove(@NonNull String creationId, ResponseCallback<Void> callback);

    /**
     * Method is used to create an instance of {@link Upload} class.
     * That object contains all the information required to upload a file for a given Creation.
     *
     * @param creationId  ID of the Creation for which we want to upload a file
     * @param contentType the content type of the file you intend to upload
     */
    void startUpload(@NonNull String creationId, @NonNull ContentType contentType, ResponseCallback<CreatubblesResponse<Upload>> callback);

    /**
     * Method used to notify the server that the upload was completed.
     * When for some reason upload was aborted or failed then use non-null {@code abortReason} param to indicate the reason.
     *
     * @param upload      object obtained from {@link #startUpload(String, ContentType, ResponseCallback)} method
     * @param abortReason argument included when upload fails. Include the body returned by the failed upload attempt or 'user' in case the user aborted the upload
     */
    void finishUpload(@NonNull Upload upload, @Nullable String abortReason, ResponseCallback<Void> callback);

    /**
     * Method used to modify image of a creation identified by {@code creationId}.
     *
     * @param imageManipulation object describing operations to perform on an image
     */
    void updateImage(@NonNull String creationId, @NonNull ImageManipulation imageManipulation, ResponseCallback<Void> callback);

    /**
     * Method used to obtain toyboo details for specific creation
     *
     * @param creationId the ID of Creation
     */
    void getToybooDetails(@NonNull String creationId, ResponseCallback<CreatubblesResponse<ToybooDetails>> callback);
}
