package fr.hadrienmp.random_estimates.lib

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class LanguageFilesPathSpec {
    @Test
    fun `should find the files in the resource folder`() {
        val files = languageFiles()
        val filenames = files.map { it.path }
        assertThat(filenames).contains("data/en.json", "data/fr.json")
    }
}