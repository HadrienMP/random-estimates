package fr.hadrienmp.random_estimates.uis

import fr.hadrienmp.random_estimates.domain.RandomEstimate
import fr.hadrienmp.random_estimates.libs.Cache
import fr.hadrienmp.random_estimates.libs.FileEstimates
import fr.hadrienmp.random_estimates.libs.FileUnits
import io.javalin.Javalin
import java.time.Duration

fun main(args: Array<String>) {
    val app = Javalin.start(Port(args).value())

    val estimates = FileEstimates()
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

class Port(private val args: Array<String>) {
    private val argumentRegex = Regex("port=\\d+")

    fun value(): Int {
        val port = args.toList()
                .filter { it.matches(argumentRegex) }
                .map { it.split("=").last().toInt() }
                .firstOrNull()
        return port ?: 8080
    }
}