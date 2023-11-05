plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
    id ("com.google.gms.google-services")
    id ("com.google.firebase.crashlytics")
    id ("kotlin-parcelize")
    id ("com.google.devtools.ksp") version "1.8.20-1.0.11"
}

android {

    applicationVariants.all {
        addJavaSourceFoldersToModel(
            File(buildDir, "generated/ksp/$name/kotlin")
        )
    }

    namespace = "com.mubarak.tmdb"
    compileSdk = (34)

    defaultConfig {
        applicationId = "com.mubarak.tmdb"
        minSdk = (23)
        targetSdk = (33)
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.6"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}


dependencies {
    implementation ("androidx.core:core-ktx:1.10.1")
    implementation ("androidx.compose.ui:ui:1.5.0")
    implementation ("androidx.preference:preference-ktx:1.2.1")
    implementation ("androidx.compose.foundation:foundation:1.5.0")
    implementation ("androidx.compose.material:material:1.5.0")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.5.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation ("androidx.activity:activity-compose:1.7.2")
    implementation ("com.google.firebase:firebase-analytics-ktx:21.3.0")
    implementation ("com.google.firebase:firebase-crashlytics-ktx:18.4.0")
    implementation ("com.google.firebase:firebase-messaging-ktx:23.2.1")
    implementation ("androidx.work:work-runtime-ktx:2.8.1")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.5.0")
    debugImplementation ("androidx.compose.ui:ui-tooling:1.5.0")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:1.5.0")

    //hilt
    implementation ("com.google.dagger:hilt-android:2.47")
    kapt ("com.google.dagger:hilt-compiler:2.44.2")
    kapt ("androidx.hilt:hilt-compiler:1.0.0")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")

    // navigation
    implementation ("androidx.navigation:navigation-compose:2.7.0")

    //material io
    implementation ("com.google.android.material:material:1.9.0")
    implementation ("androidx.compose.material3:material3:1.1.1")
    implementation ("androidx.compose.material3:material3-window-size-class:1.1.1")
    implementation ("androidx.compose.material:material-icons-extended:1.5.4")

    //splash
    implementation ("androidx.core:core-splashscreen:1.0.1")

    //Room
    ksp ("androidx.room:room-compiler:2.5.2")
    implementation ("androidx.room:room-ktx:2.5.2")
    implementation ("androidx.room:room-runtime:2.5.2")

    // Lifecycle components
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-common-java8:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")

    // Kotlin components
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.0")
    api ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")
    api ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.2")

    //Gson
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // define a BOM okhttp and its version
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.10.0"))

    // define any required OkHttp artifacts without version
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    //coil
    implementation("io.coil-kt:coil-compose:2.4.0")

    //ksp
    implementation("com.google.devtools.ksp:symbol-processing-api:1.9.0-1.0.13")

    //chucker
    debugImplementation ("com.github.chuckerteam.chucker:library:4.0.0")
    releaseImplementation ("com.github.chuckerteam.chucker:library-no-op:4.0.0")

    //compose-destinations
    implementation ("io.github.raamcosta.compose-destinations:core:1.9.52")
    ksp ("io.github.raamcosta.compose-destinations:ksp:1.9.52")

    //palette
    implementation("androidx.palette:palette-ktx:1.0.0")

    //landscapist
    implementation ("com.github.skydoves:landscapist-coil:2.2.6")
    implementation ("com.github.skydoves:landscapist-palette:2.2.6")
    implementation ("com.github.skydoves:landscapist-transformation:2.2.6")
    implementation ("com.github.skydoves:landscapist-animation:2.2.6")

    // Paging
    implementation ("androidx.paging:paging-runtime-ktx:3.2.0")
    implementation ("androidx.paging:paging-compose:3.2.0")

    //accompanist
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.30.0")

}