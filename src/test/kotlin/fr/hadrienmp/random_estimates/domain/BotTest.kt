package fr.hadrienmp.random_estimates.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.*
import java.util.*

class BotTest {
    private val units = mock(Units::class.java)
    private val measures = mock(Measures::class.java)
    private val phrases = mock(Phrases::class.java)
    private val bot = Bot(phrases, units, measures)

    @Before
    fun setUp() {
        givenPhrase("It will take %s probably")
        givenMeasure("3")
        givenUnit(RegularWord("Day"))
    }

    @Test fun `should conjugate phrases, measures and units for a phrased estimate`() {
        givenPhrase("It will take %s probably")
        givenMeasure("3")
        givenUnit(RegularWord("Day"))

        val response = bot.response()

        assertThat(response).isEqualTo("It will take 3 Days probably")
    }

    @Test fun `should pick units and phrases in the requested language`() {
        bot.response(Locale.ENGLISH)
        verify(units).pick(Locale.ENGLISH)
        verify(phrases).pick(Locale.ENGLISH)
    }

    @Test fun `by default french should be the language`() {
        bot.response()
        verify(units).pick(Locale.FRANCE)
        verify(phrases).pick(Locale.FRANCE)
    }

    private fun givenUnit(unit: Conjugable) {
        `when`(units.pick(any())).thenReturn(unit)
    }

    private fun givenMeasure(measure: String) {
        `when`(measures.pick()).thenReturn(measure)
    }

    private fun givenPhrase(phrase: String) {
        `when`(phrases.pick(any())).thenReturn(phrase)
    }
    private fun <T> any(): T {
        Mockito.any<T>()
        return uninitialized()
    }

    private fun <T> uninitialized(): T = null as T
}