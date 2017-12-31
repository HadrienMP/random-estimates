package fr.hadrienmp.random_estimates.domain

import java.util.*

class Estimates(private val phrases: Phrases = RandomPhrases,
                private val units: Units = RandomUnits,
                private val measures: Measures = RandomMeasures) {

    fun get(locale: Locale = Locale.FRANCE): String = phrase(estimate(locale), locale)

    private fun estimate(locale: Locale): String {
        val amount = measures.pick()
        val unit = units.pick(locale)
        return amount + " " + unit.conjugate(amount)
    }

    private fun phrase(estimate: String, locale: Locale) = phrases.pick(locale).format(estimate)
}

