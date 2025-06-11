pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()

        // 🔧 Add this line:
        maven { url = uri("https://jitpack.io") }
    }
}


rootProject.name = "CalorieCounter"
include(":app")
 