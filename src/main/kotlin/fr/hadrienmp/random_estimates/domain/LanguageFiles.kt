package fr.hadrienmp.random_estimates.domain

import java.io.File
import java.lang.Thread.*

fun languageFilePaths(): List<File> {
    val languageFilesDirectoryName = "data"
    val languageFilesDirectoryPath = currentThread()
            .contextClassLoader
            .getResource(languageFilesDirectoryName)
            .path
    return File(languageFilesDirectoryPath)
            .listFiles()
            .toList()
}