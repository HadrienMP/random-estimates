package fr.hadrienmp.random_estimates.lib

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class LanguageFilesPathSpec {
    @Test
    fun `should find the files in the resource folder`() {
        val files = languageFilePaths()
        val filenames = files.map { it.name }
        assertThat(filenames).contains("en.json", "fr.json")
    }
}