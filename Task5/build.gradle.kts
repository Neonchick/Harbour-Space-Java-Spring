plugins {
    java
    id("org.springframework.boot") version "3.0.2"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

tasks.named<org.springframework.boot.gradle.tasks.bundling.BootBuildImage>("bootBuildImage") {
    imageName.set("neonchick/docker-task2")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation ("org.springframework.boot:spring-boot-starter-actuator")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation ("org.junit.jupiter:junit-jupiter:5.6.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
