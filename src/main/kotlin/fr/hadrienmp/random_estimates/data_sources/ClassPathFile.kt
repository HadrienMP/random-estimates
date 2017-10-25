package fr.hadrienmp.random_estimates.data_sources

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import kotlin.streams.toList

class ClassPathFile(private val path: String) {
    fun lines(): List<String> {
        val inputStream = ClassLoader.getSystemResourceAsStream(path) ?: throw IllegalArgumentException("Fichier inexistant")
        val reader = BufferedReader(InputStreamReader(inputStream))
        return reader.lines().toList()
    }
}