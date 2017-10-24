package fr.hadrienmp.random_chiffrage.domain

class RandomEstimate(estimates: ListWrapper<String>, units: ListWrapper<String>) {
    private val estimate = Estimate(
            Random(estimates),
            Random(units))

    override fun toString(): String {
        return estimate.toString()
    }
}