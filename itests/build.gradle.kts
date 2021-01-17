plugins {
    id("java-library")
}

group = "io.github.consolero"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(project(":client"))
    testImplementation(project(":server"))

    val junitVersion = "5.7.0"
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")

    val springVersion = "2.4.2"
    testImplementation("org.springframework.boot:spring-boot-starter-test:${springVersion}")
    testImplementation("org.springframework.boot:spring-boot-starter-web:${springVersion}")
    testImplementation("org.springframework.data:spring-data-commons:${springVersion}")
    testImplementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.11.4")
    testImplementation("javax.validation:validation-api:2.0.1.Final")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
