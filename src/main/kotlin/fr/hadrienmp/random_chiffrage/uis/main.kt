package fr.hadrienmp.random_chiffrage.uis

import fr.hadrienmp.random_chiffrage.domain.RandomEstimate
import fr.hadrienmp.random_chiffrage.libs.FileEstimates
import fr.hadrienmp.random_chiffrage.libs.FileUnits

fun main(args: Array<String>) {

    val estimates = FileEstimates()
    val units = FileUnits()

    (1..20).map { RandomEstimate(estimates, units) }
            .forEach { println(it.toString()) }
}
