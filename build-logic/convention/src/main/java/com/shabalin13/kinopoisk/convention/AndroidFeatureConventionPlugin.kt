package com.shabalin13.kinopoisk.convention

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.shabalin13.kinopoisk.android.library")
            }

            dependencies {
                add("implementation", project(":core:domain"))
                add("implementation", project(":core:navigation"))
                add("implementation", project(":core:ui"))
            }
        }
    }
}
