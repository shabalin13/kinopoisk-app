plugins {
    alias(libs.plugins.kinopoisk.android.library.compose)
    alias(libs.plugins.kinopoisk.android.feature)
    alias(libs.plugins.kinopoisk.dagger)
}

android {
    namespace = "com.shabalin13.kinopoisk.mediaCatalog"
}

dependencies {
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.navigation.compose)
    implementation(libs.glide.compose)
    implementation(libs.compose.shimmer)
    implementation(libs.paging.runtime)
    implementation(libs.paging.compose)
}
