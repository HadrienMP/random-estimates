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

data class ClassPathFolder(private val path: String) {
    fun files() = when {
        isJar() -> filesFromJar()
        else -> filesFromClassPath()
    }

    private fun isJar() = sourceCodeFolder().isFile

    private fun filesFromJar(): List<File> {
        val jar = JarFile(sourceCodeFolder())
        val files = jar.entries()
                .toList()
                .filter { it.name.startsWith("$path/") }
                .filter { it.name.endsWith(".json") }
                .map { it.name }
                .map { ClassPathFile(it) }
        jar.close()
        return files
    }

    private fun filesFromClassPath() = ClassPathFile(path).lines().map { "$path/$it" }.map { ClassPathFile(it) }

    private fun sourceCodeFolder() = java.io.File(javaClass.protectionDomain.codeSource.location.path)
}