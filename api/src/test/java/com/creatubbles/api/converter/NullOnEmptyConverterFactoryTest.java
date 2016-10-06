package com.creatubbles.api.converter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import static junit.framework.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Retrofit.class)
public class NullOnEmptyConverterFactoryTest {

    @Mock
    Converter<ResponseBody, Object> delegateConverter;

    private NullOnEmptyConverterFactory target;
    private Retrofit retrofit;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        target = new NullOnEmptyConverterFactory();
        retrofit = PowerMockito.mock(Retrofit.class);
        PowerMockito.when(retrofit.nextResponseBodyConverter(any(Converter.Factory.class), any(Type.class), any(Annotation[].class))).thenReturn(delegateConverter);
    }

    @Test
    public void responseBodyConverterCallsDelegate() throws Exception {
        ResponseBody responseBody = ResponseBody.create(null, new byte[]{1});

        Converter<ResponseBody, ?> responseBodyConverter = target.responseBodyConverter(null, null, retrofit);
        responseBodyConverter.convert(responseBody);

        verify(delegateConverter).convert(responseBody);
    }

    @Test
    public void responseBodyConverterReturnsNull() throws Exception {
        ResponseBody responseBody = ResponseBody.create(null, new byte[0]);

        Converter<ResponseBody, ?> responseBodyConverter = target.responseBodyConverter(null, null, retrofit);
        Object result = responseBodyConverter.convert(responseBody);

        verify(delegateConverter, never()).convert(responseBody);
        assertNull("Result should be null", result);

    }
}