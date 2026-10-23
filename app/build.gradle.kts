plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)

    id("org.jetbrains.kotlin.plugin.serialization") version "2.3.21"
}

android {
    namespace = "com.vishal.recipeapp"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.vishal.recipeapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)

    //For ktor Http client

// ye ktor client ktor ka main system hai

    implementation("io.ktor:ktor-client-core:1.19.0")

    //ye android plateform supper krta hai jise android device pr application run ho sake

    implementation("io.ktor:ktor-client-android:3.6.0")

    // ye data convertion manage krta hai
    implementation("io.ktor:ktor-client-content-negotiation:3.6.0")

    // ye "json" data ko object main convert krta hai
    implementation("io.ktor:ktor-serialization-kotlinx-json:3.6.0")

    //For Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.11.0")



    // Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.10.2")

    // ViewModel Compose

    // iska kaam compose ui ko viewodel ke sath connect krta hai

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.11.0")

    //For Coil URL to Imgage
    implementation("io.coil-kt:coil-compose:2.7.0")

    //For Extra Icons

    implementation("androidx.compose.material:material-icons-extended")


}