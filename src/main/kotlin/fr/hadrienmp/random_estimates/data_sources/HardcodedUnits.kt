package fr.hadrienmp.random_estimates.data_sources

import fr.hadrienmp.random_estimates.estimates.ListWrapper

class HardcodedUnits : ListWrapper<String> {
    private val units = listOf("Semaine", "Dauphin", "Jour", "Année", "Kilomètre", "Kilogramme", "T-shirt")

    override fun list(): List<String> {
        return units
    }
}