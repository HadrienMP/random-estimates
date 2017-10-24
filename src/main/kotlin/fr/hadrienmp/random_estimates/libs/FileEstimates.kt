package fr.hadrienmp.random_estimates.libs

import fr.hadrienmp.random_estimates.domain.ListWrapper

class FileEstimates: ListWrapper<String> {
    private val file = ClassPathFile("estimates.txt")

    override fun all(): List<String> {
        return file.lines()
    }
}

