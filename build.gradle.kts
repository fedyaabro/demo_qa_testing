plugins {
    id("java")
}

group = "qa_guru_hw3"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.6.0")
    testImplementation("com.codeborne:selenide:7.0.4")
}

tasks.test {
    useJUnitPlatform()
}