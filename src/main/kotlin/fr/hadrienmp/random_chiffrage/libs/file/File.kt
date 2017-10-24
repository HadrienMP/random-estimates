package fr.hadrienmp.random_chiffrage.libs.file

import java.nio.file.Paths

class File(private val uri: ClassPathURI) {
    fun lines(): List<String> {
        return Paths.get(uri.uri()).toFile().readLines()
    }
}