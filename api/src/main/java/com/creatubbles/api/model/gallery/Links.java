package com.creatubbles.api.model.gallery;

import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("original")
    private String original;

    @SerializedName("header_retina")
    private String headerRetina;

    @SerializedName("header")
    private String header;

    @SerializedName("thumb_retina")
    private String thumbRetina;

    @SerializedName("thumb")
    private String thumb;

    public String getOriginal() {
        return original;
    }

    public String getHeaderRetina() {
        return headerRetina;
    }

    public String getHeader() {
        return header;
    }

    public String getThumbRetina() {
        return thumbRetina;
    }

    public String getThumb() {
        return thumb;
    }

}
