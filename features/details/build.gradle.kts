plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
}

apply("$rootDir/plugins/android-build.gradle")

android {
    namespace = "br.leeloo.coinpaprika.features.details"
}

dependencies {
    implementation(project(Modules.domain))
    implementation(project(Modules.navigation))
    implementation(project(Modules.remote))
    implementation(libs.coil)
    debugImplementation(libs.androidx.compose.ui.ui.tooling)
}
