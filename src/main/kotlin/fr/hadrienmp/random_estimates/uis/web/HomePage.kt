package fr.hadrienmp.random_estimates.uis.web

import fr.hadrienmp.random_estimates.uis.internationalEstimateStore
import io.javalin.Context

object HomePage {
    private val estimates = internationalEstimateStore

    fun display(context: Context) {
        val locale = context.request().locale
        val model = mapOf(Pair("estimate", estimates.get(locale)))
        context.renderThymeleaf("home.html", model)
    }
}
