package fr.hadrienmp.random_estimates.domain

import fr.hadrienmp.random_estimates.lib.Cache
import fr.hadrienmp.random_estimates.lib.ClassPathFileLines
import fr.hadrienmp.random_estimates.lib.Random
import java.time.Duration

class Interpret {
    private val phrases = Cache(ClassPathFileLines("data/phrases.txt"), Duration.ofMinutes(5))

    fun phrase(estimate: Estimate) = Random(phrases).value().format(estimate)
}