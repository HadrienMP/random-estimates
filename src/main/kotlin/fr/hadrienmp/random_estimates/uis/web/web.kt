package fr.hadrienmp.random_estimates.uis.web

import fr.hadrienmp.random_estimates.estimates.RandomEstimate
import fr.hadrienmp.random_estimates.data_sources.Cache
import fr.hadrienmp.random_estimates.data_sources.FileEstimates
import fr.hadrienmp.random_estimates.data_sources.FileUnits
import io.javalin.Javalin
import java.time.Duration

fun main(args: Array<String>) {
    val app = Javalin.start(Port(args).value())

    val estimates = Cache(FileEstimates(), Duration.ofMinutes(5))
    val units = Cache(FileUnits(), Duration.ofMinutes(5))

    app.post("/") {
        val estimate = RandomEstimate(estimates, units)
        it.result("""{
            "color": "green",
            "message": "Mes calculs scientifiques prouvent que votre demande prendra $estimate",
            "notify": false,
            "message_format": "text"
        }""")
    }
    app.get("/") {
        it.result("I'm up")
    }
}

