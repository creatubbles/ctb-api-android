# Creatubbles API Android (ctb-api-andorid)

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
6. `LandingUrlsRepository` - for fetching landing urls
7. `ActivityRepository` - for fetching list of activities
8. `CustomStyleRepository` - for operations on user's custom style
9. `CommentRepository` - for operations on comments
10. `UserFollowingRepository` - for following/unfollowing users
11. `GroupRepository` - for managing Groups
12. `BubbleRepository` - for managing bubbles on creations, galleries and users
13. `AvatarRepository` - for managing user's avatar
14. `NotificationRepository` - for managing notifications

## Preview
### Demo

Check our demo app. You can check how to invoke method and connect to Creatubbles API Server.

### Screenshot
![screen1] (https://github.com/creatubbles/ctb-api-android/blob/develop/screen1.png)


## Uses

**To use library you need:**
- **your Client_ID and Client_Secret**
- **your email and password to your creatubbles account**


1. Initialization
-----------------------
Before you start using CreatubblesApi library you must initialize it with your own configuration object.


REMEMBER: CLIENT_ID and CLIENT_SECRET need to be your own secret keys.

```
CreatubblesApi.initialize(new Configuration.Builder()
              .application(ApplicationObject)
              .baseUrl(BASE_URL)
              .clientId(CLIENT_ID)
              .clientSecret(CLIENT_SECRET)
              .build());
  }

```

The lack of any configuration's parameter will produce InvalidParametersException.


After initialization you can start using all of the available repositories.

2. Authorize Repository
-----------------------

To authorize to creatubbles you use `OAuthRepository`. If you want to create instance of `OAuthRepository` you need to use `OAuthRepositoryBuilder` which implement Builder Pattern.
Example of create instance `OAuthRepository`:


```
OAuthRepository oauthRepository = new OAuthRepositoryBuilder()
                .build();
```


Example of `OAuthRepository` uses:

    REMEMBER: EMAIL and PASSWORD need to be your own credentials.

```
oauthRepository.authorize("email@email.com", "password", new ResponseCallback<AuthToken>() {

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

3. UserRepository
---

Create `UserRepository` instance:
```
UserRepository userRepository = new UserRepositoryBuilder()
                .setAuthToken(authToken)
                .build();
```

Example of `UserRepository` uses:
```
userRepository.getCreators(page, new ResponseCallback<CreatubblesResponse<List<User>>>() {
            @Override
            public void onSuccess(CreatubblesResponse<List<User>> response) {
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

4. GalleryRepository
--------------------

Create `GalleryRepository` instance:
```
GalleryRepository galleryRepository = new GalleryRepositoryBuilder()
                .setAuthToken(authToken)
                .build();
```

Example of `GalleryRepository` uses:
```
galleryRepository.getById("aaa777", ResponseCallback<CreatubblesResponse<Gallery>>() {
            @Override
            public void onSuccess(CreatubblesResponse<Gallery> response) {
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

5. CreationRepository
---------------------

Create `CreationRepository` instance:
```
CreationRepository creationRepository = new CreationRepositoryBuilder()
                .setAuthToken(authToken)
                .build();
```

Example of `CreationRepository` uses:
```
Creation newCreation = new Creation.Builder("testCreation", Collections.emptyList()).build();

creationRepository.create(newCreation, new
            ResponseCallback<CreatubblesResponse<Creation>>() {
            @Override
            public void onSuccess(CreatubblesResponse<Creation> response) {
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
6. Langing URLs repository
--------------------------

Create `LandingUrlsRepository` instance:

```
LandingUrlsRepository repository = new LandingUrlsRepositoryBuilder()
                .setAuthToken(authToken)
                .build();
```

Example of `LandingUrlsRepository` uses:

```
repository.getLandingUrls(new ResponseCallback<CreatubblesResponse<List<LandingUrl>>>() {
            @Override
            public void onSuccess(CreatubblesResponse<List<LandingUrl>> response) {
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

7. Activities repository
--------------------------

Create `ActivityRepository` instance:

```
ActivityRepository activityRepository = new ActivityRepositoryBuilder(authToken)
                .build();
```

Example of `ActivityRepository` uses:

```
activityRepository.getActivities(page, new ResponseCallback<CreatubblesResponse<List<Activity>>>() {
            @Override
            public void onSuccess(CreatubblesResponse<List<Activity>> response) {
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
            }

            @Override
            public void onError(String message) {
            }
        });
```

8. Custom style repository
--------------------------

Create `CustomStyleRepository` instance:

```
CustomStyleRepository customStyleRepository = new CustomStyleRepositoryBuilder()
               .setAuthToken(authToken)
               .build();
```

Example of `CustomStyleRepository` uses:

```
customStyleRepository.getCustomStyle(userId, new ResponseCallback<CreatubblesResponse<CustomStyle>>() {
            @Override
            public void onSuccess(CreatubblesResponse<CustomStyle> response) {
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
            }

            @Override
            public void onError(String message){
            }      
        });
```

9. Comments repository
--------------------------

Create `CommentRepository` instance:

```
CommentRepository commentRepository = new CommentRepositoryBuilder(authToken)
                .build();
```

Example of `CommentRepository` uses:

```
Integer pageNumber;
commentRepository.getForUser(pageNumber, userId, new ResponseCallback<CreatubblesResponse<List<Comment>>>() {
            @Override
            public void onSuccess(CreatubblesResponse<List<Comment>> response) {
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
            }

            @Override
            public void onError(String message) {
            }
        });
```

11. Groups repository
--------------------------

Create `GroupRepository` instance:

```
GroupRepository repository = new GroupRepositoryBuilder(authToken)
                .build();
```

Example of `GroupRepository` uses:

```
    Group group = new Group.Builder()
            .setName("Test Gallery one")
            .build();
    repository.create(group, new ResponseCallback<CreatubblesResponse<Group>>() {

        @Override
        public void onSuccess(CreatubblesResponse<Group> response) {
            // group created, instance at response.getData()
        }

        @Override
        public void onServerError(ErrorResponse errorResponse) {
        }

        @Override
        public void onError(String message) {

        }
    });
```

12. Bubble repository
--------------------------

Create `BubbleRepository` instance:

```
    BubbleRepository repository = new BubbleRepositoryBuilder(authToken)
                    .build();
```

Example of `BubbleRepository` uses:

```
    repository.getForCreation(page, creationId, new ResponseCallback<CreatubblesResponse<List<Bubble>>>() {
          @Override
          public void onSuccess(CreatubblesResponse<List<Bubble>> response) {
          }

          @Override
          public void onServerError(ErrorResponse errorResponse) {
          }

          @Override
          public void onError(String message) {
          }
      });
```

13. Avatar repository
--------------------------

Create `AvatarRepository` instance:

```
    AvatarRepository avatarRepository = new AvatarRepositoryBuilder(authToken)
                    .build();
```

Example of `AvatarRepository` uses:

```
        avatarRepository.updateAvatar(userId, avatar, new ResponseCallback<CreatubblesResponse<Avatar>>() {
        @Override
        public void onSuccess(CreatubblesResponse<Avatar> response) {
        }

        @Override
        public void onServerError(ErrorResponse errorResponse) {
        }

        @Override
        public void onError(String message) {
        }
        
      });

```

14. Notification repository
--------------------------

Create `NotificationRepository` instance:

```
    NotificationRepository repository = new NotificationRepositoryBuilder(authToken)
                        .build();
```

Example of `NotificationRepository` uses:

```
repository.getNotifications(page, filter,
        new ResponseCallback<CreatubblesResponse<List<Notification>>>() {
            @Override
            public void onSuccess(CreatubblesResponse<List<Notification>> response) {
            }

            @Override
            public void onServerError(ErrorResponse errorResponse) {
            }

            @Override
            public void onError(String message) {
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
