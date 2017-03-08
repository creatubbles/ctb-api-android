package com.creatubbles.api.response;

/**
 * @author Matthew Platek on 11.02.2016.
 */
public interface ProgressResponseCallback<T> extends ResponseCallback<T>{

    void onProgress(float progress);
}
