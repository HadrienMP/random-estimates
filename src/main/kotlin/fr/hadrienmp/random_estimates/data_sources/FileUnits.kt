package fr.hadrienmp.random_estimates.data_sources

import fr.hadrienmp.random_estimates.estimates.ListWrapper

class FileUnits: ListWrapper<String> {
    private val file = ClassPathFileLines("units.txt")

    override fun list(): List<String> {
        return file.list()
    }
}