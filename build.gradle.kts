import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.32"
}

group = "me.andreia"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test-junit"))
    implementation( "io.javalin:javalin:4.1.1")
    implementation("org.slf4j:slf4j-simple:1.7.32")
    implementation("org.jetbrains.exposed:exposed:0.17.14")
    implementation("org.koin:koin-core:0.9.3")

}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
