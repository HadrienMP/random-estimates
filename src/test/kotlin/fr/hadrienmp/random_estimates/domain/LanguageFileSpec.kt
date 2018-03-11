package fr.hadrienmp.random_estimates.domain

import fr.hadrienmp.random_estimates.lib.ClassPathFile
import fr.hadrienmp.random_estimates.lib.LanguageFile
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import java.io.Serializable
import java.util.*

@RunWith(JUnitParamsRunner::class)
class LanguageFileSpec {
    @Test
    @Parameters(method = "validFileName")
    fun `should detect the language from the file name`(fileName: String, expectedLocale: Locale) {
        val jsonLanguage = LanguageFile(ClassPathFile(fileName))
        val locale = jsonLanguage.locale
        assertThat(locale).isEqualTo(expectedLocale)
    }

    fun validFileName(): Iterable<Iterable<Serializable>> {
        return listOf(
                listOf("empty/ja.json", Locale.JAPANESE),
                listOf("empty/en.json", Locale.ENGLISH)
        )
    }

    @Test(expected = IllegalArgumentException::class)
    fun `should not create files that do not contain the locale at the expected location`() {
        LanguageFile(ClassPathFile("broken/1234.json"))
    }

    @Test(expected = IllegalArgumentException::class)
    fun `should not create non json files`() {
        LanguageFile(ClassPathFile("broken/fa.txt"))
    }

    @Test(expected = IllegalArgumentException::class)
    fun `should not create non existing files`() {
        LanguageFile(ClassPathFile("non-existent/fr.json"))
    }

    @Test
    fun `should return it's content`() {
        val languageFile = LanguageFile(ClassPathFile("empty/en.json"))
        val content = languageFile.content
        assertThat(content).isEqualTo("{ \"measures\": [] }")
    }
}
