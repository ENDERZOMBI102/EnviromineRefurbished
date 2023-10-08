@file:Suppress( "UnstableApiUsage", "HasPlatformType")
plugins {
    id( "org.quiltmc.loom" ) version "1.+"
	id( "org.jetbrains.kotlin.jvm" ) version "1.9.0"
    idea
}

repositories {
	mavenCentral()
	maven( url = "https://server.bbkr.space/artifactory/libs-release" )
	maven( url = "https://maven.ladysnake.org/releases" )
	maven( url = "https://maven.terraformersmc.com/releases" )
	maven( url = "https://repsy.io/mvn/enderzombi102/mc" )
	maven( url = "https://aperlambda.github.io/maven" )
	maven( url = "https://maven.shedaniel.me" )
	maven( url = "https://maven.gudenau.net" )
	maven( url = "https://maven.gegy.dev" )
	maven( url = "https://jitpack.io" )
}

val minecraftVersion = "1.19.2"
val mappingsVersion = "22"
val loaderVersion = "0.21.0"
val floaderVersion = "0.11.6"
val apiVersion = "4.0.0-beta.30+0.76.0"

dependencies {
	//to change the versions see the gradle.properties file
	minecraft( "com.mojang:minecraft:$minecraftVersion" )
	mappings( "org.quiltmc:quilt-mappings:$minecraftVersion+build.$mappingsVersion:intermediary-v2" )
	modImplementation( "org.quiltmc:quilt-loader:$loaderVersion" )

	// Fabric API. This is technically optional, but you probably want it anyway.
	modImplementation( "org.quiltmc.quilted-fabric-api:quilted-fabric-api:$apiVersion-$minecraftVersion" )
	
	/* mod dependencies */
	
	// config
	modApi("me.shedaniel.cloth:cloth-config-fabric:${project.ext["clothconfig_version"]}") {
		exclude(group="net.fabricmc.fabric-api")
	}

	// modmenu
	modImplementation( "com.terraformersmc:modmenu:${project.ext["modmenu_version"]}" )

	// cardinal components
	modImplementation( "io.github.onyxstudios:Cardinal-Components-API:${project.ext["cca_version"]}" )

	// trinkes
	modImplementation( "dev.emi:trinkets:${project.ext["trinkets_version"]}" )

	// spruce ui
	include( modImplementation("dev.lambdaurora:spruceui:${project.ext["spruceui_version"]}")!! )

	// libgui
	include( modImplementation("io.github.cottonmc:LibGui:${project.ext["libgui_version"]}")!! )

	/* lib dependencies */

}

tasks.withType<ProcessResources> {
	inputs.property( "version", project.version )
	inputs.property( "minecraft_version", minecraftVersion )
	inputs.property( "loader_version", floaderVersion )
	filteringCharset = "UTF-8"

	filesMatching( "fabric.mod.json" ) {
		expand(
			"version" to version,
			"minecraft_version" to minecraftVersion,
			"loader_version" to floaderVersion
		)
	}
}

tasks.withType<JavaCompile> {
	options.encoding = "UTF-8"
	options.release.set( 17 )
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
	kotlinOptions.jvmTarget = "17"
	kotlinOptions.languageVersion = "1.9"
}

java {
	withSourcesJar()
	toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks.withType<Jar> {
	filesMatching( "LICENSE" ) {
		rename { "${it}_$archiveBaseName"}
	}
}

val cleanLogs by tasks.registering {
	description = "Cleans the logs folder"

	shouldRunAfter( tasks.runClient )
	shouldRunAfter( tasks.runServer )

	doFirst {
		// delete all logs
		file( "run/logs" ).listFiles()?.forEach( File::delete )
	}
}
