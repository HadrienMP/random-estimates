package fr.hadrienmp.random_estimates.uis

import fr.hadrienmp.random_estimates.domain.Bot
import io.javalin.Context

object HomePage {
    private val bot = Bot()

    fun display(context: Context) {
        val model = mapOf(Pair("estimate", bot.response()))
        context.renderThymeleaf("home.html", model)
    }
}