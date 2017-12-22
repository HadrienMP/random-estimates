package fr.hadrienmp.random_estimates.domain

class Bot {
    private val estimates = Estimates()
    private val interpret = Interpret()

    fun response(): String = interpret.phrase(estimates.random())

}

