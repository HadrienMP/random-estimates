package fr.hadrienmp.random_estimates.domain

import fr.hadrienmp.random_estimates.lib.Cache
import fr.hadrienmp.random_estimates.lib.ClassPathFileLines
import java.time.Duration

interface Measures {
    fun pick(): String
}

object RandomMeasures : Measures {
    private val measures = RandomPicker(
            Cache(
                    ClassPathFileLines("data/measures.txt"),
                    Duration.ofMinutes(5)))

    override fun pick(): String = measures.pick()
}