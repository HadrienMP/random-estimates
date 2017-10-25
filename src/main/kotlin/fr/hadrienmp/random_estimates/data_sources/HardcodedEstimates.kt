package fr.hadrienmp.random_estimates.data_sources

import fr.hadrienmp.random_estimates.estimates.ListWrapper

class HardcodedEstimates : ListWrapper<String> {
    private val chiffres = listOf("0", "1/2", "1", "2", "3", "5", "8", "13", "20", "40")

    override fun list(): List<String> {
        return chiffres
    }
}