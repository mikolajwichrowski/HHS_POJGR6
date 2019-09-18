/*
 * Build gradle file
 */

plugins {
    // Apply the java plugin to add support for Java
    java

    // Apply the application plugin to add support for building a CLI application
    application

    // Apply plugin for code coverage
    jacoco
}

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}

dependencies {
    // This dependencies are used by the application.
    implementation("com.google.guava:guava:28.0-jre")
    implementation("com.github.cliftonlabs:json-simple:3.1.0")

    // Use JUnit test framework
    testImplementation("junit:junit:4.12")


}

application {
    // Define the main class for the application
    mainClassName = "HHS_PROJGR6.App"
}
