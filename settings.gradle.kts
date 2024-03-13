pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CoinPaprika"
include(
    // Core
    ":app",
    ":core:domain",
    ":core:data:remote",
    ":core:navigation",

// Features
    ":features:coins"
)

