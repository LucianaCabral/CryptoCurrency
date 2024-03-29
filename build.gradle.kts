// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.hiltAndroidPlugin) apply false
    alias(libs.plugins.devtoolsKsp) apply  false
    alias(libs.plugins.kotlinParcelize) apply false
    alias(libs.plugins.kotlinJvm) apply false
}
true // Needed to make the Suppress annotation work for the plugins block
