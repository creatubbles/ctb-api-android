package com.creatubbles.api.model.landing_url;

import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;

/**
 * Landing URLs are used to retrieve application and user specific URLs for various landing pages
 * on the creatubbles website.
 */
@Type("landing_urls")
public class LandingUrl {

    @Id
    private String id;

    private String url;

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "LandingUrl{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
