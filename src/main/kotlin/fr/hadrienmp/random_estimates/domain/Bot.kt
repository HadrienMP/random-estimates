package fr.hadrienmp.random_estimates.domain

import fr.hadrienmp.random_estimates.lib.Cache
import fr.hadrienmp.random_estimates.lib.ClassPathFileLines
import fr.hadrienmp.random_estimates.lib.Random
import java.time.Duration
import java.util.*

class Bot {
    val estimates = Cache(ClassPathFileLines("data/estimates.txt"), Duration.ofMinutes(5))
    val units = Cache(ClassPathFileLines("data/units.txt"), Duration.ofMinutes(5))
    val phrases = Cache(ClassPathFileLines("data/phrases.txt"), Duration.ofMinutes(5))

    fun response(locale: Locale = Locale.FRANCE): String {
        val estimate = estimate()
        return phrase(estimate)
    }

    private fun phrase(estimate: Estimate) = Random(phrases).value().format(estimate)
    private fun estimate() = Estimate(Random(estimates), Random(units))

}

