package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.gallery.Gallery;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.GalleryFilter;
import com.creatubbles.api.service.Sort;

import java.util.List;

/**
 * Class allowing to perform operations o galleries.
 * <p>
 * Access Restrictions
 * <ul>
 * <li>With an application only access token you can only retrieve public galleries (public and non-empty galleries)</li>
 * <li>With an user access token you can list public galleries and the all galleries which belong to the user, including empty ones.</li>
 * </ul>
 * </p>
 */
public interface GalleryRepository {

    void getPublic(@Nullable Integer page, @Nullable Sort sort, ResponseCallback<CreatubblesResponse<List<Gallery>>> callback);

    /**
     * Get current user’s favorite galleries.
     */
    void getFavorite(@Nullable Integer page, ResponseCallback<CreatubblesResponse<List<Gallery>>> callback);

    void getFeatured(@Nullable Integer page, ResponseCallback<CreatubblesResponse<List<Gallery>>> callback);

    void getById(@Nullable Integer page, @NonNull String galleryId, ResponseCallback<CreatubblesResponse<Gallery>> callback);

    /**
     * Create a gallery. This requires user access token.
     */
    void create(@NonNull Gallery gallery, ResponseCallback<CreatubblesResponse<Gallery>> callback);

    /**
     * Update a gallery. This requires user access token.
     */
    void update(@NonNull String galleryId, @NonNull Gallery gallery, ResponseCallback<Void> callback);

    /**
     * Get galleries shared or owned by current user. If you’re listing galleries without further filters,
     * it’ll return all galleries owned or shared with current user. Shared in this case means the user is either a collaborator
     * of the gallery or the gallery is owned by a managed creator, in which case the manager is implicitly a collaborator on it.
     */
    void getMine(@Nullable Integer page, @Nullable GalleryFilter filter, ResponseCallback<CreatubblesResponse<List<Gallery>>> callback);

    /**
     * Get galleries owned by a user.
     */
    void getByUser(@Nullable Integer page, @NonNull String userId, ResponseCallback<CreatubblesResponse<List<Gallery>>> callback);

    /**
     * Get galleries of a creation.
     */
    void getByCreation(@Nullable Integer page, @NonNull String creationId, ResponseCallback<CreatubblesResponse<List<Gallery>>> callback);
}
