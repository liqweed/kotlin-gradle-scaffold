import org.gradle.script.lang.kotlin.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	java
    id("org.jetbrains.kotlin.jvm") version "1.1.3"
	id("org.jetbrains.kotlin.plugin.spring") version "1.1.3"
	id("com.github.ben-manes.versions") version "0.15.0"
}

tasks.withType<KotlinCompile> {
	kotlinOptions.jvmTarget = "1.8"
}

val kotlinVersion = "1.1.3"

dependencies {
	compile("org.jetbrains.kotlin:kotlin-stdlib-jre8")
	compile("io.github.microutils:kotlin-logging:1.4.5")

	testCompile("org.amshove.kluent:kluent:1.23")
	testCompile("com.nhaarman:mockito-kotlin-kt1.1:1.5.0")
	testCompile("org.awaitility:awaitility:3.0.0")
	testCompile("org.awaitility:awaitility-proxy:3.0.0")
}

configurations {
	"all*" { exclude(module = "commons-logging") }
	"all*" { exclude(module = "commons-logging-api") }
	"all*" { exclude(module = "log4j") }
	"all*" { exclude(module = "ch.qos.logback") }
}

repositories {
	jcenter()
}
