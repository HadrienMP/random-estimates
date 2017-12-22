package fr.hadrienmp.random_estimates.domain

import fr.hadrienmp.random_estimates.lib.Cache
import fr.hadrienmp.random_estimates.lib.ClassPathFileLines
import fr.hadrienmp.random_estimates.lib.Random
import java.time.Duration

class RandomEstimatesBot {
    private val phrases = Cache(ClassPathFileLines("data/phrases.txt"), Duration.ofMinutes(5))
    private val estimates = Estimates()

    fun response(): String {
        return Random(phrases).value().format(estimates.random())
    }
}