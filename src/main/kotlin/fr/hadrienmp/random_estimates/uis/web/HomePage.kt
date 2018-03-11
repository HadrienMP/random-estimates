package fr.hadrienmp.random_estimates.uis.web

import fr.hadrienmp.random_estimates.uis.internationalEstimateStore
import io.javalin.Context
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

object HomePage {
    val log: Logger = LoggerFactory.getLogger(HomePage::class.java)
    private val estimates = internationalEstimateStore

    fun display(context: Context) {
        val locale = context.request().locale
        log.info(locale.toString())
        val model = mapOf(Pair("estimate", estimates.get(locale)))
        context.renderThymeleaf("home.html", model)
    }
}
