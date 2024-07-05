plugins {
    id("java")
    id("maven-publish")
}

group = "dev.thorinwasher"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("dev.thorinwasher:json-junit-params:1.0-SNAPSHOT")
    implementation("net.minestom:minestom-snapshots:0129aedae3")
    implementation("dev.hollowcube:schem:1.1.0")
}

tasks {
    compileJava {
        options.release.set(21)
        options.encoding = Charsets.UTF_8.name()
    }

    test {
        useJUnitPlatform()
    }

    publishToMavenLocal {
        doLast {
            println("Published to Maven local with version $version")
        }
    }
}



publishing {
    publications {
        create<MavenPublication>(name) {
            groupId = group.toString()
            artifactId = name
            version = version.toString()

            from(components["java"])
        }
    }

    repositories{
        mavenCentral()
    }
}

