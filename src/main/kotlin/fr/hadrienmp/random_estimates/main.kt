package fr.hadrienmp.random_estimates

import fr.hadrienmp.random_estimates.uis.hipchat.HipchatBot
import fr.hadrienmp.random_estimates.uis.web.HomePage
import fr.hadrienmp.random_estimates.uis.web.Port
import fr.hadrienmp.random_estimates.uis.web.ThymeleafTemplates
import fr.hadrienmp.random_estimates.uis.web.WebApp

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

