package com.creatubbles.api.repository;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.user.custom_style.CustomStyle;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.CustomStyleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import retrofit2.Call;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Janek on 24.10.2016.
 */

@RunWith(MockitoJUnitRunner.class)
public class CustomStyleRepositoryTest {

    @Mock
    ResponseCallback<CreatubblesResponse<CustomStyle>> callback;

    @Mock
    CustomStyleService customStyleService;

    @Mock
    Call<JSONAPIDocument<CustomStyle>> call;

    private CustomStyleRepository customStyleRepository;


    @Before
    public void setUp() throws Exception {
        ObjectMapper objectMapper = mock(ObjectMapper.class);
        customStyleRepository = new CustomStyleRepositoryImpl(objectMapper, customStyleService);
    }

    @Test
    public void shouldCallGetCustomStyleOnService() throws Exception {
        when(customStyleService.getCustomStyle(anyString())).thenReturn(call);

        customStyleRepository.getCustomStyle("id", callback);

        verify(customStyleService).getCustomStyle(anyString());
    }

    @Test
    public void shouldCallUpdateCustomStyleOnService() throws Exception {
        when(customStyleService.updateCustomStyle(anyString(), any(CustomStyle.class))).thenReturn(call);

        customStyleRepository.updateCustomStyle("id", new CustomStyle(), callback);

        verify(customStyleService).updateCustomStyle(anyString(), any(CustomStyle.class));
    }
}
