import org.gradle.jvm.tasks.Jar
import java.io.*
import java.nio.file.*
import java.util.concurrent.*
import java.util.stream.Collectors

// by ice1000
val comingVersion = "1.0.0"
val packageName = "org.eeml"

group = packageName
version = comingVersion

buildscript {
	repositories {
		mavenCentral()
		jcenter()
	}

	dependencies { 	classpath(kotlin("gradle-plugin", "1.2.31")) }
}

plugins {
	java
}

java {
	sourceCompatibility = JavaVersion.VERSION_1_8
	targetCompatibility = JavaVersion.VERSION_1_8
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
	maven("https://jitpack.io")
}

dependencies {
	compile(group = "com.github.cqjjjzr", name = "Gensokyo", version = "1.1")
	testCompile("junit", "junit", "4.12")
}
