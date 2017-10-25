package fr.hadrienmp.random_estimates.uis

import fr.hadrienmp.random_estimates.estimates.ListWrapper
import fr.hadrienmp.random_estimates.estimates.Random

class Bot(private val phrases: ListWrapper<String>) {
    fun messageFor(estimate: Any): String {
        val template = Random(phrases)
        return template.value().format(estimate)
    }
}