@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
}

apply("$rootDir/plugins/android-build.gradle")

android {
    namespace = "br.leeloo.coinpaprika.core.data.remote"

    defaultConfig {
        buildConfigField("String", "BASE_URL", "\"https://api.coinpaprika.com/\"")
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    // Modules
    implementation(project(Modules.domain))

    // Libs
    api(libs.gson)
    api(libs.gsonConverter)
    implementation(libs.loggingInterceptor)
    implementation(libs.retrofit)
}
