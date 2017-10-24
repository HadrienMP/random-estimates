package fr.hadrienmp.random_estimates.libs

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import kotlin.streams.toList

class ClassPathFile(private val path: String) {
    fun stream(): InputStream {
        return ClassLoader.getSystemResourceAsStream(path)
    }

    fun lines(): List<String> {
        val reader = BufferedReader(
                InputStreamReader(
                        ClassLoader.getSystemResourceAsStream(path)))
        return reader.lines().toList()
    }
}