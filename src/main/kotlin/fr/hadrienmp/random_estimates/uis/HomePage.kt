package fr.hadrienmp.random_estimates.uis

import fr.hadrienmp.random_estimates.domain.Estimates
import io.javalin.Context

object HomePage {
    private val estimates = Estimates()

    fun display(context: Context) {
        val model = mapOf(Pair("estimate", estimates.get()))
        context.renderThymeleaf("home.html", model)
    }
}