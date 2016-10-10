package com.creatubbles.app.view;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
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
import com.creatubbles.api.OAuthUtil;
import com.creatubbles.api.exception.ErrorResponse;
import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.model.LandingUrlResponse;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.gallery.Gallery;
import com.creatubbles.api.model.upload.Upload;
import com.creatubbles.api.model.url.LandingUrl;
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
import com.creatubbles.api.service.LandingUrlType;
import com.creatubbles.app.CreatubblesApplication;
import com.creatubbles.app.R;

import java.io.File;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.MediaType;


public class MainActivity extends AppCompatActivity {

    @Inject
    public OAuthRepository repository;

    @Bind(R.id.send_file_btn)
    Button sendFileBtn;
    @Bind(R.id.authorize_btn)
    Button authorizeBtn;
    @Bind(R.id.get_user_list_btn)
    Button getUserListBtn;
    @Bind(R.id.create_user_btn)
    Button createUserBtn;
    @Bind(R.id.create_gallery_btn)
    Button createGalleryBtn;
    @Bind(R.id.get_galleries_btn)
    Button getGalleriesBtn;
    @Bind(R.id.create_creation_btn)
    Button createCreationBtn;
    @Bind(R.id.create_upload_btn)
    Button createUploadBtn;
    @Bind(R.id.get_creation_by_id_btn)
    Button getCreationByIdBtn;
    @Bind(R.id.file_name)
    EditText fileName;
    @Bind(R.id.scrollview)
    ScrollView scrollView;

    Upload responseFromCreateUpload;
    AuthToken authToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ((CreatubblesApplication) getApplication()).getApplicationComponent().inject(this);
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

        //TODO add your CLIENT_ID & CLIENT_SECRET
        OAuthRepository repository = new OAuthRepositoryBuilder()
                .setContext(getApplicationContext())
                .setClientId(OAuthUtil.CLIENT_ID)
                .setClientSecret(OAuthUtil.CLIENT_SECRET).build("https://staging.creatubbles" +
                        ".com/api/v2/");


        // TODO add your emial & password
        repository.authorize("email@email.com", "password", new
                ResponseCallback<AuthToken>() {

                    @Override
                    public void onSuccess(AuthToken response) {
                        Toast.makeText(MainActivity.this, response.getAccessToken(), Toast
                                .LENGTH_SHORT).show();

                        authToken = response;
                        getUserListBtn.setEnabled(true);
                        createUserBtn.setEnabled(true);
                        createCreationBtn.setEnabled(true);
                        createUploadBtn.setEnabled(true);
                        getCreationByIdBtn.setEnabled(true);
                        createGalleryBtn.setEnabled(true);
                        getGalleriesBtn.setEnabled(true);
                    }

                    @Override
                    public void onServerError(ErrorResponse errorResponse) {

                    }

                    @Override
                    public void onError(String message) {

                    }
                });
    }

    public void onGetUserListClicked(View btn) {
        UserRepository userRepository = new UserRepositoryBuilder()
                .setContext(getApplicationContext())
                .setAuthToken(authToken)
                .build();

        userRepository.getUsersList(new ResponseCallback<List<User>>() {
            @Override
            public void onSuccess(List<User> response) {
                for (User creator : response) {
                    Toast.makeText(MainActivity.this, creator.toString(), Toast
                            .LENGTH_SHORT).show();
                }
                Toast.makeText(MainActivity.this, "success", Toast
                        .LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                Toast.makeText(MainActivity.this, errorResponse.getErrors().get
                        (0).getDetail(), Toast
                        .LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onCreateUserClicked(View btn) {
        UserRepository userRepository = new UserRepositoryBuilder()
                .setContext(getApplicationContext())
                .setAuthToken(authToken)
                .build();

        NewUser user = new NewUser.Builder("testCreator90123")
                .build();
        userRepository.createUser(user, new ResponseCallback<User>() {
            @Override
            public void onSuccess(User response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast
                        .LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                Toast.makeText(MainActivity.this, errorResponse.getErrors().get
                        (0).getDetail(), Toast
                        .LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    public void onCreateCreationClicked(View btn) {
        CreationRepository creationRepository = new CreationRepositoryBuilder()
                .setContext(getApplicationContext())
                .setAuthToken(authToken)
                .build();

        Creation newCreation = new Creation.Builder("testCreation", Collections.emptyList()).build();
        creationRepository.createCreation(newCreation, new
                ResponseCallback<Creation>() {
                    @Override
                    public void onSuccess(Creation response) {
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
                        Toast.makeText(MainActivity.this, errorResponse.getErrors
                                ().get
                                (0).getDetail(), Toast
                                .LENGTH_SHORT)
                                .show();
                    }
                });
    }

    public void onCreateUploadClicked(View btn) {
        CreationRepository creationRepository = new CreationRepositoryBuilder()
                .setContext(getApplicationContext())
                .setAuthToken(authToken)
                .build();
        //TODO: add working creation ID
        creationRepository.createUpload("V4QbH3DE", new UploadRequest(ContentType
                .JPG), new ResponseCallback<Upload>() {
            @Override
            public void onSuccess(Upload response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT)
                        .show();

                responseFromCreateUpload = response;
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
                .setContext(getApplicationContext())
                .setAuthToken(authToken)
                .build();
        //TODO: add working creation ID
        creationRepository.getCreationById("ghOq9eug", new ResponseCallback<Creation>() {
            @Override
            public void onSuccess(Creation response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast
                        .LENGTH_LONG).show();
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
                    .setContext(getApplicationContext())
                    .build();
            uploadRepository.uploadFile(responseFromCreateUpload.getUrl(),
                    MediaType.parse(responseFromCreateUpload.getContentType()), file, new ResponseCallback<String>() {
                        @Override
                        public void onSuccess(String response) {

                            CreationRepository creationRepository = new CreationRepositoryBuilder()
                                    .setContext(getApplicationContext())
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
                (authToken).setContext(getApplicationContext()).build();

        Gallery gallery = new Gallery("myNewGallery2", "TestGallery", true, null);
        galleryRepository.createGallery(gallery, new ResponseCallback<Gallery>
                () {


            @Override
            public void onSuccess(Gallery response) {
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
                (authToken).setContext(getApplicationContext()).build();

        galleryRepository.getGalleriesByUser("me", new ResponseCallback<List<Gallery>>() {
            @Override
            public void onSuccess(List<Gallery> response) {
                for (Gallery gallery : response) {
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
        LandingUrlsRepository repository = new LandingUrlsRepositoryBuilder().setContext
                (getApplicationContext()).setAuthToken(authToken).build();

        repository.getLandingUrls(new ResponseCallback<LandingUrlResponse>() {
            @Override
            public void onSuccess(LandingUrlResponse response) {
                for (com.creatubbles.api.model.url.Data url : response.getLandingUrlList()) {
                    Toast.makeText(MainActivity.this, url.getAttributes().getUrl(), Toast
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

        LandingUrlsRepository repository = new LandingUrlsRepositoryBuilder().setContext
                (getApplicationContext()).setAuthToken(authToken).build();

        repository.getSpecificLandingUrl(LandingUrlType.COMMON_REGISTRATION, new
                ResponseCallback<LandingUrl>() {


                    @Override
                    public void onSuccess(LandingUrl response) {
                        Toast.makeText(MainActivity.this, response.getData().getAttributes()
                                .getUrl(), Toast
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
                ResponseCallback<LandingUrl>() {


                    @Override
                    public void onSuccess(LandingUrl response) {
                        Toast.makeText(MainActivity.this, response.getData().getAttributes()
                                .getUrl(), Toast
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
}
