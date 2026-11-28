// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.compose.compiler) apply false
  alias(libs.plugins.kotlin.serialization) apply false
  alias(libs.plugins.wire) apply false
}

// Automatically decode release keystore from environment secret if present (e.g. in CI)
val releaseKeystoreBase64 = System.getenv("RELEASE_KEYSTORE_BASE64")
if (!releaseKeystoreBase64.isNullOrBlank()) {
    val jksFile = file("app/release.jks")
    if (!jksFile.exists()) {
        jksFile.parentFile.mkdirs()
        jksFile.writeBytes(java.util.Base64.getDecoder().decode(releaseKeystoreBase64))
    }
}
