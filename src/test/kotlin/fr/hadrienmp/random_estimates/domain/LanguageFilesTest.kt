package fr.hadrienmp.random_estimates.domain

import org.assertj.core.api.SoftAssertions
import org.junit.Test

class LanguageFilesTest {

    @Test fun `should detect the language files from the resources directories`() {
        // GIVEN
        val expectedFilesForm = Regex(".*data/\\w+(-\\w+)?\\.txt").pattern

        // WHEN
        val languageFilePaths = languageFilePaths()

        // THEN
        val softly = SoftAssertions()
        languageFilePaths
                .map { it.path }
                .forEach { softly.assertThat(it).matches(expectedFilesForm) }
        softly.assertAll()
    }
}

// Estimates(RandPick(
// Language
//      - Measures
//      - Units
//      - Phrases


// pick(language,mesure)
// pick(language,units)
// pick(language,phrases)
// phrase(template, estimate(mesure, unit))