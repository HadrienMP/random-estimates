package fr.hadrienmp.random_estimates.libs

import fr.hadrienmp.random_estimates.domain.ListWrapper
import fr.hadrienmp.random_estimates.libs.file.ClassPathURI
import fr.hadrienmp.random_estimates.libs.file.File

class FileUnits: ListWrapper<String> {
    private val file = File(ClassPathURI("units.json"))

    override fun all(): List<String> {
        return file.lines()
    }
}