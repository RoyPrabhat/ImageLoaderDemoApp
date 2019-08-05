ImageLoaderApp

A simple image loading app with MVVM design pattern, Picasso, retrofit, View Model, and LiveData


Features of the application

1.) Fetch random 10 images from unsplashj and display thumbmnails of the images
    in a grid layout in the first activity
2.) Tap any of the photos to go to a new screen to view an enalarged version of the image
3.) A cancel button button at the bottom while the image is being loaded to stop the loading
    in case it is no longer required
4.) The cancel button has disabled in case the image has loaded successfully
5.) A back button in the above activity to go back to the precious activity
6.) caching the image in memort and disk-level image cachcing for faster load
7.) Default loading image, when the image is still loading and error image when something went
    wrong while loading the image

Design decisions

1.) Use of one most the most prevalent ui design pattern which is MVVM
2.) Use of retrofit to make api calls
3.) Use of View Model, and LiveData components provided by android archietecture components
4.) Use of Picasso library (One of the most prevalent image loading application). This library
    provides image caching in memory and disk-level image caching by default for faster load

Assumptions while developing the application

1.) Fullscreen display meant  displaying the full image of a very large imageview
2.) Also in order to cancel the image loading when not required, a button was required so did not
    give the full screen dimensions to the image view.

Note:-

1.) Not too much deataling is there on the beauty of the UI

Steps to run the project

1.) Clone Repository
2.) Open the project in android studio
3.) Run the application

Steps to build apk the project

1.) Clone Repository
2.) Open the project in android studio
3.) Go to Build -> Build Bundle(s) / Build APK (s) --> Build APK(s)

Troubleshooting
Email Contact : royprabhat6@gmail.com
