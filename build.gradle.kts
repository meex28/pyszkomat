// TODO: Can be moved to buildSrc and conventions?
plugins {
    id("java")
    id("org.springframework.boot") version "3.4.4"
    id("io.spring.dependency-management") version "1.1.7"
}

allprojects {
    group = "com.isi.pyszkomat"
    version = "1.0.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    java {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.cloud:spring-cloud-config-server")
        implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-server")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    }

    dependencyManagement {
        imports {
            // TODO: Extract version to some property
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:2024.0.1")
        }
    }
}
