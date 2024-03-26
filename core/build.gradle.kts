
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

apply ("../shared_dependencies.gradle")

android {
    namespace = "com.submission.expert1.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField("String", "HOST_NAME", "\"rawg.io\"")

        buildConfigField("String", "BASE_URL", "\"https://api.rawg.io/api/\"")

        buildConfigField("String", "SERVER_KEY", "\"sha256/KgyOSpsq6+nlxUBonR1zCRB7+Fg5tEsMluevNjtOGcY=\"")

        buildConfigField("String", "API_KEY", "\"9003e2d4e61a4c19a3971c0265eff6a2\"")

    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = true
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
}

dependencies {
    //Database Encryption
    implementation("net.zetetic:android-database-sqlcipher:4.4.3")
    implementation("androidx.sqlite:sqlite-ktx:2.4.0")
}