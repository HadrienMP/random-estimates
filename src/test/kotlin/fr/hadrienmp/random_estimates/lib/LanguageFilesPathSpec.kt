package fr.hadrienmp.random_estimates.lib

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class LanguageFilesPathSpec {
    @Test
    fun `should find the files in the resource folder`() {
        val files = languageFiles()
        val filePaths = files.map { it.path() }
        assertThat(filePaths).allMatch { it.matches(Regex(".*data/\\w+.json")) }
    }
}