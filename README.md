# Project : android-unittests-demo

The aim of this demo Android project is to illustrate **how to test Android `buildConfigField`**.

# Product Flavors

There're 2 flavor dimensions ("cheating" and "paid") and one `buildConfigField` for each dimension. Which result in :

Product flavors |  Dimension | Build config field | Value
------------ | ------------- | ------------- | -------------
Cheating | `cheating` | `CANT_CHEAT_VERSION` | `false`
Standard | `cheating` | `CANT_CHEAT_VERSION` | `true` (default)
Free | `paid` | `PAID_VERSION` | `false` (default)
Paid | `paid` | `PAID_VERSION` | `true`

Everything is written in the file [app/build.gradle](https://github.com/BapNesS/android-unittests-demo/blob/master/app/build.gradle).

# Test classes

If the behavior of your app depends on those build config fields, you don't need (and can't ?) to mock or spy the BuildConfig class.
Because :
1. It'll not be easy to mock this kind of class : `public final class BuildConfig`
1. It'll not be easy to mock this kind of field : `public static final boolean CANT_CHEAT_VERSION = false;`
1. It's just not the right way to do… :grimacing:

**The right way is to write test class by flavor :**

* Default unit tests :
  * `test/java/com/baptistecarlier/android/demo/ut/QuestionFactoryTest.kt`
  * `test/java/com/baptistecarlier/android/demo/ut/QuestionTest.kt`
  
* Cheating("*Cheating*") unit tests :
  * `testCheating/java/com/baptistecarlier/android/demo/ut/QuestionTestCheating.kt`
  
* Cheating("*Standard*") unit tests :
  * `testStandard/java/com/baptistecarlier/android/demo/ut/QuestionTestStandard.kt`
  
* Paid("*Free*") unit tests :
  * `testFree/java/com/baptistecarlier/android/demo/ut/QuestionFactoryTestFree.kt`
  
* Paid("*Paid*") unit tests :
  * `testPaid/java/com/baptistecarlier/android/demo/ut/QuestionFactoryTestPaid.kt`

Note the name of the first directory level. It should map with the product flavor like &laquo; test**Flavor**/ &raquo;.
The class name should also be unique. Here, I have suffixed the test class by the flavor :
 * `QuestionFactoryTest.kt` *(main test)*
 * `QuestionFactoryTestFree.kt`
 * `QuestionFactoryTestPaid.kt`
 * `QuestionTest.kt` *(main test)*
 * `QuestionTestCheating.kt`
 * `QuestionTestStandard.kt`

Sources : https://developer.android.com/studio/test/

# Launching all your unit tests

In Android Studio, you have to choose a build variant. So when you launch your tests, it only launch main unit tests and the tests for selected flavors.

You can't launch *Free* and *Paid* tests at the same time.

Fortunately, you can test from the command line :

## All the flavors :
```
./gradlew test
```

## One by one :
```
./gradlew testCheatingFreeDebugUnitTest
./gradlew testCheatingPaidDebugUnitTest
./gradlew testStandardFreeDebugUnitTest
./gradlew testStandardPaidDebugUnitTest
```

Sources : https://developer.android.com/studio/test/command-line
