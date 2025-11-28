plugins {
    alias(libs.plugins.kinopoisk.android.library.compose)
}

android {
    namespace = "com.shabalin13.kinopoisk.ui"
}

dependencies {
    implementation(libs.javax.inject)
}
