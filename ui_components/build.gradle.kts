@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
}

android {
    namespace = libs.versions.namespace.get()
    compileSdk = libs.versions.compile.sdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.min.sdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(platform(libs.compose.bom))
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui.graphics)
    implementation(libs.androidx.animation.graphics)
    androidTestImplementation(platform(libs.compose.bom))

    implementation(libs.bundles.compose)
    implementation(libs.compose.animation)
    implementation(libs.accompanist.drawablepainter)
    androidTestImplementation(platform(libs.compose.bom))

    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.junit4)
    debugImplementation(libs.compose.ui.test.manifest)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}


afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                groupId = "com.github.bernardoslailati"
                artifactId = "localiza-jdc-designsystem"
                version = "1.0"

                afterEvaluate {
                    from(components["release"])
                }
            }
        }
    }
}