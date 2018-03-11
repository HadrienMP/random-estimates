package fr.hadrienmp.random_estimates.uis.web

import fr.hadrienmp.random_estimates.uis.internationalEstimateStore
import io.javalin.Context
import java.util.*

object HomePage {
    private val estimates = internationalEstimateStore()

    fun display(context: Context) {
        val model = mapOf(Pair("estimate", estimates.get(Locale.FRENCH)))
        context.renderThymeleaf("home.html", model)
    }
}
