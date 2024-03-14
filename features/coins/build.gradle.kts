@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
}

apply("$rootDir/plugins/android-build.gradle")

android {
    namespace = "br.leeloo.coinpaprika.features.coins"

}

dependencies {
    implementation(project(Modules.domain))
    implementation(project(Modules.navigation))
    implementation(project(Modules.remote))
    implementation(libs.lifecycleRuntime)
    debugImplementation(libs.androidx.ui.tooling)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
}
