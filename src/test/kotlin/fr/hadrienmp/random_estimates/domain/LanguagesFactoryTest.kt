package fr.hadrienmp.random_estimates.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.io.File
import java.util.Locale.ENGLISH
import java.util.Locale.FRENCH

class LanguagesFactoryTest {

    @Test
    fun `should not return any language for an empty file list`() {
        val languageFilePaths = listOf<File>()
        val languages = languages(languageFilePaths)
        assertThat(languages).isEmpty()
    }

    @Test
    fun `should return a language when all it's files are present`() {
        val languageFilePaths = listOf(
                File("/data/measures.txt"),
                File("/data/units-en.txt"),
                File("/data/phrases-en.txt"),
                File("/data/units-fr.txt"),
                File("/data/phrases-fr.txt")
        )
        val languages = languages(languageFilePaths)
        assertThat(languages).containsOnly(ENGLISH, FRENCH)
    }

    @Test
    fun `should not return a language when the measures file is missing`() {
        val languageFilePaths = listOf(
                File("/data/units-en.txt"),
                File("/data/phrases-en.txt")
        )
        val languages = languages(languageFilePaths)
        assertThat(languages).isEmpty()
    }

    @Test
    fun `should not return a language when its units file is missing`() {
        val languageFilePaths = listOf(
                File("/data/measures.txt"),
                File("/data/phrases-en.txt")
        )
        val languages = languages(languageFilePaths)
        assertThat(languages).isEmpty()
    }

    @Test
    fun `should not return a language when it's phrases file is missing`() {
        val languageFilePaths = listOf(
                File("/data/measures.txt"),
                File("/data/units-en.txt")
        )
        val languages = languages(languageFilePaths)
        assertThat(languages).isEmpty()
    }

}

