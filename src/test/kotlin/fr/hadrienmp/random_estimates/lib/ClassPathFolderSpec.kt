package fr.hadrienmp.random_estimates.lib

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ClassPathFolderSpec {

    @Test
    fun `should return the files contained in the folder`() {
        val folder = ClassPathFolder("data")

        val files = folder.files()

        assertThat(files).containsOnly(
                ClassPathFile("data/fr.json"),
                ClassPathFile("data/en.json"))
    }
}