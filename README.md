# Viola-Gender
[ ![Download](https://api.bintray.com/packages/darwinfrancis/Viola/com.darwin.viola.gender/images/download.svg) ](https://bintray.com/darwinfrancis/Viola/com.darwin.viola.gender/_latestVersion)
[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![API](https://img.shields.io/badge/API-21+-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15)
[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=flat)](https://github.com/darwinfrancis/face-perception/blob/master/LICENSE.txt)


Using Viola gender classification library, you can find gender of a given face bitmap image.

![ScreenShot](screenshot/screen_shot_1.jpg)

## Getting Started
**Demo application**

Download sample application [sample_v_1.0.1](viola-gender-sample-v1.0.1.apk)

**Compatibility**
 * *Minimum Android SDK* : Viola Gender 1.0.1 requires a minimum API level of 21.

**Installation**

Download the latest aar from [JCenter](https://bintray.com/darwinfrancis/Viola/download_file?file_path=com%2Fdarwin%2Fviola%2Fgender%2F1.0.1%2Fgender-1.0.1.aar) or grab via

Gradle:
```gradle
dependencies {
  implementation 'com.darwin.viola:gender:1.0.1'
}
```

or Maven:

```xml
<dependency>
  <groupId>com.darwin.viola</groupId>
  <artifactId>gender</artifactId>
  <version>1.0.1</version>
  <type>pom</type>
</dependency>
```


## Usage
**Kotlin**
```kotlin
val violaGenderClassifier = ViolaGenderClassifier(listener)

violaGenderClassifier.findGenderAsync(bitmap) //asynchronous call using callback interface         

private val listener: GenderClassificationListener = object : GenderClassificationListener {

        override fun onGenderClassificationResult(result: List<GenderRecognition>) {}

        override fun onGenderClassificationError(error: String) {}
}


//OR using synchronous function call
val result:List<GenderRecognition> = violaGenderClassifier.findGenderSynchronized(faceBitmap)   //synchronous call   
```
*with GenderOptions*
```kotlin
val genderOption =
    GenderOptions.Builder()
               .enableFacePreValidation()
               .build()
violaGenderClassifier.findGenderAsync(bitmap,genderOption)
```

**Java**
```java
ViolaGenderClassifier violaGenderClassifier = new ViolaGenderClassifier(listener);

violaGenderClassifier.findGenderAsync(bitmap); //asynchronous call using callback interface

private final GenderClassificationListener listener = new GenderClassificationListener() {
        @Override
        public void onGenderClassificationResult(@NotNull List<GenderRecognition> result) { }

        @Override
        public void onGenderClassificationError(@NotNull String error) { }
};

//OR using synchronous function call
List<GenderRecognition> result = violaGenderClassifier.findGenderSynchronized(faceBitmap);   //synchronous call
```
*with GenderOptions*
```java
GenderOptions genderOption = new GenderOptions.Builder()
                .enableFacePreValidation()
                .build();
violaGenderClassifier.findGenderAsync(bitmap,ageOption)
```

### Configure the gender classifier
Viola gender-classifier is currently extended with the following configurations. Instructions on how to use them in your own application are linked below.

| GenderOptions | Description | Type | Default |
| :--- | :--- | :--- | :--- |
| `preValidateFace` |  Indicates whether to validate face presence before gender classification (ignore this if input image has valid face in it.) | boolean | false |

### Gender classification result
Viola Gender Classification provides the following values in Result class

| Result | Description | Type |
| :--- | :--- | :--- |
| `result` |  gender recognition result list | GenderRecognition |

## Author
Darwin Francis - @darwinfrancis on GitHub, @darwin-francis on linkedin

## Other works
[Viola-Face](https://github.com/darwinfrancis/viola) face detection and crop library for android.</br>
[Viola-Age](https://github.com/darwinfrancis/viola-age) age classification library for android.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

License
-------

    MIT License

    Copyright (c) 2020 Darwin Francis

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
