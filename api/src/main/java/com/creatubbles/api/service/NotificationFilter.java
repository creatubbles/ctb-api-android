package com.creatubbles.api.service;

/**
 * @author Pawel Szymanski
 */
public enum NotificationFilter {
    /**
     * Only notifications about received bubbles.
     */
    BUBBLES("bubbles"),
    /**
     * Only notifications about approved comments.
     */
    COMMENTS_APPROVED("comments_approved"),
    /**
     * Only notifications about pending comments.
     */
    COMMENTS_PENDING("comments_pending"),
    /**
     * Only notifications about declined comments.
     */
    COMMENTS_DECLINED("comments_declined");


    private String name;

    NotificationFilter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
