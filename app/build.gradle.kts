plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
    id ("com.google.gms.google-services")
    id ("com.google.firebase.crashlytics")
    id ("kotlin-parcelize")
    id ("com.google.devtools.ksp") version "1.8.0-1.0.9"
}

kotlin {
    sourceSets {
        debug {
            kotlin.srcDir("build/generated/ksp/debug/kotlin")
        }
        release {
            kotlin.srcDir("build/generated/ksp/release/kotlin")
        }
    }
}


android {
    namespace = "com.mubarak.tmbd"
    compileSdk = (34)

    defaultConfig {
        applicationId = "com.mubarak.tmbd"
        minSdkVersion (23)
        targetSdkVersion (33)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName ("release") {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}


dependencies {
    implementation ("androidx.core:core-ktx:1.10.1")
    implementation ("androidx.compose.ui:ui:1.4.3")
    implementation ("androidx.compose.material:material:1.4.3")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.4.3")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation ("androidx.activity:activity-compose:1.7.1")
    implementation ("com.google.firebase:firebase-analytics-ktx:21.2.2")
    implementation ("com.google.firebase:firebase-crashlytics-ktx:18.3.7")
    implementation ("com.google.firebase:firebase-messaging-ktx:23.1.2")
    implementation ("androidx.work:work-runtime-ktx:2.8.1")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.4.3")
    debugImplementation ("androidx.compose.ui:ui-tooling:1.4.3")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:1.4.3")

    //hilt
    implementation ("com.google.dagger:hilt-android:2.44.2")
    kapt ("com.google.dagger:hilt-compiler:2.44.2")
    kapt ("androidx.hilt:hilt-compiler:1.0.0")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")

    // navigation
    implementation ("androidx.navigation:navigation-compose:2.7.0")

    //material io
    implementation ("com.google.android.material:material:1.9.0")
    implementation ("androidx.compose.material3:material3:1.1.0")
    implementation ("androidx.compose.material3:material3-window-size-class:1.1.0")

    //splash
    implementation ("androidx.core:core-splashscreen:1.0.1")

    //Room
    kapt ("androidx.room:room-compiler:2.5.1")
    implementation ("androidx.room:room-ktx:2.5.1")
    implementation ("androidx.room:room-runtime:2.5.1")


    // Lifecycle components
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-common-java8:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")

    // Kotlin components
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.20")
    api ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    api ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    // Worker
    implementation ("androidx.work:work-runtime-ktx:2.8.1")

    //Gson
    implementation ("com.google.code.gson:gson:2.9.1")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // define a BOM okhttp and its version
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.10.0"))

    // define any required OkHttp artifacts without version
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

}

//
//// Allow references to generated code
//kapt {
//    correctErrorTypes = true
//    mapDiagnosticLocations = true
//}
//
//hilt {
//    enableAggregatingTask = true
//}
//
//dependencies {
//
//    implementation("androidx.core:core-ktx:1.10.1")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
//    implementation("androidx.activity:activity-compose:1.7.2")
//    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
//    implementation("androidx.compose.ui:ui")
//    implementation("androidx.compose.ui:ui-graphics")
//    implementation("androidx.compose.ui:ui-tooling-preview")
//    implementation("androidx.compose.material3:material3")
//    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
//    debugImplementation("androidx.compose.ui:ui-tooling")
//    debugImplementation("androidx.compose.ui:ui-test-manifest")
//
//    //coil
//    implementation("io.coil-kt:coil-compose:2.4.0")
//
//    // Kotlin components
//    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.22")
//    api ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
//    api ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
//
//    // Dependency Injection
//    implementation("com.google.dagger:hilt-android:2.44.2")
//    kapt("com.google.dagger:hilt-android-compiler:2.44")
//    implementation("androidx.hilt:hilt-work:1.0.0")
//    kapt("androidx.hilt:hilt-compiler:1.0.0")
//    implementation("androidx.work:work-runtime-ktx:2.8.1")
//    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
//
//    // Lifecycle
//    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
//    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")
//    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
//    implementation ("androidx.lifecycle:lifecycle-common-java8:2.6.1")
//
//    // Jetpack Compose
//    implementation("androidx.activity:activity-compose:1.7.2")
//    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
//    implementation("androidx.compose.runtime:runtime-livedata:1.5.0")
//
//// Retrofit for network requests
//    implementation("com.squareup.retrofit2:retrofit:2.9.0")
//    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
//
//
//// Coroutines for asynchronous programming
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
//
//    //gson
//    implementation("com.google.code.gson:gson:2.10.1")
//
//    // define a BOM okhttp and its version
//    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.10.0"))
//
//    // define any required OkHttp artifacts without version
//    implementation("com.squareup.okhttp3:okhttp")
//    implementation("com.squareup.okhttp3:logging-interceptor")
//
//    //material io
//    implementation ("com.google.android.material:material:1.9.0")
//    implementation ("androidx.compose.material3:material3:1.1.1")
//    implementation ("androidx.compose.material3:material3-window-size-class:1.1.1")
//}