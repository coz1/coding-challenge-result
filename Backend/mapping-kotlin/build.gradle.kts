import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	val kotlinVersion = "1.4.21"
	kotlin("jvm") version kotlinVersion
	kotlin("plugin.spring") version kotlinVersion
	kotlin("kapt") version "1.5.0"

	id("org.springframework.boot") version "2.4.0"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
}

group = "com.mhp.coding.challenges"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	implementation("org.mapstruct:mapstruct:1.4.2.Final")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.4.2.Final")
	testAnnotationProcessor("org.mapstruct:mapstruct-processor:1.4.2.Final")

	implementation("junit:junit:4.13.2")

	implementation("org.mockito:mockito-core:3.10.0")
	testImplementation("org.mockito:mockito-inline:2.13.0")
	kapt("org.mapstruct:mapstruct-processor:1.4.2.Final")

}

tasks {
	withType<KotlinCompile> {
		kotlinOptions {
			jvmTarget = "1.8"
			apiVersion = "1.4"
			languageVersion = "1.4"
			freeCompilerArgs = listOf("-Xjsr305=strict","-Xjvm-default=all-compatibility")
		}
	}
	withType<Test> {
		useJUnitPlatform()
		testLogging {
			events("passed", "skipped", "failed")
		}
	}
}
