package com.creatubbles.api.model;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.models.EmptyRelationship;

/**
 * @author Pawel Szymanski
 */
@Type("password_change") //seems that type is irrelevant, but required by JSONApi lib
public class PasswordChange extends EmptyRelationship {

    @Id
    private String id;

    @JsonProperty("password")
    private String newPassword;

    @JsonProperty("current_password")
    private String currentPassword;

    @JsonProperty("password_confirmation")
    private String passwordConfirmation;

    /**
     * Factory method used to create PasswordChange object.
     * This can only be used to change password of managed creator.
     *
     * @see PasswordChange#create(String, String)
     */
    public static PasswordChange create(@NonNull String newPassword) {
        return new PasswordChange(newPassword, null, null);
    }

    /**
     * Factory method used to create PasswordChange object.
     *
     * @see PasswordChange#create(String)
     */
    public static PasswordChange create(@NonNull String newPassword, @NonNull String currentPassword) {
        return new PasswordChange(newPassword, currentPassword, newPassword);
    }

    @JsonCreator
    public PasswordChange() {
    }

    private PasswordChange(String newPassword, String currentPassword, String passwordConfirmation) {
        this.newPassword = newPassword;
        this.passwordConfirmation = passwordConfirmation;
        this.currentPassword = currentPassword;
    }

    public String getId() {
        return id;
    }

    @NonNull
    public String getNewPassword() {
        return newPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    @Override
    public String toString() {
        return "PasswordChange{" +
                "id='" + id + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", currentPassword='" + currentPassword + '\'' +
                ", passwordConfirmation='" + passwordConfirmation + '\'' +
                '}';
    }
}
