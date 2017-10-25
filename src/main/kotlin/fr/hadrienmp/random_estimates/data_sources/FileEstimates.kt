package fr.hadrienmp.random_estimates.data_sources

import fr.hadrienmp.random_estimates.estimates.ListWrapper

class FileEstimates: ListWrapper<String> {
    private val file = ClassPathFile("estimates.txt")

    override fun list(): List<String> {
        return file.lines()
    }
}

