package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.bubble.Bubble;
import com.creatubbles.api.model.bubble.BubbleColor;
import com.creatubbles.api.response.ResponseCallback;

import java.util.List;

/**
 * Class allowing to create/update/delete bubbles on creations/galleries and users.
 *
 * @author Pawel Szymanski
 * @see BubbleRepositoryBuilder
 */
public interface BubbleRepository {

    /**
     * Method is used to obtain bubbles on a Creation with a given {@code creationId}.
     */
    void getForCreation(@Nullable Integer page, @NonNull String creationId, @Nullable ResponseCallback<CreatubblesResponse<List<Bubble>>> callback);

    /**
     * Method is used to obtain bubbles on a Gallery with a given {@code galleryId}.
     */
    void getForGallery(@Nullable Integer page, @NonNull String galleryId, @Nullable ResponseCallback<CreatubblesResponse<List<Bubble>>> callback);

    /**
     * Method is used to obtain bubbles on a User with a given {@code userId}.
     */
    void getForUser(@Nullable Integer page, @NonNull String userId, @Nullable ResponseCallback<CreatubblesResponse<List<Bubble>>> callback);

    /**
     * Method used to create bubble on a creation with a given {@code creationId}.
     * To create an instance of Bubble passed as {@code bubble} use {@link com.creatubbles.api.model.bubble.Bubble.Builder} and set needed fields.
     */
    void createForCreation(@NonNull String creationId, @NonNull Bubble bubble, @Nullable ResponseCallback<CreatubblesResponse<Bubble>> callback);

    /**
     * Method used to create bubble on a gallery with a given {@code galleryId}.
     * To create an instance of Bubble passed as {@code bubble} use {@link com.creatubbles.api.model.bubble.Bubble.Builder} and don't set any fields.
     */
    void createForGallery(@NonNull String galleryId, @NonNull Bubble bubble, @Nullable ResponseCallback<CreatubblesResponse<Bubble>> callback);

    /**
     * Method used to create bubble on a user with a given {@code userId}.
     * To create an instance of Bubble passed as {@code bubble} use {@link com.creatubbles.api.model.bubble.Bubble.Builder} and don't set any fields.
     */
    void createForUser(@NonNull String userId, @NonNull Bubble bubble, @Nullable ResponseCallback<CreatubblesResponse<Bubble>> callback);

    /**
     * Method used to update a bubble with specified {@code bubbleId}.
     * This shoul only be used to update bubbles on creations.
     */
    void update(@NonNull String bubbleId, @NonNull Bubble bubble, @Nullable ResponseCallback<Void> callback);

    /**
     * Method used to delete a bubble with specified {@code bubbleId}.
     */
    void delete(@NonNull String bubbleId, @Nullable ResponseCallback<Void> callback);

    /**
     * Method used to retrieve all available colors for bubbles.
     *
     * @see BubbleColor
     * @see com.creatubbles.api.model.bubble.Bubble.Builder#setColor(String)
     */
    void getColors(@Nullable ResponseCallback<CreatubblesResponse<List<BubbleColor>>> callback);
}
