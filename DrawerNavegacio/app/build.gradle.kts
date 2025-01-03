plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    //Serialització
    kotlin("plugin.serialization") version "2.0.21"

}

android {
    namespace = "cat.oriol.drawernavegacio"
    compileSdk = 34

    defaultConfig {
        applicationId = "cat.oriol.drawernavegacio"
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    //Pack extès d'icones
    implementation("androidx.compose.material:material-icons-extended")

    //Navigation
    implementation ("androidx.navigation:navigation-compose:2.8.3")
    //Serialització
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
    //trobar mida
    implementation("androidx.compose.material3.adaptive:adaptive:1.0.0")


    //Coil
    implementation("io.coil-kt:coil-compose:2.7.0")

    // Dades Fake
    implementation("io.github.serpro69:kotlin-faker:1.16.0")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}