package fr.hadrienmp.random_estimates.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class WordSpec {
    @Test
    fun `should return it's singular form when the amount is 1`() {
        val word = Word("hibou", "hiboux")
        val conjugated = word.conjugate("1")
        assertThat(conjugated).isEqualTo("hibou")
    }

    @Test
    fun `should return it's singular form when the amount is not an int`() {
        val word = Word("hibou", "hiboux")
        val conjugated = word.conjugate("2.4")
        assertThat(conjugated).isEqualTo("hibou")
    }

    @Test
    fun `should return it's singular form when the amount is not a number`() {
        val word = Word("hibou", "hiboux")
        val conjugated = word.conjugate("toto")
        assertThat(conjugated).isEqualTo("hibou")
    }

    @Test
    fun `should return it's plural form when the amount is less than -1`() {
        val word = Word("hibou", "hiboux")
        val conjugated = word.conjugate("-2")
        assertThat(conjugated).isEqualTo("hiboux")
    }

    @Test
    fun `should return it's plural form when the amount is more than 1`() {
        val word = Word("hibou", "hiboux")
        val conjugated = word.conjugate("2")
        assertThat(conjugated).isEqualTo("hiboux")
    }
}