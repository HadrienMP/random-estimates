package fr.hadrienmp.random_estimates.libs

import fr.hadrienmp.random_estimates.domain.ListWrapper

class HardcodedUnits : ListWrapper<String> {
    private val units = listOf("Semaine", "Dauphin", "Jour", "Année", "Kilomètre", "Kilogramme", "T-shirt")

    override fun all(): List<String> {
        return units
    }
}