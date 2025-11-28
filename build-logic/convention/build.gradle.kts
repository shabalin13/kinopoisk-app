plugins {
    `kotlin-dsl`
}
group = "com.shabalin13.kinopoisk.buildlogic"
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}
dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}
gradlePlugin {
    plugins {
        register("androidApplication") {
            id = libs.plugins.kinopoisk.android.application.asProvider().get().pluginId
            implementationClass =
                "com.shabalin13.kinopoisk.convention.AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = libs.plugins.kinopoisk.android.application.compose.get().pluginId
            implementationClass =
                "com.shabalin13.kinopoisk.convention.AndroidApplicationComposeConventionPlugin"
        }
        register("jvmLibrary") {
            id = libs.plugins.kinopoisk.jvm.library.get().pluginId
            implementationClass = "com.shabalin13.kinopoisk.convention.JvmLibraryConventionPlugin"
        }
        register("androidLibrary") {
            id = libs.plugins.kinopoisk.android.library.asProvider().get().pluginId
            implementationClass =
                "com.shabalin13.kinopoisk.convention.AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = libs.plugins.kinopoisk.android.library.compose.get().pluginId
            implementationClass =
                "com.shabalin13.kinopoisk.convention.AndroidLibraryComposeConventionPlugin"
        }
        register("androidFeature") {
            id = libs.plugins.kinopoisk.android.feature.get().pluginId
            implementationClass =
                "com.shabalin13.kinopoisk.convention.AndroidFeatureConventionPlugin"
        }
        register("dagger") {
            id = libs.plugins.kinopoisk.dagger.get().pluginId
            implementationClass = "com.shabalin13.kinopoisk.convention.DaggerConventionPlugin"
        }
    }
}
