import io.gitlab.arturbosch.detekt.extensions.DetektExtension

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.detekt) apply false
}

subprojects {
    afterEvaluate {
        if (plugins.hasPlugin(libs.plugins.kotlin.android.get().pluginId) ||
            plugins.hasPlugin(libs.plugins.kotlin.jvm.get().pluginId)
        ) {
            apply(plugin = libs.plugins.detekt.get().pluginId)
            dependencies.add("detektPlugins", libs.detekt.formatting.get())
            extensions.configure<DetektExtension> {
                config.setFrom(rootProject.files("config/detekt/detekt.yml"))
            }
        }
    }
}
