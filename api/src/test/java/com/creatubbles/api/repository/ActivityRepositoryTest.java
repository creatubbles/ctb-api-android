package com.creatubbles.api.repository;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.activity.Activity;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.ActivityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import retrofit2.Call;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Pawel Szymanski
 */
@RunWith(MockitoJUnitRunner.class)
public class ActivityRepositoryTest {

    @Mock
    ResponseCallback<CreatubblesResponse<List<Activity>>> callback;
    @Mock
    ActivityService activityService;
    @Mock
    Call<JSONAPIDocument<List<Activity>>> listCall;

    private ActivityRepository repository;

    @Before
    public void setUp() throws Exception {
        ObjectMapper objectMapper = mock(ObjectMapper.class);
        repository = new ActivityRepositoryImpl(objectMapper, activityService);
    }

    @Test
    public void shouldCallGetActivitiesOnService() throws Exception {
        when(activityService.getActivities(any())).thenReturn(listCall);

        repository.getActivities(anyPage(), callback);

        verify(activityService).getActivities(any());
    }

    private Integer anyPage() {
        return null;
    }
}