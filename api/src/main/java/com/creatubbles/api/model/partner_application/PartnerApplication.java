package com.creatubbles.api.model.partner_application;

import android.support.annotation.Nullable;

import com.creatubbles.api.model.ImageLinks;
import com.creatubbles.api.model.gallery.Gallery;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import java.util.Date;
import java.util.List;

/**
 * @author Pawel Szymanski
 */
@Type("partner-applications")
public class PartnerApplication {

    @Id
    private String id;

    private String name;

    private String slug;

    @JsonProperty("short_url")
    private String shortUrl;

    @JsonProperty("header_bg")
    private ImageLinks headerBg;

    @JsonProperty("body_bg")
    private ImageLinks bodyBg;

    private String description;

    @JsonProperty("cta_logged_in_label")
    private String ctaLoggedInLabel;

    @JsonProperty("cta_logged_out_label")
    private String ctaLoggedOutLabel;

    @JsonProperty("reqeust_cta_for_youngsters") // intentional typo
    private Boolean requestCtaForYoungsters;

    @JsonProperty("cta_for_youngsters_label")
    private String ctaForYoungstersLabel;

    @JsonProperty("cta_href")
    private String ctaHref;

    private String categories;

    private String age;

    private String languages;

    private String support;

    private String developers;

    private String platforms;

    @JsonProperty("show_other_apps")
    private Boolean showOtherApps;

    @JsonProperty("display_creations_nr")
    private Integer displayCreationsNr;

    @JsonProperty("about_card_text")
    private String aboutCardText;

    @JsonProperty("meta_title")
    private String metaTitle;

    @JsonProperty("meta_description")
    private String metaDescription;

    @JsonProperty("meta_keywords")
    private String metaKeywords;

    @JsonProperty("meta_og_title")
    private String metaOgTitle;

    @JsonProperty("meta_og_description")
    private String metaOgDescription;

    @JsonProperty("meta_og_type")
    private String metaOgType;

    @JsonProperty("meta_og_image")
    private String metaOgImage;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;


    @Relationship("gallery")
    private Gallery gallery;

    @Relationship("related_apps")
    private List<PartnerApplication> relatedApps;

    @Relationship("app_screenshots")
    private List<AppScreenshot> appScreenshots;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public ImageLinks getHeaderBg() {
        return headerBg;
    }

    public ImageLinks getBodyBg() {
        return bodyBg;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    @Nullable
    public String getCtaLoggedInLabel() {
        return ctaLoggedInLabel;
    }

    @Nullable
    public String getCtaLoggedOutLabel() {
        return ctaLoggedOutLabel;
    }

    public Boolean getRequestCtaForYoungsters() {
        return requestCtaForYoungsters;
    }

    @Nullable
    public String getCtaForYoungstersLabel() {
        return ctaForYoungstersLabel;
    }

    @Nullable
    public String getCtaHref() {
        return ctaHref;
    }

    @Nullable
    public String getCategories() {
        return categories;
    }

    @Nullable
    public String getAge() {
        return age;
    }

    @Nullable
    public String getLanguages() {
        return languages;
    }

    @Nullable
    public String getSupport() {
        return support;
    }

    @Nullable
    public String getDevelopers() {
        return developers;
    }

    @Nullable
    public String getPlatforms() {
        return platforms;
    }

    public Boolean getShowOtherApps() {
        return showOtherApps;
    }

    @Nullable
    public Integer getDisplayCreationsNr() {
        return displayCreationsNr;
    }

    @Nullable
    public String getAboutCardText() {
        return aboutCardText;
    }

    @Nullable
    public String getMetaTitle() {
        return metaTitle;
    }

    @Nullable
    public String getMetaDescription() {
        return metaDescription;
    }

    @Nullable
    public String getMetaKeywords() {
        return metaKeywords;
    }

    @Nullable
    public String getMetaOgTitle() {
        return metaOgTitle;
    }

    @Nullable
    public String getMetaOgDescription() {
        return metaOgDescription;
    }

    @Nullable
    public String getMetaOgType() {
        return metaOgType;
    }

    @Nullable
    public String getMetaOgImage() {
        return metaOgImage;
    }

    @Nullable
    public String getAvatarUrl() {
        return avatarUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Gallery getGallery() {
        return gallery;
    }

    /**
     * Other apps from the same owner
     */
    @Nullable
    public List<PartnerApplication> getRelatedApps() {
        return relatedApps;
    }

    @Nullable
    public List<AppScreenshot> getAppScreenshots() {
        return appScreenshots;
    }

    @Override
    public String toString() {
        return "PartnerApplication{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", headerBg=" + headerBg +
                ", bodyBg=" + bodyBg +
                ", description='" + description + '\'' +
                ", ctaLoggedInLabel='" + ctaLoggedInLabel + '\'' +
                ", ctaLoggedOutLabel='" + ctaLoggedOutLabel + '\'' +
                ", requestCtaForYoungsters=" + requestCtaForYoungsters +
                ", ctaForYoungstersLabel='" + ctaForYoungstersLabel + '\'' +
                ", ctaHref='" + ctaHref + '\'' +
                ", categories='" + categories + '\'' +
                ", age='" + age + '\'' +
                ", languages='" + languages + '\'' +
                ", support='" + support + '\'' +
                ", developers='" + developers + '\'' +
                ", platforms='" + platforms + '\'' +
                ", showOtherApps=" + showOtherApps +
                ", displayCreationsNr=" + displayCreationsNr +
                ", aboutCardText='" + aboutCardText + '\'' +
                ", metaTitle='" + metaTitle + '\'' +
                ", metaDescription='" + metaDescription + '\'' +
                ", metaKeywords='" + metaKeywords + '\'' +
                ", metaOgTitle='" + metaOgTitle + '\'' +
                ", metaOgDescription='" + metaOgDescription + '\'' +
                ", metaOgType='" + metaOgType + '\'' +
                ", metaOgImage='" + metaOgImage + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", gallery=" + gallery +
                ", relatedApps=" + relatedApps +
                ", appScreenshots=" + appScreenshots +
                '}';
    }
}
