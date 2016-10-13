package com.creatubbles.api.utils;

import android.content.Context;
import android.content.ContextWrapper;

import com.creatubbles.api.exception.ErrorResponse;
import com.creatubbles.api.repository.UploadRepository;
import com.creatubbles.api.repository.UploadRepositoryBuilder;
import com.creatubbles.api.response.ResponseCallback;
import com.pixplicity.easyprefs.library.Prefs;

import java.io.File;
import java.util.LinkedHashSet;

import okhttp3.MediaType;

/**
 * Created by mariuszostapowicz on 08.04.2016.
 */
public class UploadRepositoryCacheUtil {

    public static final String UPLOAD_FILE_NAME_SET_KEY = "uploadFileNameSetKey";
    public static final String UPLOAD_FILE_URL_SET_KEY = "uploadFileUrlSetKey";
    public static final String UPLOAD_FILE_TYPE_SET_KEY = "uploadFileTypeSetKey";
    public static final String CACHE_FILE_NAME = "cacheFileName";

    public static void addFileToSendCache(String url, MediaType contentType, String fileName, Context context) {
        initPrefs(context);
        LinkedHashSet<String> uploadFileNameSet = (LinkedHashSet<String>)Prefs.getOrderedStringSet(UploadRepositoryCacheUtil.UPLOAD_FILE_NAME_SET_KEY, new LinkedHashSet<String>());
        LinkedHashSet<String> uploadFileUrlSet = (LinkedHashSet<String>)Prefs.getOrderedStringSet(UploadRepositoryCacheUtil.UPLOAD_FILE_URL_SET_KEY, new LinkedHashSet<String>());
        LinkedHashSet<String> uploadFileTypeSet = (LinkedHashSet<String>)Prefs.getOrderedStringSet(UploadRepositoryCacheUtil.UPLOAD_FILE_TYPE_SET_KEY, new LinkedHashSet<String>());

        uploadFileNameSet.add(fileName);
        uploadFileUrlSet.add(url);
        uploadFileTypeSet.add(contentType.toString());

        Prefs.putOrderedStringSet(UploadRepositoryCacheUtil.UPLOAD_FILE_NAME_SET_KEY, uploadFileNameSet);
        Prefs.putOrderedStringSet(UploadRepositoryCacheUtil.UPLOAD_FILE_URL_SET_KEY, uploadFileUrlSet);
        Prefs.putOrderedStringSet(UploadRepositoryCacheUtil.UPLOAD_FILE_TYPE_SET_KEY, uploadFileTypeSet);
    }

    public static void removeFileFromSendCache(String url, MediaType contentType, String fileName, Context context) {
        initPrefs(context);
        LinkedHashSet<String> uploadFileNameSet = (LinkedHashSet<String>)Prefs.getOrderedStringSet(UploadRepositoryCacheUtil.UPLOAD_FILE_NAME_SET_KEY, new LinkedHashSet<String>());
        LinkedHashSet<String> uploadFileUrlSet = (LinkedHashSet<String>)Prefs.getOrderedStringSet(UploadRepositoryCacheUtil.UPLOAD_FILE_URL_SET_KEY, new LinkedHashSet<String>());
        LinkedHashSet<String> uploadFileTypeSet = (LinkedHashSet<String>)Prefs.getOrderedStringSet(UploadRepositoryCacheUtil.UPLOAD_FILE_TYPE_SET_KEY, new LinkedHashSet<String>());

        uploadFileNameSet.remove(fileName);
        uploadFileUrlSet.remove(url);
        uploadFileTypeSet.remove(contentType.toString());

        Prefs.putOrderedStringSet(UploadRepositoryCacheUtil.UPLOAD_FILE_NAME_SET_KEY, uploadFileNameSet);
        Prefs.putOrderedStringSet(UploadRepositoryCacheUtil.UPLOAD_FILE_URL_SET_KEY, uploadFileUrlSet);
        Prefs.putOrderedStringSet(UploadRepositoryCacheUtil.UPLOAD_FILE_TYPE_SET_KEY, uploadFileTypeSet);
    }

    public static Boolean isEmptySendCache(Context context) {
        initPrefs(context);
        LinkedHashSet<String> uploadFileNameSet = (LinkedHashSet<String>)Prefs.getOrderedStringSet(UploadRepositoryCacheUtil.UPLOAD_FILE_NAME_SET_KEY, new LinkedHashSet<String>());

        return uploadFileNameSet.isEmpty();
    }

    public static void sendFileFromCache(Context context) {
        initPrefs(context);

        LinkedHashSet<String> uploadFileNameSet = (LinkedHashSet<String>)Prefs.getOrderedStringSet(UploadRepositoryCacheUtil.UPLOAD_FILE_NAME_SET_KEY, new LinkedHashSet<String>());
        LinkedHashSet<String> uploadFileUrlSet = (LinkedHashSet<String>)Prefs.getOrderedStringSet(UploadRepositoryCacheUtil.UPLOAD_FILE_URL_SET_KEY, new LinkedHashSet<String>());
        LinkedHashSet<String> uploadFileTypeSet = (LinkedHashSet<String>)Prefs.getOrderedStringSet(UploadRepositoryCacheUtil.UPLOAD_FILE_TYPE_SET_KEY, new LinkedHashSet<String>());

        String[] uploadFileNameArray = uploadFileNameSet.toArray(new String[uploadFileNameSet.size()]);
        String[] uploadFileUrlArray = uploadFileUrlSet.toArray(new String[uploadFileUrlSet.size()]);
        String[] uploadFileTypeArray = uploadFileTypeSet.toArray(new String[uploadFileTypeSet.size()]);
        for(int i = 0; i < uploadFileNameArray.length; i++) {

            UploadRepository uploadRepository = new UploadRepositoryBuilder()
                    .build();

            uploadRepository.uploadFile(uploadFileUrlArray[i],
                    MediaType.parse(uploadFileTypeArray[i]), new File(uploadFileNameArray[i]), new ResponseCallback<String>() {
                        @Override
                        public void onSuccess(String response) {}

                        @Override
                        public void onServerError(ErrorResponse errorResponse) {}

                        @Override
                        public void onError(String message) {}
                    });
        }
    }

    private static void initPrefs(Context context) {
        new Prefs.Builder()
                .setContext(context)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(UploadRepositoryCacheUtil.CACHE_FILE_NAME)
                .setUseDefaultSharedPreference(true)
                .build();
    }
}
