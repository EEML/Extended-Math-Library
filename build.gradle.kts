import org.gradle.jvm.tasks.Jar
import java.io.*
import java.nio.file.*
import java.util.concurrent.*
import java.util.stream.Collectors

// by ice1000
val comingVersion = "0.0.1"
val packageName = "indi.eulir"

group = packageName
version = comingVersion

buildscript {
	repositories {
		mavenCentral()
		jcenter()
	}
}

plugins {
	java
}

java {
	sourceCompatibility = JavaVersion.VERSION_1_10
	targetCompatibility = JavaVersion.VERSION_1_10
}

tasks.withType<JavaCompile> {
	options.encoding = "UTF-8"
}

java.sourceSets {
	"main" {
		java.srcDirs("src")
		resources.srcDirs("res")
	}

	"test" {
		java.srcDirs("test")
	}
}

repositories {
	mavenCentral()
	jcenter()
}

dependencies {
	testCompile("junit", "junit", "4.12")
}
