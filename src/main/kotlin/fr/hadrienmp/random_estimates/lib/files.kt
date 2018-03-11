package fr.hadrienmp.random_estimates.lib

import java.io.File

fun classpathFile(path: String): File {
    val uri = ClassLoader
            .getSystemResource(path)
            .toURI()
    return File(uri)
}