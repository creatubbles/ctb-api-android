package com.creatubbles.api.request;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;


public class ProgressRequestBody extends RequestBody {

    /**
     * Same as {@link okio.Segment.SIZE}, the size used by okio by default
     */
    private static final int DEFAULT_BUFFER_SIZE = 8192;
    private MediaType contentType;
    private File file;
    private Listener listener;

    public ProgressRequestBody(MediaType contentType, File file, Listener listener) {
        this.contentType = contentType;
        this.file = file;
        this.listener = listener;
    }

    @Override public MediaType contentType() {
        return contentType;
    }

    @Override public long contentLength() {
        return file.length();
    }

    @Override public void writeTo(BufferedSink sink) throws IOException {
        long fileLength = file.length();
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        FileInputStream in = new FileInputStream(file);
        long uploaded = 0;
        try {
            int read;
            listener.onProgress(0);
            while ((read = in.read(buffer)) != -1) {
                uploaded += read;
                sink.write(buffer, 0, read);
                float percentage = (float) uploaded / fileLength;
                listener.onProgress(percentage);
            }
            listener.onProgress(1);
        } finally {
            in.close();
        }
    }

    public interface Listener{
        void onProgress(float progress);
    }
}
