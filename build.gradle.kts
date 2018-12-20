import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	val kotlinVersion = "1.3.11"
	kotlin("jvm") version kotlinVersion
	java
	id("org.springframework.boot") version "2.1.1.RELEASE"
	id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
}

apply(plugin = "io.spring.dependency-management")

repositories {
	jcenter()
}

dependencies {
	implementation(kotlin("stdlib"))

	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.hateoas:spring-hateoas")
}

group = "org.t4atf.contract"
version = "0.0.1-SNAPSHOT"

tasks {
	withType(KotlinCompile::class.java).all {
		kotlinOptions {
			jvmTarget = "1.8"
			freeCompilerArgs = listOf("-Xjsr305=strict")
		}
	}
}