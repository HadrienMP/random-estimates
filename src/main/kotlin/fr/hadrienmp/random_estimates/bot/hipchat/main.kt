package fr.hadrienmp.random_estimates.bot.hipchat

import fr.hadrienmp.random_estimates.domain.Estimate
import fr.hadrienmp.random_estimates.domain.Random
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

        val estimates = Cache(ClassPathFileLines("estimates.txt"), Duration.ofMinutes(5))
        val units = Cache(ClassPathFileLines("units.txt"), Duration.ofMinutes(5))
        val phrases = Cache(ClassPathFileLines("phrases.txt"), Duration.ofMinutes(5))

        it.post("/") {
            val estimate = Estimate(Random(estimates), Random(units))
            val message = Random(phrases).value().format(estimate)
            val response = HipChatResponse(message)

            it.result(response.toString())
        }
    }
}

