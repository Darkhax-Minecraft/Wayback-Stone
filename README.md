<!-- name-start -->
# WaybackStone [![CurseForge Project](https://img.shields.io/curseforge/dt/1135580?logo=curseforge&label=CurseForge&style=flat-square&labelColor=2D2D2D&color=555555)](https://www.curseforge.com/minecraft/mc-mods/wayback-stone) [![Modrinth Project](https://img.shields.io/modrinth/dt/jnEX3LEk?logo=modrinth&label=Modrinth&style=flat-square&labelColor=2D2D2D&color=555555)](https://modrinth.com/mod/wayback-stone) [![Maven Project](https://img.shields.io/maven-metadata/v?style=flat-square&logoColor=D31A38&labelColor=2D2D2D&color=555555&label=Latest&logo=gradle&metadataUrl=https%3A%2F%2Fmaven.blamejared.com%2Fnet%2Fdarkhax%2Fwaybackstone%2Fwaybackstone-common-26.2%2Fmaven-metadata.xml)](https://maven.blamejared.com/net/darkhax/waybackstone)
<!-- name-end -->

<!-- description-start -->
This is the official GitHub repo for the WaybackStone mod. Adds a powerful charm that allows players to teleport back home! You can download this mod from [CurseForge](https://www.curseforge.com/minecraft/mc-mods/wayback-stone) or [Modrinth](https://modrinth.com/mod/wayback-stone). Please report issues [here](https://github.com/Darkhax-Minecraft/Wayback-Stone/issues).
<!-- description-end -->

<!-- maven-start -->
## Maven Dependency
This project is available on the [BlameJared Maven](https://maven.blamejared.com).

If you are using [Gradle](https://gradle.org) you can add the mod as a dependency by adding the following
to your `build.gradle` file.

```groovy
repositories {
    maven {
        url 'https://maven.blamejared.com'
    }
}

dependencies {
     // NeoForge
     implementation group: 'net.darkhax.waybackstone', name: 'waybackstone-neoforge-26.2', version: '26.2.0.0'
     // Fabric
     implementation group: 'net.darkhax.waybackstone', name: 'waybackstone-fabric-26.2', version: '26.2.0.0'
     // Common / MultiLoader / Vanilla / No Loader
     implementation group: 'net.darkhax.waybackstone', name: 'waybackstone-common-26.2', version: '26.2.0.0'
}
```

<!-- maven-end -->

<!-- sponsor-start -->
## Sponsors
[![](https://assets.blamejared.com/nodecraft/darkhax.jpg)](https://nodecraft.com/r/darkhax)    
WaybackStone is proudly sponsored by Nodecraft! Play your favorite games with your friends using their high
performance game servers! Use code **[DARKHAX](https://nodecraft.com/r/darkhax)** for 30% off your first
month of service!

<!-- sponsor-end -->
