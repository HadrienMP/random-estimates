package fr.hadrienmp.random_estimates.uis

import fr.hadrienmp.random_estimates.domain.RandomEstimate
import fr.hadrienmp.random_estimates.libs.FileEstimates
import fr.hadrienmp.random_estimates.libs.FileUnits

fun main(args: Array<String>) {

    val estimates = FileEstimates()
    val units = FileUnits()

    (1..20).map { RandomEstimate(estimates, units) }
            .forEach { println(it.toString()) }
}
