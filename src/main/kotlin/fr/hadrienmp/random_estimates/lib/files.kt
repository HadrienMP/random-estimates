package fr.hadrienmp.random_estimates.lib

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.stream.Collectors.joining

fun classpathFile(path: String): InputStream {
    return ClassLoader.getSystemResourceAsStream(path)
}

class ClassPathFile(val path: String) {
    fun content(): String {
        val inputStream = ClassLoader.getSystemResourceAsStream(path)
                ?: throw IllegalArgumentException("Fichier inexistant $path")
        val reader = BufferedReader(InputStreamReader(inputStream))
        return reader.lines().collect(joining("\n"))
    }
}