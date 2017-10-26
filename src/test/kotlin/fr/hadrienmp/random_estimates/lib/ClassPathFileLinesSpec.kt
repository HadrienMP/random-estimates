package fr.hadrienmp.random_estimates.lib

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

class ClassPathFileLinesSpec {

    @Test fun `should read the content of a file in the classpath`() {
        val actualLines = ClassPathFileLines("an_example.txt").get()
        assertThat(actualLines).containsExactly("Un", "Exemple")
    }

    @Test fun `should throw an exception when reading an inexsting file`() {
        assertThatThrownBy { ClassPathFileLines("inexisting.txt").get() }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Fichier inexistant")
    }
}
