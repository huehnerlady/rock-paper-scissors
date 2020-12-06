import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.4.10"
  application
}

group = "de.ruth.motza"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation("io.kotest:kotest-runner-junit5:4.3.1")
  testImplementation("io.kotest:kotest-assertions-core:4.3.1")
  testImplementation("io.kotest:kotest-property:4.3.1")
  testImplementation("io.mockk:mockk:1.10.3")
}

tasks {
  test {
    useJUnitPlatform()
  }
  build{
    dependsOn(test)
  }
  withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "14"
  }
}

application {
  mainClassName = "de.ruth.motza.MainKt"
}
