import java.util.Properties

plugins {
    alias(libs.plugins.kinopoisk.android.application.compose)
    alias(libs.plugins.kinopoisk.dagger)
}

android {
    namespace = "com.shabalin13.kinopoisk"

    defaultConfig {
        applicationId = "com.shabalin13.kinopoisk"
        versionCode = 1
        versionName = "1.0"
    }
    signingConfigs {
        create("release") {
            val keystoreProperties = Properties()
            val keystorePropsFile = rootProject.file("keystore.properties")

            if (keystorePropsFile.exists()) {
                keystorePropsFile.inputStream().use {
                    keystoreProperties.load(it)
                }
                storeFile = rootProject.file(keystoreProperties.getProperty("storeFile"))
                storePassword = keystoreProperties.getProperty("storePassword")
                keyAlias = keystoreProperties.getProperty("keyAlias")
                keyPassword = keystoreProperties.getProperty("keyPassword")
            } else {
                storeFile = rootProject.file("keystore/${System.getenv("KEYSTORE_FILE")}")
                storePassword = System.getenv("KEYSTORE_PASSWORD")
                keyAlias = System.getenv("KEYSTORE_SIGN_KEY_ALIAS")
                keyPassword = System.getenv("KEYSTORE_SIGN_KEY_PASSWORD")
            }
        }
    }
    buildTypes {
        release {
            signingConfig = signingConfigs["release"]
        }
    }
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.network)
    implementation(projects.core.data)
    implementation(projects.core.navigation)
    implementation(projects.core.ui)
    implementation(projects.core.common)
    implementation(projects.feature.mediaCatalog)
    implementation(projects.feature.mediaDetails)

    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.navigation.compose)
}
