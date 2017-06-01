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
public interface ApiComponent {

    void inject(OAuthRepositoryBuilder builder);

    void inject(CreationRepositoryBuilder builder);

    void inject(UserRepositoryBuilder builder);

    void inject(GalleryRepositoryBuilder builder);

    void inject(LandingUrlsRepositoryBuilder landingUrlsRepositoryBuilder);

    void inject(CustomStyleRepositoryBuilder customStylesRepositoryBuilder);

    void inject(ActivityRepositoryBuilder target);

    void inject(CommentRepositoryBuilder target);

    void inject(UserFollowingRepositoryBuilder target);

    void inject(GroupRepositoryBuilder target);

    void inject(BubbleRepositoryBuilder target);

    void inject(ReportRepositoryBuilder target);

    void inject(AvatarRepositoryBuilder avatarRepositoryBuilder);

    void inject(NotificationRepositoryBuilder target);

    void inject(AbilityRepositoryBuilder abilityRepositoryBuilder);

    void inject(PartnerApplicationRepositoryBuilder target);

    void inject(ContentRepositoryBuilder target);

    void inject(SchoolRepositoryBuilder target);

    void inject(PrivateRepositoryDependencyProvider target);
}