package com.creatubbles.api.di.components;

import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.repository.AbilityRepositoryBuilder;
import com.creatubbles.api.repository.ActivityRepositoryBuilder;
import com.creatubbles.api.repository.AvatarRepositoryBuilder;
import com.creatubbles.api.repository.BubbleRepositoryBuilder;
import com.creatubbles.api.repository.CommentRepositoryBuilder;
import com.creatubbles.api.repository.ContentRepositoryBuilder;
import com.creatubbles.api.repository.CreationRepositoryBuilder;
import com.creatubbles.api.repository.CustomStyleRepositoryBuilder;
import com.creatubbles.api.repository.GalleryRepositoryBuilder;
import com.creatubbles.api.repository.GroupRepositoryBuilder;
import com.creatubbles.api.repository.LandingUrlsRepositoryBuilder;
import com.creatubbles.api.repository.NotificationRepositoryBuilder;
import com.creatubbles.api.repository.OAuthRepositoryBuilder;
import com.creatubbles.api.repository.PartnerApplicationRepositoryBuilder;
import com.creatubbles.api.repository.PrivateRepositoryDependencyProvider;
import com.creatubbles.api.repository.ReportRepositoryBuilder;
import com.creatubbles.api.repository.SchoolRepositoryBuilder;
import com.creatubbles.api.repository.UserFollowingRepositoryBuilder;
import com.creatubbles.api.repository.UserRepositoryBuilder;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Janek on 16.02.2016.
 */
@Singleton
@Component(modules = ApiModule.class)
public abstract class ApiComponent {

    private static ApiComponent instance;

    public static ApiComponent getInstance(ApiModule apiModule) {
        if (instance == null) {
            synchronized (ApiComponent.class) {
                if (instance == null) {
                    instance = DaggerApiComponent.builder().apiModule(apiModule).build();
                }
            }
        }
        return instance;
    }

    public abstract void inject(OAuthRepositoryBuilder builder);

    public abstract void inject(CreationRepositoryBuilder builder);

    public abstract void inject(UserRepositoryBuilder builder);

    public abstract void inject(GalleryRepositoryBuilder builder);

    public abstract void inject(LandingUrlsRepositoryBuilder landingUrlsRepositoryBuilder);

    public abstract void inject(CustomStyleRepositoryBuilder customStylesRepositoryBuilder);

    public abstract void inject(ActivityRepositoryBuilder target);

    public abstract void inject(CommentRepositoryBuilder target);

    public abstract void inject(UserFollowingRepositoryBuilder target);

    public abstract void inject(GroupRepositoryBuilder target);

    public abstract void inject(BubbleRepositoryBuilder target);

    public abstract void inject(ReportRepositoryBuilder target);

    public abstract void inject(AvatarRepositoryBuilder avatarRepositoryBuilder);

    public abstract void inject(NotificationRepositoryBuilder target);

    public abstract void inject(AbilityRepositoryBuilder abilityRepositoryBuilder);

    public abstract void inject(PartnerApplicationRepositoryBuilder target);

    public abstract void inject(ContentRepositoryBuilder target);

    public abstract void inject(SchoolRepositoryBuilder target);

    public abstract void inject(PrivateRepositoryDependencyProvider target);
}