package fr.hadrienmp.random_estimates.domain

import fr.hadrienmp.random_estimates.lib.Cache
import fr.hadrienmp.random_estimates.lib.ClassPathFileLines
import java.time.Duration
import java.util.*

interface Units {
    fun pick(locale: Locale): Conjugable
}

object RandomUnits : Units {
    private val default = RandomPicker(
            Cache(
                    ClassPathFileLines("data/units-fr.txt"),
                    Duration.ofMinutes(5)))

    override fun pick(locale: Locale) = RegularWord(default.pick())
}