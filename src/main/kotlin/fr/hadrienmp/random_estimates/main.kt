package fr.hadrienmp.random_estimates

import fr.hadrienmp.random_estimates.lib.web.Port
import fr.hadrienmp.random_estimates.lib.web.ThymeleafTemplates
import fr.hadrienmp.random_estimates.lib.web.WebApp
import fr.hadrienmp.random_estimates.uis.HipchatBot
import fr.hadrienmp.random_estimates.uis.HomePage

fun main(args: Array<String>) {
    webapp(Port(args)).start()
}

fun webapp(port: Port): WebApp {

    ThymeleafTemplates("webapp/").enable()

    return WebApp(port).withRoutes {
        it.get("/", HomePage::display)
        it.post("/", HipchatBot::estimate)
    }.withStaticFolder("/webapp")
}

