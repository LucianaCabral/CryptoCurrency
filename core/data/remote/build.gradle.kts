@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
}

apply("$rootDir/plugins/android-build.gradle")

android {
    namespace = "br.leeloo.coinpaprika.core.data.remote"

}

dependencies {
    // Libs
    implementation(libs.gson)
    implementation(libs.gsonConverter)
    implementation(libs.loggingInterceptor)
    implementation(libs.retrofit)

}
