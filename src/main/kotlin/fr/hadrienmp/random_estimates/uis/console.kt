package fr.hadrienmp.random_estimates.uis

import fr.hadrienmp.random_estimates.estimates.RandomEstimate
import fr.hadrienmp.random_estimates.data_sources.Cache
import fr.hadrienmp.random_estimates.data_sources.FileEstimates
import fr.hadrienmp.random_estimates.data_sources.FileUnits
import java.time.Duration

fun main(args: Array<String>) {

    val estimates = Cache(FileEstimates(), Duration.ofMinutes(1))
    val units = Cache(FileUnits(), Duration.ofMinutes(1))

    (1..20).map { RandomEstimate(estimates, units) }
            .forEach { println(it.toString()) }
}