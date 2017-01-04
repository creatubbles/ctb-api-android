package com.creatubbles.api.model.notification;

import android.support.annotation.NonNull;

import com.creatubbles.api.model.user.User;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

/**
 * @author Pawel Szymanski
 */
@Type("user_entities")
public class UserEntity extends Entity {

    @Relationship("user")
    private User user;

    @NonNull
    public User getUser() {
        return user;
    }
}
