plugins {
    alias(libs.plugins.kinopoisk.jvm.library)
}
dependencies {
    implementation(libs.javax.inject)
    implementation(libs.paging.common)
    implementation(libs.kotlinx.datetime)
}
