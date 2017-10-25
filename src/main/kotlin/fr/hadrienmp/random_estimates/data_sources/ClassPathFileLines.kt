package fr.hadrienmp.random_estimates.data_sources

import fr.hadrienmp.random_estimates.estimates.ListWrapper
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import kotlin.streams.toList

class ClassPathFileLines(private val path: String): ListWrapper<String> {
    override fun list(): List<String> {
        val inputStream = ClassLoader.getSystemResourceAsStream(path) ?: throw IllegalArgumentException("Fichier inexistant")
        val reader = BufferedReader(InputStreamReader(inputStream))
        return reader.lines().toList()
    }
}