package com.creatubbles.api.model;

import com.github.jasminb.jsonapi.Links;

public class CtbResponse<D> {

    private D data;

    private Meta meta;

    private Links links;

    public CtbResponse(D data, Meta meta, Links links) {
        this.data = data;
        this.meta = meta;
        this.links = links;
    }

    public D getData() {
        return data;
    }

    public Meta getMeta() {
        return meta;
    }

    public Links getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "CtbResponse{" +
                "data=" + data +
                ", meta=" + meta +
                ", links=" + links +
                '}';
    }
}
