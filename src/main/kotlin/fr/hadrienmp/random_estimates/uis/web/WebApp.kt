package fr.hadrienmp.random_estimates.uis.web

import fr.hadrienmp.random_estimates.data_sources.Cache
import fr.hadrienmp.random_estimates.data_sources.ClassPathFileLines
import fr.hadrienmp.random_estimates.estimates.Estimate
import fr.hadrienmp.random_estimates.estimates.Random
import io.javalin.Javalin
import java.time.Duration

class WebApp(port: Port) {
    private val app = Javalin.start(port.value())

    init {
        val estimates = Cache(ClassPathFileLines("estimates.txt"), Duration.ofMinutes(5))
        val units = Cache(ClassPathFileLines("units.txt"), Duration.ofMinutes(5))
        val phrases = Cache(ClassPathFileLines("phrases.txt"), Duration.ofMinutes(5))

        app.post("/") {
            val estimate = Estimate(Random(estimates), Random(units))
            val phrase = Random(phrases)
            val message = phrase.value().format(estimate)
            val response = HipChatResponse(message)

            it.result(response.toString())
        }
    }

    fun stop() {
        app.stop()
    }
}