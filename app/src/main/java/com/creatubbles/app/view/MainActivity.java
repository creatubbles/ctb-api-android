package com.creatubbles.app.view;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.gallery.Gallery;
import com.creatubbles.api.model.landing_url.LandingUrl;
import com.creatubbles.api.model.landing_url.LandingUrlType;
import com.creatubbles.api.model.upload.Upload;
import com.creatubbles.api.model.user.MultipleCreators;
import com.creatubbles.api.model.user.NewUser;
import com.creatubbles.api.model.user.User;
import com.creatubbles.api.repository.CreationRepository;
import com.creatubbles.api.repository.CreationRepositoryBuilder;
import com.creatubbles.api.repository.GalleryRepository;
import com.creatubbles.api.repository.GalleryRepositoryBuilder;
import com.creatubbles.api.repository.LandingUrlsRepository;
import com.creatubbles.api.repository.LandingUrlsRepositoryBuilder;
import com.creatubbles.api.repository.OAuthRepository;
import com.creatubbles.api.repository.OAuthRepositoryBuilder;
import com.creatubbles.api.repository.UploadRepository;
import com.creatubbles.api.repository.UploadRepositoryBuilder;
import com.creatubbles.api.repository.UserRepository;
import com.creatubbles.api.repository.UserRepositoryBuilder;
import com.creatubbles.api.request.UploadRequest;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.app.R;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.MediaType;


public class MainActivity extends AppCompatActivity {

    @Bind({R.id.get_user_btn, R.id.get_user_creators_btn, R.id.create_user_btn, R.id.create_gallery_btn,
            R.id.get_galleries_btn, R.id.create_creation_btn, R.id.create_upload_btn, R.id.get_creation_by_id_btn,
            R.id.get_all_landing_urls_btn, R.id.get_specific_landing_url_btn, R.id.get_user_managers_btn,
            R.id.get_user_connections_btn, R.id.get_user_followed_btn, R.id.get_switch_users_btn, R.id.create_multiple_users_btn,
            R.id.get_creators_from_group_btn})
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

    Upload responseFromCreateUpload;
    List<User> usersAvailableForSwitching;
    AuthToken authToken;

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

        repository.authorize("email@email.com", "password", new
                ResponseCallback<AuthToken>() {

                    @Override
                    public void onSuccess(AuthToken response) {
                        Toast.makeText(MainActivity.this, response.getAccessToken(), Toast
                                .LENGTH_SHORT).show();

                        authToken = response;
                        ButterKnife.apply(actionButtons, (view, index) -> view.setEnabled(true));
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

    public void onSwitchClicked(View btn) {
        OAuthRepository repository = new OAuthRepositoryBuilder().build();

        repository.switchAccount(authToken, usersAvailableForSwitching.get(0).getId(), null, new ResponseCallback<AuthToken>() {
            @Override
            public void onSuccess(AuthToken response) {
                Toast.makeText(MainActivity.this, response.getAccessToken(), Toast
                        .LENGTH_SHORT).show();

                authToken = response;
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
        UserRepository userRepository = new UserRepositoryBuilder()
                .setAuthToken(authToken)
                .build();
        getUser(userRepository::getUser);
    }

    public void onGetUserCreatorsClicked(View btn) {
        UserRepository userRepository = new UserRepositoryBuilder()
                .setAuthToken(authToken)
                .build();
        getUserList(userRepository::getCreators);
    }

    public void onGetUserConnectionsClicked(View view) {
        UserRepository userRepository = new UserRepositoryBuilder()
                .setAuthToken(authToken)
                .build();
        getUserList(userRepository::getConnections);
    }

    public void onGetUserFollowedClicked(View view) {
        UserRepository userRepository = new UserRepositoryBuilder()
                .setAuthToken(authToken)
                .build();
        getUserList(userRepository::getFollowedUsers);
    }

    public void onGetUserManagersClicked(View btn) {
        UserRepository userRepository = new UserRepositoryBuilder()
                .setAuthToken(authToken)
                .build();
        getUserList(userRepository::getManagers);
    }

    public void onGetSwitchUsersClicked(View btn) {
        UserRepository userRepository = new UserRepositoryBuilder()
                .setAuthToken(authToken)
                .build();
        getUserList(userRepository::getUsersAvailableForSwitching);

        switchBtn.setEnabled(true);
    }

    public void onGetCreatorsFromGroup(View btn) {
        UserRepository userRepository = new UserRepositoryBuilder()
                .setAuthToken(authToken)
                .build();
        userRepository.getCreatorsFromGroup("9320", null, getUserListCallback());
    }

    public void onCreateUserClicked(View btn) {
        UserRepository userRepository = new UserRepositoryBuilder()
                .setAuthToken(authToken)
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
        UserRepository userRepository = new UserRepositoryBuilder()
                .setAuthToken(authToken)
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
                    for (User creator : response.getData()) {
                        Toast.makeText(MainActivity.this, creator.toString(), Toast
                                .LENGTH_SHORT).show();
                    }
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
        CreationRepository creationRepository = new CreationRepositoryBuilder()
                .setAuthToken(authToken)
                .build();

        Creation newCreation = new Creation.Builder("testCreation", Collections.emptyList()).build();
        creationRepository.createCreation(newCreation, new
                ResponseCallback<CreatubblesResponse<Creation>>() {
                    @Override
                    public void onSuccess(CreatubblesResponse<Creation> response) {
                        Toast.makeText(MainActivity.this, response.toString(), Toast
                                .LENGTH_SHORT)
                                .show();
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

    public void onCreateUploadClicked(View btn) {
        CreationRepository creationRepository = new CreationRepositoryBuilder()
                .setAuthToken(authToken)
                .build();

        creationRepository.createUpload("V4QbH3DE", new UploadRequest(ContentType
                .JPG), new ResponseCallback<CreatubblesResponse<Upload>>() {
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
        CreationRepository creationRepository = new CreationRepositoryBuilder()
                .setAuthToken(authToken)
                .build();
        //TODO: add working creation ID
        creationRepository.getCreationById("ghOq9eug", new ResponseCallback<CreatubblesResponse<Creation>>() {
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

                            CreationRepository creationRepository = new CreationRepositoryBuilder()
                                    .setAuthToken(authToken)
                                    .build();
                            creationRepository.updateCreationUpload(responseFromCreateUpload
                                    .getPingUrl(), new ResponseCallback<Void>() {


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
        GalleryRepository galleryRepository = new GalleryRepositoryBuilder().setAuthToken
                (authToken).build();

        Gallery gallery = new Gallery("myNewGallery2", "TestGallery", true, null);
        galleryRepository.createGallery(gallery, new ResponseCallback<CreatubblesResponse<Gallery>>() {
            @Override
            public void onSuccess(CreatubblesResponse<Gallery> response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {

            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onGetGalleriesByIdClicked(View view) {
        GalleryRepository galleryRepository = new GalleryRepositoryBuilder().setAuthToken
                (authToken).build();

        galleryRepository.getGalleriesByUser("me", new ResponseCallback<CreatubblesResponse<List<Gallery>>>() {
            @Override
            public void onSuccess(CreatubblesResponse<List<Gallery>> response) {
                for (Gallery gallery : response.getData()) {
                    Toast.makeText(MainActivity.this, gallery.toString(), Toast
                            .LENGTH_SHORT).show();
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

    public void onGetAllLandingUrlsClicked(View view) {
        LandingUrlsRepository repository = new LandingUrlsRepositoryBuilder().setAuthToken(authToken).build();

        repository.getLandingUrls(new ResponseCallback<CreatubblesResponse<List<LandingUrl>>>() {
            @Override
            public void onSuccess(CreatubblesResponse<List<LandingUrl>> response) {
                for (LandingUrl url : response.getData()) {
                    Toast.makeText(MainActivity.this, url.toString(), Toast
                            .LENGTH_SHORT).show();
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

    public void onGetSpecificLandingUrlClicked(View view) {

        LandingUrlsRepository repository = new LandingUrlsRepositoryBuilder().setAuthToken(authToken).build();

        repository.getSpecificLandingUrl(LandingUrlType.COMMON_REGISTRATION, new
                ResponseCallback<CreatubblesResponse<LandingUrl>>() {


                    @Override
                    public void onSuccess(CreatubblesResponse<LandingUrl> response) {
                        Toast.makeText(MainActivity.this, response.toString(), Toast
                                .LENGTH_SHORT).show();
                    }

                    @Override
                    public void onServerError(ErrorResponse errorResponse) {

                    }

                    @Override
                    public void onError(String message) {

                    }
                });

        repository.getSpecificLandingUrl(LandingUrlType.USER_PROFILE, new
                ResponseCallback<CreatubblesResponse<LandingUrl>>() {


                    @Override
                    public void onSuccess(CreatubblesResponse<LandingUrl> response) {
                        Toast.makeText(MainActivity.this, response.toString(), Toast
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

    void displayError(ErrorResponse errorResponse) {
        Toast.makeText(MainActivity.this, errorResponse.toString(), Toast
                .LENGTH_SHORT)
                .show();
    }

    interface Function<T> {
        void consume(T t);
    }
    interface BiFunction<T, U> {
        void consume(T first, U second);
    }
}
