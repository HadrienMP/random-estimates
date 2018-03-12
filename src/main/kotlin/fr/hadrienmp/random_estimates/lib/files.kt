package fr.hadrienmp.random_estimates.lib

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.streams.toList
import java.util.jar.JarFile


interface File {
    fun path(): String
    fun content(): String
    fun lines(): List<String>
}

data class ClassPathFile(private val path: String) : File {
    private val lines: List<String>

    init {
        val inputStream = ClassLoader.getSystemResourceAsStream(path)
                ?: throw IllegalArgumentException("Fichier inexistant $path")
        val reader = BufferedReader(InputStreamReader(inputStream))
        lines = reader.lines().toList()
    }

    override fun path() = path
    override fun content() = lines.joinToString("\n")
    override fun lines() = lines
}