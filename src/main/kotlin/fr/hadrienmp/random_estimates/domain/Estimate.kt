package fr.hadrienmp.random_estimates.domain

import java.lang.Math.abs

class Estimate(private val estimate: Any, private val unit: Any) {
    override fun toString(): String {
        val number = estimate.toString()

        if (number == "0") {
            return "Déjà terminé ! Félicitations"
        }

        val unit = unit.toString() + plural(number)
        return number + " " + unit
    }

    private fun plural(number: String): String {
        return if (isMany(number)) {
            "s"
        } else {
            ""
        }
    }

    private fun isMany(number: String) = isNumber(number) && 1 < abs(number.toInt())

    private fun isNumber(number: String) = Regex("-?\\d+").matches(number)
}