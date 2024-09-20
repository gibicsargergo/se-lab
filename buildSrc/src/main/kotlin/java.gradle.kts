package hu.bme.mit.ase.shingler.gradle

plugins {
    java
    jacoco
}

java.toolchain {
    languageVersion.set(JavaLanguageVersion.of(21))
}

tasks {
    test {
        useJUnitPlatform()
        testLogging.showStandardStreams = true
        finalizedBy(jacocoTestReport)
    }

    jacocoTestReport {
        inputs.files(test.get().outputs)
    }
}
