@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
}

apply("$rootDir/plugins/android-build.gradle")

android {
    namespace = "br.leeloo.catpaprika.coins"

}

dependencies {
    implementation(project(Modules.domain))
    implementation(project(Modules.remote))
    implementation(libs.androidx.paging.common.ktx)
    implementation(libs.lifecycleRuntime)
    debugImplementation(libs.androidx.ui.tooling)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
}
