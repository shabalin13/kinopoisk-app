plugins {
    alias(libs.plugins.kinopoisk.jvm.library)
    alias(libs.plugins.kinopoisk.dagger)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}
