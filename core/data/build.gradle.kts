plugins {
    alias(libs.plugins.kinopoisk.android.library)
    alias(libs.plugins.kinopoisk.dagger)
}

android {
    namespace = "com.shabalin13.kinopoisk.data"
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.domain)
    implementation(projects.core.network)
    implementation(libs.kotlinx.datetime)
    implementation(libs.paging.runtime)
}
