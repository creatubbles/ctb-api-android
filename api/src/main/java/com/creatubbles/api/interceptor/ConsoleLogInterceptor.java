package com.creatubbles.api.interceptor;

import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;

public class ConsoleLogInterceptor {

    public static Interceptor forLevel(HttpLoggingInterceptor.Level httpLogLevel) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(httpLogLevel);

        return interceptor;
    }
}
