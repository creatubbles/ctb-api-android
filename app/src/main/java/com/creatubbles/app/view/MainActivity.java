package com.creatubbles.app.view;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import com.creatubbles.api.ContentType;
import com.creatubbles.api.exception.ErrorResponse;
import com.creatubbles.api.model.Ability;
import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.GallerySubmission;
import com.creatubbles.api.model.ObjectType;
import com.creatubbles.api.model.Operation;
import com.creatubbles.api.model.PasswordChange;
import com.creatubbles.api.model.Report;
import com.creatubbles.api.model.activity.Activity;
import com.creatubbles.api.model.auth.AccessToken;
import com.creatubbles.api.model.auth.ApplicationAccessToken;
import com.creatubbles.api.model.auth.UserAccessToken;
import com.creatubbles.api.model.bubble.Bubble;
import com.creatubbles.api.model.bubble.BubbleColor;
import com.creatubbles.api.model.comment.Comment;
import com.creatubbles.api.model.content.Content;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.creation.ToybooDetails;
import com.creatubbles.api.model.gallery.Gallery;
import com.creatubbles.api.model.group.Group;
import com.creatubbles.api.model.image_manipulation.Cropping;
import com.creatubbles.api.model.image_manipulation.ImageManipulation;
import com.creatubbles.api.model.image_manipulation.Rotation;
import com.creatubbles.api.model.landing_url.LandingUrl;
import com.creatubbles.api.model.landing_url.LandingUrlType;
import com.creatubbles.api.model.notification.Notification;
import com.creatubbles.api.model.partner_application.PartnerApplication;
import com.creatubbles.api.model.school.School;
import com.creatubbles.api.model.upload.Upload;
import com.creatubbles.api.model.user.AccountDetails;
import com.creatubbles.api.model.user.MultipleCreators;
import com.creatubbles.api.model.user.NewUser;
import com.creatubbles.api.model.user.User;
import com.creatubbles.api.model.user.UserFollowing;
import com.creatubbles.api.model.user.avatar.Avatar;
import com.creatubbles.api.model.user.avatar.AvatarSuggestion;
import com.creatubbles.api.model.user.custom_style.AgeDisplayType;
import com.creatubbles.api.model.user.custom_style.CustomStyle;
import com.creatubbles.api.repository.AbilityRepository;
import com.creatubbles.api.repository.AbilityRepositoryBuilder;
import com.creatubbles.api.repository.ActivityRepository;
import com.creatubbles.api.repository.ActivityRepositoryBuilder;
import com.creatubbles.api.repository.AvatarRepository;
import com.creatubbles.api.repository.AvatarRepositoryBuilder;
import com.creatubbles.api.repository.BubbleRepository;
import com.creatubbles.api.repository.BubbleRepositoryBuilder;
import com.creatubbles.api.repository.CommentRepository;
import com.creatubbles.api.repository.CommentRepositoryBuilder;
import com.creatubbles.api.repository.ContentRepository;
import com.creatubbles.api.repository.ContentRepositoryBuilder;
import com.creatubbles.api.repository.CreationRepository;
import com.creatubbles.api.repository.CreationRepositoryBuilder;
import com.creatubbles.api.repository.CustomStyleRepository;
import com.creatubbles.api.repository.CustomStyleRepositoryBuilder;
import com.creatubbles.api.repository.GalleryRepository;
import com.creatubbles.api.repository.GalleryRepositoryBuilder;
import com.creatubbles.api.repository.GroupRepository;
import com.creatubbles.api.repository.GroupRepositoryBuilder;
import com.creatubbles.api.repository.LandingUrlsRepository;
import com.creatubbles.api.repository.LandingUrlsRepositoryBuilder;
import com.creatubbles.api.repository.NotificationRepository;
import com.creatubbles.api.repository.NotificationRepositoryBuilder;
import com.creatubbles.api.repository.OAuthRepository;
import com.creatubbles.api.repository.OAuthRepositoryBuilder;
import com.creatubbles.api.repository.PartnerApplicationRepository;
import com.creatubbles.api.repository.PartnerApplicationRepositoryBuilder;
import com.creatubbles.api.repository.ReportRepository;
import com.creatubbles.api.repository.ReportRepositoryBuilder;
import com.creatubbles.api.repository.SchoolRepository;
import com.creatubbles.api.repository.SchoolRepositoryBuilder;
import com.creatubbles.api.repository.UploadRepository;
import com.creatubbles.api.repository.UploadRepositoryBuilder;
import com.creatubbles.api.repository.UserFollowingRepository;
import com.creatubbles.api.repository.UserFollowingRepositoryBuilder;
import com.creatubbles.api.repository.UserRepository;
import com.creatubbles.api.repository.UserRepositoryBuilder;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.app.R;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.MediaType;


public class MainActivity extends AppCompatActivity {

    @Bind({R.id.get_user_btn, R.id.get_user_creators_btn, R.id.create_user_btn, R.id.create_gallery_btn,
            R.id.get_galleries_btn, R.id.create_creation_btn, R.id.get_all_landing_urls_btn,
            R.id.get_specific_landing_url_btn, R.id.get_user_managers_btn, R.id.get_user_connections_btn,
            R.id.get_user_followed_btn, R.id.get_switch_users_btn, R.id.create_multiple_users_btn,
            R.id.get_creators_from_group_btn, R.id.get_recent_creations_btn, R.id.get_activities_btn,
            R.id.follow_user_btn, R.id.unfollow_user_btn, R.id.get_groups_btn, R.id.get_bubble_colors_btn,
            R.id.get_user_details_btn, R.id.get_avatar_suggestion, R.id.get_notifications_btn,
            R.id.update_last_viewed_time_btn, R.id.get_toyboo_details_btn, R.id.find_partner_applications,
            R.id.get_partner_app_by_id, R.id.get_content_btn, R.id.get_recent_content_btn, R.id.get_followed_content_btn,
            R.id.get_trending_content_btn, R.id.get_connected_content_btn, R.id.get_schools_btn})
    List<Button> actionButtons;

    @Bind(R.id.send_file_btn)
    Button sendFileBtn;
    @Bind(R.id.authorize_btn)
    Button authorizeBtn;
    @Bind(R.id.file_name)
    EditText fileName;
    @Bind(R.id.scrollview)
    ScrollView scrollView;
    @Bind(R.id.switch_btn)
    Button switchBtn;
    @Bind(R.id.email_edit_text)
    EditText emailText;
    @Bind(R.id.password_edit_text)
    EditText passwordText;
    @Bind(R.id.get_custom_style_btn)
    Button getCustomStyleBtn;
    @Bind(R.id.update_custom_style_btn)
    Button updateCustomStyleBtn;
    @Bind(R.id.get_user_comments_btn)
    Button getUserComments;
    @Bind(R.id.create_user_comment_btn)
    Button createUserComment;
    @Bind(R.id.update_group_btn)
    Button updateGroup;
    @Bind(R.id.delete_group_btn)
    Button deleteGroup;
    @Bind(R.id.submit_creation_btn)
    Button submitCreation;
    @Bind(R.id.update_bubble_btn)
    Button updateBubble;
    @Bind(R.id.delete_bubble_btn)
    Button deleteBubble;
    @Bind(R.id.update_avatar)
    Button updateAvatar;

    Upload responseFromCreateUpload;
    List<User> usersAvailableForSwitching;
    AccessToken accessToken;
    String userId;
    Group newGroup;
    String galleryId;
    String creationId;
    String bubbleId;
    AvatarSuggestion avatarSuggestion;
    String notificationId;
    String commentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        scrollView.requestFocus();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onAuthorizeClicked(View btn) {

        OAuthRepository repository = new OAuthRepositoryBuilder().build();

        if (TextUtils.isEmpty(emailText.getText())) {
            repository.authorize(new ResponseCallback<ApplicationAccessToken>() {
                @Override
                public void onSuccess(ApplicationAccessToken response) {
                    onSuccessAuth(response);
                }

                @Override
                public void onServerError(ErrorResponse errorResponse) {
                    displayError(errorResponse);
                }

                @Override
                public void onError(String message) {

                }
            });
        } else {
            repository.authorize(emailText.getText().toString(), passwordText.getText().toString(),
                    new ResponseCallback<UserAccessToken>() {
                        @Override
                        public void onSuccess(UserAccessToken response) {
                            onSuccessAuth(response);
                        }

                        @Override
                        public void onServerError(ErrorResponse errorResponse) {
                            displayError(errorResponse);
                        }

                        @Override
                        public void onError(String message) {

                        }
                    });
        }
    }

    void onSuccessAuth(AccessToken response) {
        Toast.makeText(MainActivity.this, response.getToken(), Toast
                .LENGTH_SHORT).show();

        accessToken = response;
        ButterKnife.apply(actionButtons, (view, index) -> view.setEnabled(true));
    }

    public void onSwitchClicked(View btn) {
        OAuthRepository repository = new OAuthRepositoryBuilder().build();

        repository.switchUser((UserAccessToken) accessToken, usersAvailableForSwitching.get(0).getId(), null, new ResponseCallback<UserAccessToken>() {
            @Override
            public void onSuccess(UserAccessToken response) {
                Toast.makeText(MainActivity.this, response.getToken(), Toast
                        .LENGTH_SHORT).show();

                accessToken = response;
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void getUserClicked(View btn) {
        UserRepository userRepository = new UserRepositoryBuilder(accessToken)
                .build();
        getUser(userRepository::getUser);
    }

    public void onGetUserCreatorsClicked(View btn) {
        UserRepository userRepository = new UserRepositoryBuilder(accessToken)
                .build();
        getUserList((page, callback) -> userRepository.getCreators(page, null, callback));
    }

    public void onGetUserConnectionsClicked(View view) {
        UserRepository userRepository = new UserRepositoryBuilder(accessToken)
                .build();
        getUserList((page, callback) -> userRepository.getConnections(page, null, callback));
    }

    public void onGetUserFollowedClicked(View view) {
        UserRepository userRepository = new UserRepositoryBuilder(accessToken)
                .build();
        getUserList((page, callback) -> userRepository.getFollowedUsers(page, null, callback));
    }

    public void onGetUserManagersClicked(View btn) {
        UserRepository userRepository = new UserRepositoryBuilder(accessToken)
                .build();
        getUserList((page, callback) -> userRepository.getManagers(page, null, callback));
    }

    public void onGetSwitchUsersClicked(View btn) {
        UserRepository userRepository = new UserRepositoryBuilder(accessToken)
                .build();
        getUserList(userRepository::getUsersAvailableForSwitching);

        switchBtn.setEnabled(true);
    }

    public void onGetCreatorsFromGroup(View btn) {
        UserRepository userRepository = new UserRepositoryBuilder(accessToken)
                .build();
        userRepository.getCreatorsFromGroup("9320", null, getUserListCallback());
    }

    public void onUpdateAvatarClicked(View btn) {
        AvatarRepository avatarRepository = new AvatarRepositoryBuilder((UserAccessToken) accessToken)
                .build();
        avatarRepository.updateAvatar(userId, new Avatar.Builder().avatarSuggestion(avatarSuggestion).build(), new ResponseCallback<CreatubblesResponse<Avatar>>() {
            @Override
            public void onSuccess(CreatubblesResponse<Avatar> response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast
                        .LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                Toast.makeText(MainActivity.this, "server error", Toast
                        .LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onError(String message) {
                Toast.makeText(MainActivity.this, "error", Toast
                        .LENGTH_SHORT)
                        .show();
                System.out.println(message);
            }
        });
    }

    public void onGetSuggestedAvatarClicked(View btn) {
        AvatarRepository avatarRepository = new AvatarRepositoryBuilder((UserAccessToken) accessToken).build();
        avatarRepository.getSuggestedAvatars(new ResponseCallback<CreatubblesResponse<List<AvatarSuggestion>>>() {
            @Override
            public void onSuccess(CreatubblesResponse<List<AvatarSuggestion>> response) {
                if (response != null) {
                    avatarSuggestion = response.getData().get(0);
                    Toast.makeText(MainActivity.this, avatarSuggestion.toString(), Toast
                            .LENGTH_SHORT)
                            .show();
                }
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {

            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onCreateUserClicked(View btn) {
        UserRepository userRepository = new UserRepositoryBuilder(accessToken)
                .build();

        NewUser user = new NewUser.Builder("testCreator90123")
                .build();
        userRepository.createUser(user, new ResponseCallback<CreatubblesResponse<User>>() {
            @Override
            public void onSuccess(CreatubblesResponse<User> response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast
                        .LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onCreateMultipleUsersClicked(View view) {
        UserRepository userRepository = new UserRepositoryBuilder(accessToken)
                .build();
        MultipleCreators multipleCreators = new MultipleCreators.Builder(5, 2000)
                .setGroup("TestGroup" + new Random().nextInt(50))
                .build();

        userRepository.createMultipleCreators(multipleCreators, new ResponseCallback<CreatubblesResponse<MultipleCreators>>() {
            @Override
            public void onSuccess(CreatubblesResponse<MultipleCreators> response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast
                        .LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    private void getUser(Function<ResponseCallback<CreatubblesResponse<User>>> f) {
        f.consume(new ResponseCallback<CreatubblesResponse<User>>() {
            @Override
            public void onSuccess(CreatubblesResponse<User> response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                userId = response.getData().getId();
                findViewById(R.id.get_bubbles_on_user_btn).setEnabled(true);
                findViewById(R.id.create_bubble_on_user_btn).setEnabled(true);
                getCustomStyleBtn.setEnabled(true);
                updateCustomStyleBtn.setEnabled(true);
                getUserComments.setEnabled(true);
                createUserComment.setEnabled(true);
                findViewById(R.id.update_account_btn).setEnabled(true);
                findViewById(R.id.link_school_btn).setEnabled(true);
                findViewById(R.id.change_password_btn).setEnabled(true);
                updateAvatar.setEnabled(true);
                findViewById(R.id.report_user_btn).setEnabled(true);
                findViewById(R.id.get_ability).setEnabled(true);
                findViewById(R.id.get_content_by_user_btn).setEnabled(true);
                findViewById(R.id.get_content_bubbled_by_user_btn).setEnabled(true);
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    private void getUserList(BiFunction<Integer, ResponseCallback<CreatubblesResponse<List<User>>>> f) {
        f.consume(null, getUserListCallback());
    }

    @NonNull
    private ResponseCallback<CreatubblesResponse<List<User>>> getUserListCallback() {
        return new ResponseCallback<CreatubblesResponse<List<User>>>() {
            public void onSuccess(CreatubblesResponse<List<User>> response) {
                if (response.getData().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Success but no results", Toast
                            .LENGTH_SHORT).show();
                } else {
                    usersAvailableForSwitching = response.getData();
                    Toast.makeText(MainActivity.this, "Success: total users:" + response.getMeta().getTotalCount(),
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                Toast.makeText(MainActivity.this, errorResponse.toString(), Toast
                        .LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onError(String message) {

            }
        };
    }

    public void onCreateCreationClicked(View btn) {
        CreationRepository creationRepository = new CreationRepositoryBuilder(accessToken)
                .build();

        Creation newCreation = new Creation.Builder("testCreation", Collections.emptyList()).build();
        creationRepository.create(newCreation, new
                ResponseCallback<CreatubblesResponse<Creation>>() {
                    @Override
                    public void onSuccess(CreatubblesResponse<Creation> response) {
                        Toast.makeText(MainActivity.this, response.toString(), Toast
                                .LENGTH_SHORT)
                                .show();
                        creationId = response.getData().getId();
                        findViewById(R.id.create_upload_btn).setEnabled(true);
                        findViewById(R.id.get_creation_by_id_btn).setEnabled(true);
                        findViewById(R.id.modify_image_btn).setEnabled(true);
                        findViewById(R.id.create_bubble_on_creation_btn).setEnabled(true);
                        findViewById(R.id.get_bubbles_on_creation_btn).setEnabled(true);
                        findViewById(R.id.get_landing_url_for_creation_btn).setEnabled(true);
                        findViewById(R.id.report_creation_btn).setEnabled(true);
                        if (galleryId != null) {
                            submitCreation.setEnabled(true);
                        }
                    }

                    @Override
                    public void onError(String error) {
                        Toast.makeText(MainActivity.this, "error", Toast
                                .LENGTH_SHORT)
                                .show();
                    }

                    @Override
                    public void onServerError(ErrorResponse errorResponse) {
                        displayError(errorResponse);
                    }
                });
    }

    public void onGetRecentCreationsClicked(View view) {
        CreationRepository creationRepository = new CreationRepositoryBuilder(accessToken)
                .build();
        creationRepository.getRecent(null, Boolean.FALSE, new ResponseCallback<CreatubblesResponse<List<Creation>>>() {
            @Override
            public void onSuccess(CreatubblesResponse<List<Creation>> response) {
                Toast.makeText(MainActivity.this, "Creations: " + response.getMeta().getTotalCount(),
                        Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {
                Toast.makeText(MainActivity.this, message, Toast
                        .LENGTH_SHORT)
                        .show();
            }
        });
    }

    public void onCreateUploadClicked(View btn) {
        CreationRepository creationRepository = new CreationRepositoryBuilder(accessToken)
                .build();

        creationRepository.startUpload(creationId, ContentType.JPG,
                new ResponseCallback<CreatubblesResponse<Upload>>() {
                    @Override
                    public void onSuccess(CreatubblesResponse<Upload> response) {
                        Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT)
                                .show();

                        responseFromCreateUpload = response.getData();
                        sendFileBtn.setEnabled(true);
                        fileName.setEnabled(true);
                    }

                    @Override
                    public void onServerError(ErrorResponse errorResponse) {

                    }

                    @Override
                    public void onError(String message) {

                    }
                });

    }

    public void onGetCreationByIdClicked(View btn) {
        CreationRepository creationRepository = new CreationRepositoryBuilder(accessToken)
                .build();
        creationRepository.getById(creationId, new ResponseCallback<CreatubblesResponse<Creation>>() {
            @Override
            public void onSuccess(CreatubblesResponse<Creation> response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast
                        .LENGTH_LONG).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[]
            grantResults) {
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {

                sendFile();
            }
        }
    }

    public void onSendFileClicked(View btn) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager
                .PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        } else {
            sendFile();
        }
    }


    private void sendFile() {
        String filePath = fileName.getText().toString();
        if (filePath.length() <= 0) {
            fileName.setError("Enter file name with full path");
        } else {
            File file = new File(filePath);

            UploadRepository uploadRepository = new UploadRepositoryBuilder()
                    .build();
            uploadRepository.uploadFile(responseFromCreateUpload.getUrl(),
                    MediaType.parse(responseFromCreateUpload.getContentType()), file, new ResponseCallback<String>() {
                        @Override
                        public void onSuccess(String response) {

                            CreationRepository creationRepository = new CreationRepositoryBuilder(accessToken)
                                    .build();
                            creationRepository.finishUpload(responseFromCreateUpload, null,
                                    new ResponseCallback<Void>() {
                                        @Override
                                        public void onSuccess(Void response) {
                                            Toast.makeText(MainActivity.this, "Successful uploading!", Toast
                                                    .LENGTH_SHORT).show();
                                        }

                                        @Override
                                        public void onServerError(ErrorResponse errorResponse) {

                                        }

                                        @Override
                                        public void onError(String message) {

                                        }
                                    });
                        }

                        @Override
                        public void onServerError(ErrorResponse errorResponse) {
                            Log.e("TEST", errorResponse.getErrors().get(0).getDetail());
                        }

                        @Override
                        public void onError(String message) {
                            Log.e("TEST", message);
                        }
                    });
        }
    }

    public void onCreateGalleryClicked(View view) {
        GalleryRepository galleryRepository = new GalleryRepositoryBuilder(accessToken).build();

        Gallery gallery = new Gallery("myNewGallery2", "TestGallery", true, null);
        galleryRepository.create(gallery, new ResponseCallback<CreatubblesResponse<Gallery>>() {
            @Override
            public void onSuccess(CreatubblesResponse<Gallery> response) {
                Toast.makeText(MainActivity.this, "Gallery Created", Toast.LENGTH_SHORT).show();
                galleryId = response.getData().getId();
                findViewById(R.id.create_bubble_on_gallery_btn).setEnabled(true);
                findViewById(R.id.get_bubbles_on_creation_btn).setEnabled(true);
                findViewById(R.id.report_gallery_btn).setEnabled(true);
                if (creationId != null) {
                    submitCreation.setEnabled(true);
                }
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onGetGalleriesByIdClicked(View view) {
        GalleryRepository galleryRepository = new GalleryRepositoryBuilder(accessToken)
                .build();

        galleryRepository.getMine(null, null, new ResponseCallback<CreatubblesResponse<List<Gallery>>>() {
            @Override
            public void onSuccess(CreatubblesResponse<List<Gallery>> response) {
                Toast.makeText(MainActivity.this, "Galleries total count: " + response.getMeta().getTotalCount(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onGetAllLandingUrlsClicked(View view) {
        LandingUrlsRepository repository = new LandingUrlsRepositoryBuilder(accessToken)
                .build();

        repository.getAll(new ResponseCallback<CreatubblesResponse<List<LandingUrl>>>() {
            @Override
            public void onSuccess(CreatubblesResponse<List<LandingUrl>> response) {
                for (LandingUrl url : response.getData()) {
                    Toast.makeText(MainActivity.this, url.toString(), Toast
                            .LENGTH_SHORT).show();
                }

            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onGetSpecificLandingUrlClicked(View view) {

        LandingUrlsRepository repository = new LandingUrlsRepositoryBuilder(accessToken)
                .build();

        repository.getSpecific(LandingUrlType.COMMON_REGISTRATION, new
                ResponseCallback<CreatubblesResponse<LandingUrl>>() {


                    @Override
                    public void onSuccess(CreatubblesResponse<LandingUrl> response) {
                        Toast.makeText(MainActivity.this, response.toString(), Toast
                                .LENGTH_SHORT).show();
                    }

                    @Override
                    public void onServerError(ErrorResponse errorResponse) {
                        displayError(errorResponse);
                    }

                    @Override
                    public void onError(String message) {

                    }
                });

        repository.getSpecific(LandingUrlType.USER_PROFILE, new
                ResponseCallback<CreatubblesResponse<LandingUrl>>() {


                    @Override
                    public void onSuccess(CreatubblesResponse<LandingUrl> response) {
                        Toast.makeText(MainActivity.this, response.toString(), Toast
                                .LENGTH_SHORT).show();
                    }

                    @Override
                    public void onServerError(ErrorResponse errorResponse) {
                        displayError(errorResponse);
                    }

                    @Override
                    public void onError(String message) {

                    }
                });
    }

    public void onGetLandingUrlForCreationClicked(View view) {

        LandingUrlsRepository repository = new LandingUrlsRepositoryBuilder(accessToken)
                .build();

        repository.getForCreation(creationId, new ResponseCallback<CreatubblesResponse<LandingUrl>>() {
            @Override
            public void onSuccess(CreatubblesResponse<LandingUrl> response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast
                        .LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onGetCustomStyleClicked(View btn) {
        CustomStyleRepository customStyleRepository = new CustomStyleRepositoryBuilder(accessToken)
                .build();
        customStyleRepository.getCustomStyle(userId, new ResponseCallback<CreatubblesResponse<CustomStyle>>() {
            @Override
            public void onSuccess(CreatubblesResponse<CustomStyle> response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast
                        .LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onUpdateCustomStyleClicked(View btn) {
        CustomStyleRepository customStyleRepository = new CustomStyleRepositoryBuilder(accessToken)
                .build();
        List<String> colors = Arrays.asList("#C0C0C0", "#DD1F26", "#BC2025");
        customStyleRepository.updateCustomStyle(userId, new CustomStyle("style1", "pattern0", "pattern0", "Arial", "My bio", colors, colors), new ResponseCallback<CreatubblesResponse<CustomStyle>>() {
            @Override
            public void onSuccess(CreatubblesResponse<CustomStyle> response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast
                        .LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onGetActivitiesClicked(View btn) {
        ActivityRepository activityRepository = new ActivityRepositoryBuilder(accessToken)
                .build();

        activityRepository.getActivities(null, new ResponseCallback<CreatubblesResponse<List<Activity>>>() {
            @Override
            public void onSuccess(CreatubblesResponse<List<Activity>> response) {
                Toast.makeText(MainActivity.this, "Total activities: " + response.getMeta().getTotalCount(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onGetUserComments(View view) {
        CommentRepository commentRepository = new CommentRepositoryBuilder(accessToken)
                .build();

        commentRepository.getForUser(null, userId, new ResponseCallback<CreatubblesResponse<List<Comment>>>() {
            @Override
            public void onSuccess(CreatubblesResponse<List<Comment>> response) {
                Toast.makeText(MainActivity.this, "Total comments: " + response.getMeta().getTotalCount(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onCreateUserComments(View view) {
        CommentRepository commentRepository = new CommentRepositoryBuilder(accessToken)
                .build();
        Comment comment = Comment.create("Test comment");
        commentRepository.createForUser(comment, userId, new ResponseCallback<CreatubblesResponse<Comment>>() {
            @Override
            public void onSuccess(CreatubblesResponse<Comment> response) {
                Toast.makeText(MainActivity.this, response.toString(),
                        Toast.LENGTH_SHORT).show();
                commentId = response.getData().getId();
                findViewById(R.id.report_comment_btn).setEnabled(true);
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onFollowUserClicked(View view) {
        UserFollowingRepository repository = new UserFollowingRepositoryBuilder((UserAccessToken) accessToken)
                .build();
        repository.follow("l8mD9WMm", new ResponseCallback<CreatubblesResponse<UserFollowing>>() {
            @Override
            public void onSuccess(CreatubblesResponse<UserFollowing> response) {
                Toast.makeText(MainActivity.this, "User followed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onUnfollowUserClicked(View view) {
        UserFollowingRepository repository = new UserFollowingRepositoryBuilder((UserAccessToken) accessToken)
                .build();
        repository.unfollow("l8mD9WMm", new ResponseCallback<Void>() {
            @Override
            public void onSuccess(Void response) {
                Toast.makeText(MainActivity.this, "User unfollowed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    void displayError(ErrorResponse errorResponse) {
        Toast.makeText(MainActivity.this, errorResponse.toString(), Toast
                .LENGTH_SHORT)
                .show();
    }

    public void onGetGroupsClicked(View view) {
        GroupRepository repository = new GroupRepositoryBuilder((UserAccessToken) accessToken)
                .build();

        repository.getAll(new ResponseCallback<CreatubblesResponse<List<Group>>>() {
            @Override
            public void onSuccess(CreatubblesResponse<List<Group>> response) {
                Toast.makeText(MainActivity.this, "Groups count: " + response.getData().size(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onCreateGroupClicked(View view) {
        GroupRepository repository = new GroupRepositoryBuilder((UserAccessToken) accessToken)
                .build();
        Group group = new Group.Builder()
                .setName("Test Gallery one")
                .build();
        repository.create(group, new ResponseCallback<CreatubblesResponse<Group>>() {

            @Override
            public void onSuccess(CreatubblesResponse<Group> response) {
                Toast.makeText(MainActivity.this, "Group created: " + response.getData().toString(),
                        Toast.LENGTH_SHORT).show();
                newGroup = response.getData();
                updateGroup.setEnabled(true);
                deleteGroup.setEnabled(true);
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onUpdateGroupClicked(View view) {
        GroupRepository repository = new GroupRepositoryBuilder((UserAccessToken) accessToken)
                .build();
        Group group = new Group.Builder()
                .setName("Test Gallery renamed")
                .build();

        repository.update(newGroup.getId(), group, new ResponseCallback<Void>() {
            @Override
            public void onSuccess(Void response) {
                Toast.makeText(MainActivity.this, "Group updated", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {
            }
        });
    }

    public void onDeleteGroupClicked(View view) {
        GroupRepository repository = new GroupRepositoryBuilder((UserAccessToken) accessToken)
                .build();
        repository.delete(newGroup.getId(), new ResponseCallback<Void>() {
            @Override
            public void onSuccess(Void response) {
                updateGroup.setEnabled(false);
                deleteGroup.setEnabled(false);
                Toast.makeText(MainActivity.this, "Group deleted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {
            }
        });
    }

    public void onGetBubblesOnCreationClicked(View view) {
        BubbleRepository repository = new BubbleRepositoryBuilder(accessToken)
                .build();

        repository.getForCreation(null, creationId, getCallbackForListOfBubbles());
    }

    public void onGetBubblesOnGalleryClicked(View view) {
        BubbleRepository repository = new BubbleRepositoryBuilder(accessToken)
                .build();

        repository.getForGallery(null, galleryId, getCallbackForListOfBubbles());
    }

    public void onGetBubblesOnUserClicked(View view) {
        BubbleRepository repository = new BubbleRepositoryBuilder(accessToken)
                .build();

        repository.getForUser(null, userId, getCallbackForListOfBubbles());
    }

    @NonNull
    private ResponseCallback<CreatubblesResponse<List<Bubble>>> getCallbackForListOfBubbles() {
        return new ResponseCallback<CreatubblesResponse<List<Bubble>>>() {
            @Override
            public void onSuccess(CreatubblesResponse<List<Bubble>> response) {
                Toast.makeText(MainActivity.this, "Number of bubbles: " + response.getMeta().getTotalCount(), Toast
                        .LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        };
    }

    public void onCreateBubbleOnCreationClicked(View v) {
        BubbleRepository repository = new BubbleRepositoryBuilder(accessToken)
                .build();
        Bubble bubble = new Bubble.Builder()
                .build();
        repository.createForCreation(creationId, bubble, getCallbackForSingleBubble(true));
    }

    public void onCreateBubbleOnGalleryClicked(View v) {
        BubbleRepository repository = new BubbleRepositoryBuilder(accessToken)
                .build();
        Bubble bubble = new Bubble.Builder()
                .build();
        repository.createForGallery(galleryId, bubble, getCallbackForSingleBubble(false));
    }

    public void onCreateBubbleOnUserClicked(View v) {
        BubbleRepository repository = new BubbleRepositoryBuilder(accessToken)
                .build();
        Bubble bubble = new Bubble.Builder()
                .build();
        repository.createForUser(userId, bubble, getCallbackForSingleBubble(false));
    }

    @NonNull
    private ResponseCallback<CreatubblesResponse<Bubble>> getCallbackForSingleBubble(boolean save) {
        return new ResponseCallback<CreatubblesResponse<Bubble>>() {
            @Override
            public void onSuccess(CreatubblesResponse<Bubble> response) {
                Toast.makeText(MainActivity.this, "Bubble created", Toast.LENGTH_SHORT).show();
                if (save) {
                    bubbleId = response.getData().getId();
                    updateBubble.setEnabled(true);
                    deleteBubble.setEnabled(true);
                }
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        };
    }

    public void onUpdateBubbleClicked(View view) {
        BubbleRepository repository = new BubbleRepositoryBuilder(accessToken)
                .build();
        Bubble bubble = new Bubble.Builder()
                .setPosition(0.1, 0.1)
                .build();
        repository.update(bubbleId, bubble, new ResponseCallback<Void>() {
            @Override
            public void onSuccess(Void response) {
                Toast.makeText(MainActivity.this, "Bubble updated", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onDeleteBubbleClicked(View view) {
        BubbleRepository repository = new BubbleRepositoryBuilder(accessToken)
                .build();
        repository.delete(bubbleId, new ResponseCallback<Void>() {
            @Override
            public void onSuccess(Void response) {
                Toast.makeText(MainActivity.this, "Bubble deleted", Toast.LENGTH_SHORT).show();
                updateBubble.setEnabled(false);
                deleteBubble.setEnabled(false);
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {
            }
        });
    }

    public void onGetBubbleColorsClicked(View v) {
        BubbleRepository repository = new BubbleRepositoryBuilder(accessToken)
                .build();
        repository.getColors(new ResponseCallback<CreatubblesResponse<List<BubbleColor>>>() {
            @Override
            public void onSuccess(CreatubblesResponse<List<BubbleColor>> response) {
                Toast.makeText(MainActivity.this, response.getData().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onSubmitCreationClicked(View view) {
        GalleryRepository repository = new GalleryRepositoryBuilder(accessToken)
                .build();

        repository.submitCreation(galleryId, creationId, new ResponseCallback<CreatubblesResponse<GallerySubmission>>() {
            @Override
            public void onSuccess(CreatubblesResponse<GallerySubmission> response) {
                Toast.makeText(MainActivity.this, "Creation submitted", Toast.LENGTH_SHORT).show();
                submitCreation.setEnabled(false);
                galleryId = null;
                creationId = null;
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {
            }
        });
    }

    public void onModifyImageClicked(View v) {
        CreationRepository repository = new CreationRepositoryBuilder(accessToken)
                .build();

        ImageManipulation manipulation = new ImageManipulation.Builder().setRotation(Rotation.ROTATION_90)
                .setCropping(new Cropping(0, 0, 100, 100)).build();
        repository.updateImage(creationId, manipulation, new ResponseCallback<Void>() {
            @Override
            public void onSuccess(Void response) {
                Toast.makeText(MainActivity.this, "Image Modified", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onGetAccountDetailsClicked(View v) {
        UserRepository repository = new UserRepositoryBuilder(accessToken)
                .build();

        repository.getAccountDetails(new ResponseCallback<CreatubblesResponse<AccountDetails>>() {
            @Override
            public void onSuccess(CreatubblesResponse<AccountDetails> response) {
                Toast.makeText(MainActivity.this, response.getData().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onUpdateAccountDetailsClicked(View v) {
        AccountDetails accountDetails = new AccountDetails.Builder()
                .setAgeDisplayType(AgeDisplayType.DO_NOT_SHOW)
                .setBirthYear(2000)
                .build();

        UserRepository repository = new UserRepositoryBuilder(accessToken)
                .build();

        repository.updateAccountDetails(userId, accountDetails, new ResponseCallback<Void>() {
            @Override
            public void onSuccess(Void response) {
                Toast.makeText(MainActivity.this, "Account updated", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onLinkSchoolWithAccountClicked(View v) {
        School school = new School.Builder("Test school", "PL")
                .build();

        UserRepository repository = new UserRepositoryBuilder(accessToken)
                .build();

        repository.linkSchoolWithAccount(userId, school, new ResponseCallback<Void>() {
            @Override
            public void onSuccess(Void response) {
                Toast.makeText(MainActivity.this, "School linked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onChangePasswordClicked(View v) {
        // use the same password - in result not changing password just testing the request
        PasswordChange passwordChange = PasswordChange.create(passwordText.getText().toString(),
                passwordText.getText().toString());
        UserRepository repository = new UserRepositoryBuilder(accessToken)
                .build();
        repository.changePassword(userId, passwordChange, new ResponseCallback<CreatubblesResponse<User>>() {
            @Override
            public void onSuccess(CreatubblesResponse<User> response) {
                Toast.makeText(MainActivity.this, "Password changed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onGetNotificationsClicked(View v) {
        NotificationRepository repository = new NotificationRepositoryBuilder(accessToken)
                .build();

        repository.getNotifications(null, null,
                new ResponseCallback<CreatubblesResponse<List<Notification>>>() {
                    @Override
                    public void onSuccess(CreatubblesResponse<List<Notification>> response) {
                        Toast.makeText(MainActivity.this, "Notification count: " + response.getMeta().getTotalCount(),
                                Toast.LENGTH_SHORT).show();
                        if (!response.getData().isEmpty()) {
                            notificationId = response.getData().get(0).getId();
                            findViewById(R.id.mark_as_read_btn).setEnabled(true);
                        }

                    }

                    @Override
                    public void onServerError(ErrorResponse errorResponse) {
                        displayError(errorResponse);
                    }

                    @Override
                    public void onError(String message) {

                    }
                });
    }

    public void onReadNotificationClicked(View v) {
        NotificationRepository repository = new NotificationRepositoryBuilder(accessToken)
                .build();

        repository.markRead(notificationId, new ResponseCallback<Void>() {
            @Override
            public void onSuccess(Void response) {
                Toast.makeText(MainActivity.this, "Notification marked as read", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onUpdateNotificationViewedTimeClicked(View view) {
        NotificationRepository repository = new NotificationRepositoryBuilder(accessToken)
                .build();

        repository.updateLastViewedDate(new ResponseCallback<Void>() {
            @Override
            public void onSuccess(Void response) {
                Toast.makeText(MainActivity.this, "Notification view time updated", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onReportUserClicked(View v) {
        ReportRepository repository = new ReportRepositoryBuilder((UserAccessToken) accessToken)
                .build();
        Report report = Report.create("Test report");

        repository.reportUser(userId, report, getReportCallback());
    }

    public void onReportCreationClicked(View v) {
        ReportRepository repository = new ReportRepositoryBuilder((UserAccessToken) accessToken)
                .build();
        Report report = Report.create("Test report");

        repository.reportCreation(creationId, report, getReportCallback());
    }

    public void onReportGalleryClicked(View v) {
        ReportRepository repository = new ReportRepositoryBuilder((UserAccessToken) accessToken)
                .build();
        Report report = Report.create("Test report");

        repository.reportGallery(galleryId, report, getReportCallback());
    }

    public void onReportCommentClicked(View v) {
        ReportRepository repository = new ReportRepositoryBuilder((UserAccessToken) accessToken)
                .build();
        Report report = Report.create("Test report");

        repository.reportComment(commentId, report, getReportCallback());
    }

    @NonNull
    private ResponseCallback<Void> getReportCallback() {
        return new ResponseCallback<Void>() {
            @Override
            public void onSuccess(Void response) {
                Toast.makeText(MainActivity.this, "Reported", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        };
    }

    public void onGetAbilityClicked(View view) {
        AbilityRepository abilityRepository = new AbilityRepositoryBuilder((UserAccessToken) accessToken)
                .build();
        abilityRepository.getSpecitfic(ObjectType.USER, userId, Operation.EDIT, new ResponseCallback<CreatubblesResponse<Ability>>() {
            @Override
            public void onSuccess(CreatubblesResponse<Ability> response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onGetToybooDetailsClicked(View view) {
        CreationRepository repository = new CreationRepositoryBuilder(accessToken).build();
        repository.getToybooDetails("kniSnnvO", new ResponseCallback<CreatubblesResponse<ToybooDetails>>() {
            @Override
            public void onSuccess(CreatubblesResponse<ToybooDetails> response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onGetPartnerApplicationsClicked(View v) {
        PartnerApplicationRepository repository = new PartnerApplicationRepositoryBuilder(accessToken)
                .build();

        repository.search(null, "a", new ResponseCallback<CreatubblesResponse<List<PartnerApplication>>>() {
            @Override
            public void onSuccess(CreatubblesResponse<List<PartnerApplication>> response) {
                Toast.makeText(MainActivity.this, "Found " + response.getMeta().getTotalCount()
                        + " partner applications", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onGetSpecificPartnerApplicationClicked(View v) {
        PartnerApplicationRepository repository = new PartnerApplicationRepositoryBuilder(accessToken)
                .build();

        repository.getById("hueanimation", new ResponseCallback<CreatubblesResponse<PartnerApplication>>() {
            @Override
            public void onSuccess(CreatubblesResponse<PartnerApplication> response) {
                Toast.makeText(MainActivity.this, response.getData().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                displayError(errorResponse);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onGetContentClicked(View v) {
        ContentRepository repository = new ContentRepositoryBuilder(accessToken)
                .build();

        repository.search("HazarSOYDAN", null, getContentCallback());
    }

    public void onGetRecentContentClicked(View v) {
        ContentRepository repository = new ContentRepositoryBuilder(accessToken)
                .build();

        repository.getRecent(null, getContentCallback());
    }

    public void onGetTrendingContentClicked(View v) {
        ContentRepository repository = new ContentRepositoryBuilder(accessToken)
                .build();

        repository.getTrending(null, getContentCallback());
    }

    public void onGetConnectedContentClicked(View v) {
        ContentRepository repository = new ContentRepositoryBuilder(accessToken)
                .build();

        repository.getConnected(null, getContentCallback());
    }

    public void onGetFollowedContentClicked(View v) {
        ContentRepository repository = new ContentRepositoryBuilder(accessToken)
                .build();

        repository.getFollowed(null, getContentCallback());
    }

    public void onGetContentByUserClicked(View v) {
        ContentRepository repository = new ContentRepositoryBuilder(accessToken)
                .build();

        repository.getByUser(null, userId, getContentCallback());
    }

    public void onGetContentBubbledByUserClicked(View v) {
        ContentRepository repository = new ContentRepositoryBuilder(accessToken)
                .build();

        repository.getBubbledByUser(null, userId, getContentCallback());
    }

    @NonNull
    private ResponseCallback<CreatubblesResponse<List<Content>>> getContentCallback() {
        return new ResponseCallback<CreatubblesResponse<List<Content>>>() {
            @Override
            public void onSuccess(CreatubblesResponse<List<Content>> response) {
                Toast.makeText(MainActivity.this, response.getData().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                Toast.makeText(MainActivity.this, errorResponse.toString(), Toast.LENGTH_SHORT).show();
                Log.e("GET_CONTENT", errorResponse.toString());
            }

            @Override
            public void onError(String message) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                Log.e("GET_CONTENT", message);
            }
        };
    }

    public void onListSchoolsClicked(View v) {
        SchoolRepository repository = new SchoolRepositoryBuilder(accessToken)
                .build();

        SchoolRepository.SchoolQuery query = new SchoolRepository.SchoolQuery()
                .nameContaining("the");

        repository.search(null, query, new ResponseCallback<CreatubblesResponse<List<School>>>() {
            @Override
            public void onSuccess(CreatubblesResponse<List<School>> response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                Toast.makeText(MainActivity.this, errorResponse.toString(), Toast.LENGTH_SHORT).show();
                Log.e("onServerError", errorResponse.toString());
            }

            @Override
            public void onError(String message) {
                Log.e("onListSchoolsClicked", message);
            }
        });
    }

    interface Function<T> {
        void consume(T t);
    }

    interface BiFunction<T, U> {
        void consume(T first, U second);
    }

}
