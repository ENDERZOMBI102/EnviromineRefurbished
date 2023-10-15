@file:Suppress( "UnstableApiUsage", "HasPlatformType")
plugins {
    id( "org.quiltmc.loom" ) version "1.+"
	id( "org.jetbrains.kotlin.jvm" ) version "1.9.0"
    idea
}

repositories {
	mavenCentral()
	maven( url = "https://server.bbkr.space/artifactory/libs-release" )
	maven( url = "https://maven.terraformersmc.com/releases" )
	maven( url = "https://repsy.io/mvn/enderzombi102/mc" )
	maven( url = "https://maven.ladysnake.org/releases" )
	maven( url = "https://aperlambda.github.io/maven" )
	maven( url = "https://maven.nucleoid.xyz/" )
	maven( url = "https://maven.shedaniel.me" )
	maven( url = "https://maven.gudenau.net" )
	maven( url = "https://maven.gegy.dev" )
	maven( url = "https://jitpack.io" )
	exclusiveContent {
		forRepository { maven( url = "https://api.modrinth.com/maven" ) }
		filter { includeGroup( "maven.modrinth" ) }
	}
}

val minecraftVersion = "1.19.2"
val mappingsVersion = "22"
val loaderVersion = "0.21.0"
val floaderVersion = "0.11.6"
val apiVersion = "4.0.0-beta.30+0.76.0"

loom {
	runtimeOnlyLog4j.set( true )

	val config: net.fabricmc.loom.configuration.ide.RunConfigSettings.() -> Unit = {
		runDir = "run"
		isIdeConfigGenerated = true
//		vmArg( "-javaagent:\"$mixinsJar\"" )
		vmArg( "-XX:+AllowEnhancedClassRedefinition" )
		vmArg( "-Xmx3G" )
		vmArg( "-ea:com.enderzombi102.elysium" )
		vmArg( "-Dmixin.debug.export=true" )
		vmArg( "-Dlog4j.configurationFile=\"file:///$projectDir/log4j2.xml\"" )
		vmArg( "-Dloader.disable_forked_guis=true" )
		vmArg( "-Dloader.transform_cache.disable_preload=true" )
		vmArg( "-Dloader.transform_cache.disable_optimised_compression=true" )
		programArg( "--username=player" )
	}
	runConfigs.named( "client" ).configure( config )
	runConfigs.named( "server" ).configure( config )
}

/*
TODO: Add the following:
 - https://modrinth.com/mod/owo-lib ( evaluate )
 - https://modrinth.com/mod/notify ( evaluate )
 - https://modrinth.com/mod/fzzy-core ( evaluate )
 - https://modrinth.com/mod/interference ( evaluate )
 - https://modrinth.com/mod/resourceful-lib ( evaluate )
 */

dependencies {
	//to change the versions see the gradle.properties file
	minecraft( "com.mojang:minecraft:$minecraftVersion" )
	mappings( "org.quiltmc:quilt-mappings:$minecraftVersion+build.$mappingsVersion:intermediary-v2" )
	modImplementation( "org.quiltmc:quilt-loader:$loaderVersion" )

	// Fabric API. This is technically optional, but you probably want it anyway.
	modImplementation( "org.quiltmc.quilted-fabric-api:quilted-fabric-api:$apiVersion-$minecraftVersion" )
	
	/* mod dependencies */
	modImplementation( "com.terraformersmc:modmenu:4.2.0-beta.2" )
	modImplementation( "dev.onyxstudios.cardinal-components-api:cardinal-components-api:5.0.2" )
	modImplementation( "dev.emi:trinkets:3.4.1" ) // https://github.com/emilyploszaj/trinkets/wiki
	modImplementation( include( "dev.lambdaurora:spruceui:4.1.0+1.19.2" )!! ) // N/D
	modImplementation( include( "io.github.cottonmc:LibGui:6.4.0+1.19" )!! ) // https://github.com/CottonMC/LibGui/wiki

	modCompileOnly( "dev.emi:emi-fabric:1.0.21+1.19.2:api" ) // https://github.com/emilyploszaj/emi/wiki
	modLocalRuntime( "dev.emi:emi-fabric:1.0.21+1.19.2" )

	modImplementation( include( "com.github.thedeathlycow:thermoo:v1.4" )!! ) // https://github.com/TheDeathlyCow/thermoo/wiki
	modImplementation( "maven.modrinth:patchouli:1.19.2-77-fabric" ) // https://vazkiimods.github.io/Patchouli
	modImplementation( include( "eu.pb4:placeholder-api:2.0.0-pre.1+1.19.2" )!! ) // https://placeholders.pb4.eu

	modImplementation( include( "com.enderzombi102.EnderLib:minecraft:1.0.0+0.3.3-SNAPSHOT" )!! )

	/* lib dependencies */
	implementation( include( annotationProcessor( "io.github.llamalad7:mixinextras-fabric:0.2.0" )!! )!! ) // https://github.com/LlamaLad7/MixinExtras/wiki
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
	toolchain.languageVersion.set( JavaLanguageVersion.of( 17 ) )
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
