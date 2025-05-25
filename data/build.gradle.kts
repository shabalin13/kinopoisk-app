import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kapt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.shabalin13.kinopoisk.data"
    compileSdk = 35

    defaultConfig {
        minSdk = 27

        val properties = Properties().apply {
            load(rootProject.file("local.properties").inputStream())
        }

        buildConfigField("String", "BASE_URL", properties.getProperty("BASE_URL"))
        buildConfigField("String", "API_KEY", properties.getProperty("API_KEY"))

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    // Android
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Local
    implementation(project(":domain"))

    // Dagger
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.kotlinx.serialization)

    // Retrofit Adapters Result
    implementation(libs.retrofit.adapters.result)

    // OkHttp
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    // Kotlin Serialization
    implementation(libs.kotlinx.serialization.json)

    // Paging
    implementation(libs.paging.runtime)
}
