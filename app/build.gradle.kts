@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinParcelize)
    kotlin("kapt")
}

apply("$rootDir/plugins/android-build.gradle")

android {
    namespace = "br.leeloo.coinpaprika"
}

dependencies {
    implementation(project(Modules.coins))
    implementation(project(Modules.details))
    implementation(project(Modules.domain))
    implementation(project(Modules.navigation))
    implementation(project(Modules.remote))
}
