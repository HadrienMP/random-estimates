package fr.hadrienmp.random_estimates.libs.file

import java.net.URI

class ClassPathURI(private val path: String) {
    fun uri(): URI {
        return ClassLoader.getSystemResource(path).toURI()
    }
}