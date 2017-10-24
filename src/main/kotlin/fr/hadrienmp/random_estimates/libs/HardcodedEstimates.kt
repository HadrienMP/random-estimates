package fr.hadrienmp.random_estimates.libs

import fr.hadrienmp.random_estimates.domain.ListWrapper

class HardcodedEstimates : ListWrapper<String> {
    private val chiffres = listOf("0", "1/2", "1", "2", "3", "5", "8", "13", "20", "40")

    override fun all(): List<String> {
        return chiffres
    }
}