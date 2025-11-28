package com.shabalin13.kinopoisk.convention

import com.shabalin13.kinopoisk.support.configureKotlinJvm
import org.gradle.api.Plugin
import org.gradle.api.Project

class JvmLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.jvm")
                apply("java-library")
            }

            configureKotlinJvm()
        }
    }
}
