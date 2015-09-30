# DaggerEspressoMockito
Simple project using Dagger + Espresso + Mockito


# Configure build.gradle

```
apply plugin: 'com.android.application'
apply plugin: 'com.neenbedankt.android-apt'
buildscript {
   repositories {
       jcenter()
       mavenCentral()
   }
   dependencies {
       classpath 'com.neenbedankt.gradle.plugins:android-apt:1.4'
   }
}
[…]
dependencies {
   compile fileTree(dir: 'libs', include: ['*.jar'])
   testCompile 'junit:junit:4.12'
   androidTestCompile 'com.android.support.test:runner:0.2'
   androidTestCompile 'com.android.support.test:rules:0.2'
   androidTestCompile 'com.android.support.test.espresso:espresso-core:2.1'
   androidTestCompile 'com.android.support.test.espresso:espresso-intents:2.1'
   androidTestCompile 'org.mockito:mockito-core:1.10.19'
   androidTestCompile 'com.google.dexmaker:dexmaker:1.2'
   androidTestCompile 'com.google.dexmaker:dexmaker-mockito:1.2'
   provided 'org.glassfish:javax.annotation:10.0-b28'
   apt 'com.google.dagger:dagger-compiler:2.0'
   compile 'com.google.dagger:dagger:2.0'
}
```

# Annotation error
- Add it in build.gradle
```provided 'org.glassfish:javax.annotation:10.0-b28'```

# Crash: Caused by: java.lang.ClassCastException: android.app.Application cannot be cast to com.savinoordine.daggerespressomockito.DemoApplication

Add in manifest file:

```
<application
   android:name="com.savinoordine.daggerespressomockito.DemoApplication"
...
```

# When execute a test => 
 - Caused by: org.mockito.cglib.core.CodeGenerationException: java.lang.reflect.InvocationTargetException-->null

Add in build.gradle:

```
androidTestCompile 'com.google.dexmaker:dexmaker:1.2'
androidTestCompile 'com.google.dexmaker:dexmaker-mockito:1.2'
```
