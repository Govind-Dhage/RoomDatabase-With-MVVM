plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.govind.dhage.ekacareroomdatabase"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.govind.dhage.ekacareroomdatabase"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.androidx.room.common)
    implementation(libs.androidx.room.common.jvm)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)


    implementation(libs.room.runtime)
    annotationProcessor(libs.room.compiler)

    //mvvm

    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel) // LiveData
    implementation (libs.androidx.lifecycle.livedata)

    annotationProcessor (libs.androidx.lifecycle.compiler)

    implementation(libs.lifecycle.viewmodel.savedstate)

    implementation (libs.lifecycle.extensions)
}