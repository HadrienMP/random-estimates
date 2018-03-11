package fr.hadrienmp.random_estimates.domain

import fr.hadrienmp.random_estimates.lib.ClassPathFile
import fr.hadrienmp.random_estimates.lib.JsonLanguage
import fr.hadrienmp.random_estimates.lib.LanguageFile
import fr.hadrienmp.random_estimates.lib.classpathFile
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class JsonLanguageSpec {
    @Test
    fun `should provide measures`() {
        val languageFile = LanguageFile(ClassPathFile("fake/fr.json"))
        val language = JsonLanguage(languageFile.content)

        val measures = language.measures()

        assertThat(measures).containsOnly("1/2", "1", "2")
    }
    @Test
    fun `should provide units`() {
        val languageFile = LanguageFile(ClassPathFile("fake/fr.json"))
        val language = JsonLanguage(languageFile.content)

        val units = language.units()

        assertThat(units).containsOnly(RegularWord("jour"), RegularWord("heure"), RegularWord("année"))
    }
    @Test
    fun `should provide phrases`() {
        val languageFile = LanguageFile(ClassPathFile("fake/fr.json"))
        val language = JsonLanguage(languageFile.content)

        val phrases = language.phrases()

        assertThat(phrases).containsOnly("Une", "Phrase", "Encore")
    }

    @Test
    fun `the measures should be empty for an empty json`() {
        val languageFile = LanguageFile(ClassPathFile("empty/en.json"))
        val language = JsonLanguage(languageFile.content)

        val measures = language.measures()

        assertThat(measures).isEmpty()
    }

    @Test
    fun `the measures should be empty for an empty string`() {
        val language = JsonLanguage("")
        val measures = language.measures()
        assertThat(measures).isEmpty()
    }
}