package com.creatubbles.api.model.search;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.models.EmptyRelationship;

@Type("categories")
public class SearchCategory extends EmptyRelationship {
    @Id
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("title_en")
    private String titleEn;

    @JsonProperty("title_it")
    private String titleIt;

    @JsonProperty("title_ja")
    private String titleJa;

    @JsonProperty("slug")
    private String slug;

    @JsonProperty("image")
    private SearchCategoryImage image;

    @JsonProperty("feed_url")
    private String feedUrl;

    @JsonProperty("content_type")
    private String contentType;

    @JsonCreator
    public SearchCategory() {
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public String getTitleIt() {
        return titleIt;
    }

    public String getTitleJa() {
        return titleJa;
    }

    public String getSlug() {
        return slug;
    }

    public SearchCategoryImage getImage() {
        return image;
    }

    public String getFeedUrl() {
        return feedUrl;
    }

    public String getContentType() {
        return contentType;
    }

    @Override
    public String toString() {
        return "SearchCategory{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", titleEn='" + titleEn + '\'' +
                ", titleIt='" + titleIt + '\'' +
                ", titleJa='" + titleJa + '\'' +
                ", slug='" + slug + '\'' +
                ", image=" + image +
                ", feedUrl='" + feedUrl + '\'' +
                ", contentType='" + contentType + '\'' +
                '}';
    }
}
