package fr.hadrienmp.random_estimates.uis.web

import fr.hadrienmp.random_estimates.uis.hipchat.HipchatBot

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

