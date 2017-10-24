package fr.hadrienmp.random_chiffrage.libs

import fr.hadrienmp.random_chiffrage.domain.ListWrapper

class HardcodedUnits : ListWrapper<String> {
    private val units = listOf("Semaine", "Dauphin", "Jour", "Année", "Kilomètre", "Kilogramme", "T-shirt")

    override fun all(): List<String> {
        return units
    }
}