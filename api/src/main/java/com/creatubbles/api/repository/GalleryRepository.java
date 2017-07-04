package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.GallerySubmission;
import com.creatubbles.api.model.gallery.Gallery;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.GalleryFilter;
import com.creatubbles.api.service.GallerySortMode;

import java.util.List;

/**
 * Class allowing to perform operations o galleries.
 */
public interface GalleryRepository {

    void getPublic(@Nullable Integer page, @Nullable GallerySortMode sort, @Nullable ResponseCallback<CreatubblesResponse<List<Gallery>>> callback);

    void searchPublic(@NonNull String query, @Nullable Integer page, @Nullable GallerySortMode sort, @Nullable ResponseCallback<CreatubblesResponse<List<Gallery>>> callback);

    /**
     * Get current user’s favorite galleries.
     */
    void getFavorite(@Nullable Integer page, @Nullable ResponseCallback<CreatubblesResponse<List<Gallery>>> callback);

    void getFeatured(@Nullable Integer page, @Nullable ResponseCallback<CreatubblesResponse<List<Gallery>>> callback);

    void getById(@Nullable Integer page, @NonNull String galleryId, @Nullable ResponseCallback<CreatubblesResponse<Gallery>> callback);

    /**
     * Create a gallery. This requires user access token.
     */
    void create(@NonNull Gallery gallery, @Nullable ResponseCallback<CreatubblesResponse<Gallery>> callback);

    /**
     * Update a gallery. This requires user access token.
     */
    void update(@NonNull String galleryId, @NonNull Gallery gallery, @Nullable ResponseCallback<Void> callback);

    /**
     * Get galleries shared or owned by current user. If you’re listing galleries without further filters,
     * it’ll return all galleries owned or shared with current user. Shared in this case means the user is either a collaborator
     * of the gallery or the gallery is owned by a managed creator, in which case the manager is implicitly a collaborator on it.
     */
    void getMine(@Nullable Integer page, @Nullable String query, @Nullable GalleryFilter filter, @Nullable ResponseCallback<CreatubblesResponse<List<Gallery>>> callback);

    /**
     * Get galleries owned by a user.
     */
    void getByUser(@Nullable Integer page, @NonNull String userId, @Nullable String query, @Nullable ResponseCallback<CreatubblesResponse<List<Gallery>>> callback);

    /**
     * Get galleries of a creation.
     */
    void getByCreation(@Nullable Integer page, @NonNull String creationId, @Nullable ResponseCallback<CreatubblesResponse<List<Gallery>>> callback);

    /**
     * Submit creation with {@code creationId} to the gallery with {@code galleryId}.
     */
    void submitCreation(@NonNull String galleryId, @NonNull String creationId, @Nullable ResponseCallback<CreatubblesResponse<GallerySubmission>> callback);

    /**
     * Submit creations with ids in {@code creationIds} to the gallery with {@code galleryId}.
     */
    void submitCreations(@NonNull String galleryId, @NonNull List<String> creationIds, @Nullable ResponseCallback<CreatubblesResponse<Gallery>> callback);

    /**
     * Delete creation with {@code creationId} from gallery with {@code galleryId}
     */
    void removeCreations(@NonNull String galleryId, @NonNull List<String> creationId, @Nullable ResponseCallback<Void> callback);
}
