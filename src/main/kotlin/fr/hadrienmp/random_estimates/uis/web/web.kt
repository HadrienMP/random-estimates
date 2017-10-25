package fr.hadrienmp.random_estimates.uis.web

import fr.hadrienmp.random_estimates.estimates.RandomEstimate
import fr.hadrienmp.random_estimates.data_sources.Cache
import fr.hadrienmp.random_estimates.data_sources.ClassPathFileLines
import fr.hadrienmp.random_estimates.data_sources.FileEstimates
import fr.hadrienmp.random_estimates.data_sources.FileUnits
import fr.hadrienmp.random_estimates.uis.Bot
import io.javalin.Javalin
import java.time.Duration

fun main(args: Array<String>) {
    val app = Javalin.start(Port(args).value())

    val estimates = Cache(FileEstimates(), Duration.ofMinutes(5))
    val units = Cache(FileUnits(), Duration.ofMinutes(5))
    val phrases = Cache(ClassPathFileLines("phrases.txt"), Duration.ofMinutes(5))
    val bot = Bot(phrases)

    app.post("/") {

        val estimate = RandomEstimate(estimates, units)
        val message = bot.messageFor(estimate)

        it.result("""{
            "color": "green",
            "message": $message,
            "notify": false,
            "message_format": "text"
        }""")
    }
    app.get("/") {
        it.result("I'm up")
    }
}

