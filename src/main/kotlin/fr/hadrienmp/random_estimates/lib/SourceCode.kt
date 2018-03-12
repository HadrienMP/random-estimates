package fr.hadrienmp.random_estimates.lib

import java.util.jar.JarFile

open class SourceCode {
    private val folder = java.io.File(javaClass.protectionDomain.codeSource.location.path)
    open fun isInJar() = folder.isFile
    open fun jarFilesAndFoldersPaths(): List<String> {
        val jar = JarFile(folder)
        val entries = jar.entries()
        val paths = entries
                .toList()
                .map { it.name }
        jar.close()
        return paths
    }
}