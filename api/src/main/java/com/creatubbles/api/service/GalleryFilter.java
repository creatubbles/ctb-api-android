package com.creatubbles.api.service;

/**
 * @author Pawel Szymanski
 */
public class GalleryFilter {
    /**
     * the country name or code
     */
    private final String location;
    /**
     * only galleries collaborated by user specified by this ID
     */
    private final String sharedWith;
    /**
     * only galleries owned by user specified by this ID
     */
    private final String ownedBy;

    public String getLocation() {
        return location;
    }

    public String getSharedWith() {
        return sharedWith;
    }

    public String getOwnedBy() {
        return ownedBy;
    }

    private GalleryFilter(String location, String sharedWith, String ownedBy) {
        this.location = location;
        this.sharedWith = sharedWith;
        this.ownedBy = ownedBy;
    }

    public static class Builder {
        private String location;
        private String sharedWith;
        private String ownedBy;

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setSharedWith(String sharedWith) {
            this.sharedWith = sharedWith;
            return this;
        }

        public Builder setOwnedBy(String ownedBy) {
            this.ownedBy = ownedBy;
            return this;
        }

        public GalleryFilter build() {
            return new GalleryFilter(location, sharedWith, ownedBy);
        }
    }
}
