# Creatubbles API Android (ctb-api-andorid)
## Usage
**Maven**:
```    
<dependency>
  <groupId>com.creatubbles</groupId>
  <artifactId>api</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```

**Gradle**:
```
    compile 'com.creatubbles:api:1.0.0'
```
**Ivy**:
```
<dependency org='com.creatubbles' name='api' rev='1.0.0'>
  <artifact name='$AID' ext='pom'></artifact>
</dependency>
```
## Architecture
1. **Packages**
    - **API Module**: Implementing all server method.
    - **APP Module**: Some samples and manual test.
    - **Test**: Repository and builder tests are in `api/test/` package.

2. **Repository Pattern**
    - We use Repository Pattern to provide best practices to provide data from server to app. All repository are tested.

3. **Builder Pattern**
    - We use Builder Pattern to provide all repository.

4. **Dependency Injection**
    - You also could use dependency injection to provide all repository. We recommend Dagger2 lib.

5. **REST**
    - For REST queries we use Retrofit 2 library

## List of repositories
1. `OAuthRepository` - for authorize operations
2. `UserRepository` - for operations on Users
3. `GalleryRepository` - for operations on Gallery
4. `CreationRepository` - for operations on Creation
5. `UploadRepository` - for upload media (images, videos) to server

## Preview
### Demo

Check our demo app. You can check how to invoke method and connect to Creatubbles API Server.

### Screenshot
![screen1] (https://github.com/creatubbles/ctb-api-android/blob/develop/screen1.png)


## Uses

**To use library you need:**
- **your Client_ID and Client_Secret**
- **your email and password to your creatubbles account**

1. Authorize Repository
-----------------------

To authorize to creatubble you use `OAuthRepository`. If you want to create instance of `OAuthRepository` you need to use `OAuthRepositoryBuilder` which implement Builder Pattern.
Example of create instance `OAuthRepository`:

    REMEMBER: CLIENT_ID and CLIENT_SECRET need to be your own secret keys.

```
OAuthRepository oauthRepository = new OAuthRepositoryBuilder()
                .setContext(getApplicationContext())
                .setClientId(CLIENT_ID)
                .setClientSecret(CLIENT_SECRET)
                .build();
```


Example of `OAuthRepository` uses:

    REMEMBER: EMAIL and PASSWORD need to be your own credentials.

```
oauthRepository.authorize("emial@email.com", "password", new ResponseCallback<AuthToken>() {

            @Override
            public void onSuccess(AuthToken response) {

                //Success if response code is [200...300], e.g.
                Toast.makeText(MainActivity.this, response.getAccessToken(), Toast
                        .LENGTH_SHORT).show();

            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                //Server Error if response code is different than [200...300]
            }

            @Override
            public void onError(String message) {
                //Error if something goes wrong (not form server) e.g. lost internet connection
            }
        });
```

2. UserRepository
---

Create `UserRepository` instance:
```
UserRepository userRepository = new UserRepositoryBuilder()
                .setContext(getApplicationContext())
                .setAuthToken(authToken)
                .build();
```

Example of `UserRepository` uses:
```
userRepository.getUsersList(new ResponseCallback<UserListResponse>() {
            @Override
            public void onSuccess(UserListResponse response) {
                //Do something if OK
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                //Do something if goes wrong
            }

            @Override
            public void onError(String message) {
            }
        });
```

3. GalleryRepository
--------------------

Create `GalleryRepository` instance:
```
GalleryRepository galleryRepository = new GalleryRepositoryBuilder()
                .setContext(getApplicationContext())
                .setAuthToken(authToken)
                .build();
```

Example of `GalleryRepository` uses:
```
galleryRepository.getGalleryById("aaa777", new ResponseCallback<GalleryResponse>() {
            @Override
            public void onSuccess(GalleryResponse response) {
                //Do something if OK
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
                //Do something if goes wrong
            }

            @Override
            public void onError(String message) {
            }
        });
```

4. CreationRepository
---------------------

Create `CreationRepository` instance:
```
CreationRepository creationRepository = new CreationRepositoryBuilder()
                .setContext(getApplicationContext())
                .setAuthToken(authToken)
                .build();
```

Example of `CreationRepository` uses:
```
CreationRequest.Builder body = new CreationRequest.Builder();
body.name("testCreation");

creationRepository.createCreation(body.build(), new
        ResponseCallback<CreationResponse>() {
            @Override
            public void onSuccess(CreationResponse response) {
                //Do something if OK
            }

            @Override
            public void onError(String error) {
                //Do something if goes wrong
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
            }
        });
```



## Used libs
1. Retrofit 2: [http://square.github.io/retrofit/](http://square.github.io/retrofit/)
2. OkHttp 3: [http://square.github.io/okhttp/](http://square.github.io/okhttp/)
3. Dagger 2: [http://google.github.io/dagger/](http://google.github.io/dagger/)



## License

```
The MIT License (MIT)

Copyright (c) 2016 Creatubbles Pte. Ltd.

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"),
to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```
