package fr.hadrienmp.random_estimates.domain

interface Conjugable {
    fun conjugate(amount: String): String
}

class RegularWord(singular: String): Conjugable by Word(singular, singular + "s")

class Word(private val singular: String, private val plural: String) : Conjugable {
    override fun conjugate(amount: String): String {
        return if (isMany(amount)) {
            plural
        } else {
            singular
        }
    }

    private fun isMany(number: String) = isNumber(number) && 1 < Math.abs(number.toInt())

    private fun isNumber(number: String) = Regex("-?\\d+").matches(number)
}