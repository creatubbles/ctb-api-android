package com.creatubbles.api.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.github.jasminb.jsonapi.Links;

public class CreatubblesResponse<D> {

    private D data;

    private Meta meta;

    private Links links;

    public CreatubblesResponse(D data, Meta meta, Links links) {
        this.data = data;
        this.meta = meta;
        this.links = links;
    }

    @NonNull
    public D getData() {
        return data;
    }

    @Nullable
    public Meta getMeta() {
        return meta;
    }

    @Nullable
    public Links getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "CreatubblesResponse{" +
                "data=" + data +
                ", meta=" + meta +
                ", links=" + links +
                '}';
    }
}
