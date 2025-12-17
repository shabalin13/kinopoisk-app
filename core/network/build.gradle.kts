import java.util.Properties

plugins {
    alias(libs.plugins.kinopoisk.android.library)
    alias(libs.plugins.kinopoisk.dagger)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.shabalin13.kinopoisk.network"

    defaultConfig {
        val localProperties = Properties()
        val localPropsFile = rootProject.file("local.properties")

        if (localPropsFile.exists()) {
            localPropsFile.inputStream().use {
                localProperties.load(it)
            }
            buildConfigField("String", "BASE_URL", "\"${localProperties.getProperty("BASE_URL")}\"")
            buildConfigField("String", "API_KEY", "\"${localProperties.getProperty("API_KEY")}\"")
        } else {
            buildConfigField("String", "BASE_URL", "\"${System.getenv("KINOPOISK_BASE_URL")}\"")
            buildConfigField("String", "API_KEY", "\"${System.getenv("KINOPOISK_API_KEY")}\"")
        }
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.core.common)
    implementation(libs.retrofit)
    implementation(libs.converter.kotlinx.serialization)
    implementation(libs.retrofit.adapters.result)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    implementation(libs.kotlinx.serialization.json)
}
