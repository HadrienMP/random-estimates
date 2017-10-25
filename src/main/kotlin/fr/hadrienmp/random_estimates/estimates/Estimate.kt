package fr.hadrienmp.random_estimates.estimates

class Estimate(private val estimate: Any, private val unit: Any) {
    override fun toString(): String {
        val number = estimate.toString()

        if (number == "0") {
            return "Déjà terminé ! Félicitations"
        }

        val unit = unit.toString() + suffix(number)
        return number + " " + unit
    }

    private fun suffix(number: String): String {
        return if (Regex("\\d+").matches(number) && number.toInt() > 1) {
            "s"
        } else {
            ""
        }
    }
}