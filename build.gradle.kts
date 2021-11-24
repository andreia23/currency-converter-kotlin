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
    implementation("io.javalin:javalin:2.6.0")
    implementation("org.slf4j:slf4j-simple:1.7.32")
    implementation("org.jetbrains.exposed:exposed:0.17.14")
    implementation("io.insert-koin:koin-gradle-plugin:3.1.3")
    implementation("com.natpryce:konfig:1.6.10.0")
    implementation("com.zaxxer:HikariCP:5.0.0")
    implementation("org.postgresql:postgresql:42.3.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.9.8")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")
    implementation("com.github.kittinunf.fuel:fuel:2.3.1")




}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
