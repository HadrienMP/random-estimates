package fr.hadrienmp.random_estimates.lib.web

import io.javalin.Javalin

class WebApp(private val app: Javalin) {

    fun start() {
        app.start()
    }

    fun stop() {
        app.stop()
    }

    fun routes(addRoutes: (Javalin) -> Javalin): WebApp {
        return WebApp(addRoutes(app))
    }

    constructor(port: Port) : this(Javalin.create().port(port.value()))
}