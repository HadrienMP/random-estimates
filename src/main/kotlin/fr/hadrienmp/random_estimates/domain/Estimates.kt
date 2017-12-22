package fr.hadrienmp.random_estimates.domain

import fr.hadrienmp.random_estimates.lib.Cache
import fr.hadrienmp.random_estimates.lib.ClassPathFileLines
import fr.hadrienmp.random_estimates.lib.Random
import java.time.Duration

class Estimates {
    private val estimates = Cache(ClassPathFileLines("data/estimates.txt"), Duration.ofMinutes(5))
    private val units = Cache(ClassPathFileLines("data/units.txt"), Duration.ofMinutes(5))

    fun random(): Estimate = Estimate(Random(estimates), Random(units))
}