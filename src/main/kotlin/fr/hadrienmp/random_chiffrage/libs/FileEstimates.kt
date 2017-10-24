package fr.hadrienmp.random_chiffrage.libs

import fr.hadrienmp.random_chiffrage.domain.ListWrapper
import fr.hadrienmp.random_chiffrage.libs.file.ClassPathURI
import fr.hadrienmp.random_chiffrage.libs.file.File

class FileEstimates: ListWrapper<String> {
    private val file = File(ClassPathURI("estimates.json"))

    override fun all(): List<String> {
        return file.lines()
    }
}

