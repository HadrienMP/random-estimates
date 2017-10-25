package fr.hadrienmp.random_estimates.data_sources

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

class ClassPathFileSpec {

    @Test fun `should read the content of a file in the classpath`() {
        val actualLines = ClassPathFile("an_example.txt").lines()
        assertThat(actualLines).containsExactly("Un", "Exemple")
    }

    @Test fun `should throw an exception when reading an inexsting file`() {
        assertThatThrownBy { ClassPathFile("inexisting.txt").lines() }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Fichier inexistant")
    }
}
