plugins {
    alias(libs.plugins.android.application)
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1" // O la versión que te haya puesto Android Studio al crear el proyecto
    }
    namespace = "com.example.proyectopractico"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.example.proyectopractico"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)

    // Compose dependencies
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    debugImplementation(libs.androidx.compose.ui.tooling)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)

    // Retrofit para las peticiones HTTP a la API REST
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    // Converter Gson para convertir los JSON a data class de Kotlin
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    // Coil para cargar las imágenes de las cartas en Compose desde Internet
    implementation("io.coil-kt:coil-compose:2.7.0")
    // ViewModel para gestionar el estado de la pantalla
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")
}
