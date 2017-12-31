package fr.hadrienmp.random_estimates.domain

import fr.hadrienmp.random_estimates.lib.Cache
import fr.hadrienmp.random_estimates.lib.ClassPathFileLines
import java.time.Duration
import java.util.*

interface Phrases {
    fun pick(locale: Locale): String
}

object RandomPhrases : Phrases {
    private val default = RandomPicker(
            Cache(
                    ClassPathFileLines("data/phrases-fr.txt"),
                    Duration.ofMinutes(5)))

    override fun pick(locale: Locale) = default.pick()
}