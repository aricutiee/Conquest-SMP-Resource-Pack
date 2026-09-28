plugins { java }
java { toolchain { languageVersion.set(JavaLanguageVersion.of(21)) } }
tasks.withType<JavaCompile>().configureEach { options.encoding = "UTF-8" }
val generatePack by tasks.registering(JavaExec::class) {
    dependsOn(tasks.classes)
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set("dev.turtleroles.assets.BadgeAssetGenerator")
    args("build/pack", "build/badges", "build/previews", "build/ConquestSMP-resource-pack.zip", "build/ConquestSMP-resource-pack.sha1", "design/crown", "design/logo/conquest-smp.png")
}
tasks.build { dependsOn(generatePack) }
