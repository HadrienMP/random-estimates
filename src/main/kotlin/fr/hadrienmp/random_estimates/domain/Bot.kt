package fr.hadrienmp.random_estimates.domain

import java.util.*

class Bot(private val phrases: Phrases = RandomPhrases,
          private val units: Units = RandomUnits,
          private val measures: Measures = RandomMeasures) {

    fun response(locale: Locale = Locale.FRANCE): String {
        val amount = measures.pick()
        val unit = units.pick(locale)
        val estimate = amount + " " + unit.conjugate(amount)
        return phrases.pick(locale).format(estimate)
    }
}

