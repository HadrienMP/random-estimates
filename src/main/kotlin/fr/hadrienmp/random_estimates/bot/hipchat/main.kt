package fr.hadrienmp.random_estimates.bot.hipchat

import fr.hadrienmp.random_estimates.domain.Estimate
import fr.hadrienmp.random_estimates.lib.Random
import fr.hadrienmp.random_estimates.lib.Cache
import fr.hadrienmp.random_estimates.lib.ClassPathFileLines
import fr.hadrienmp.random_estimates.lib.web.Port
import fr.hadrienmp.random_estimates.lib.web.WebApp
import java.time.Duration

fun main(args: Array<String>) {
    webapp(Port(args)).start()
}

fun webapp(port: Port): WebApp {
    return WebApp(port).routes {

        val randomEstimates = RandomEstimates()

        it.post("/") {
            val rawResponse = randomEstimates.response()
            val response = HipChatResponse(rawResponse)
            it.result(response.toString())
        }
    }
}

interface Bot {
    fun response(): String
}

class RandomEstimates: Bot {
    private val estimates = Cache(ClassPathFileLines("estimates.txt"), Duration.ofMinutes(5))
    private val units = Cache(ClassPathFileLines("units.txt"), Duration.ofMinutes(5))
    private val phrases = Cache(ClassPathFileLines("phrases.txt"), Duration.ofMinutes(5))

    override fun response(): String {
        val estimate = Estimate(Random(estimates), Random(units))
        return Random(phrases).value().format(estimate)
    }
}

