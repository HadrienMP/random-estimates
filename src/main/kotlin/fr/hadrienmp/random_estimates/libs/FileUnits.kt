package fr.hadrienmp.random_estimates.libs

import fr.hadrienmp.random_estimates.domain.ListWrapper

class FileUnits: ListWrapper<String> {
    private val file = ClassPathFile("units.txt")

    override fun all(): List<String> {
        return file.lines()
    }
}