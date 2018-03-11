package fr.hadrienmp.random_estimates.domain

import fr.hadrienmp.random_estimates.lib.LanguageFile
import fr.hadrienmp.random_estimates.lib.classpathFile
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import java.io.File
import java.io.Serializable
import java.util.*

@RunWith(JUnitParamsRunner::class)
class LanguageFileSpec {
    @Test
    @Parameters(method = "validFileName")
    fun `should detect the language from the file name`(fileName: String, expectedLocale: Locale) {
        val jsonLanguage = LanguageFile(classpathFile(fileName))
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
        LanguageFile(classpathFile("broken/1234.json"))
    }

    @Test(expected = IllegalArgumentException::class)
    fun `should not create non json files`() {
        LanguageFile(classpathFile("broken/fa.txt"))
    }

    @Test(expected = IllegalArgumentException::class)
    fun `should not create non existing files`() {
        LanguageFile(File("non-existent/fr.json"))
    }

    @Test
    fun `should return it's content`() {
        val languageFile = LanguageFile(classpathFile("empty/en.json"))
        val content = languageFile.content()
        assertThat(content).isEqualTo("{ \"measures\": [] }")
    }
}
