package fr.hadrienmp.random_estimates.lib.web

import io.javalin.Javalin

class WebApp(private val app: Javalin) {
    fun start() {
        app.start()
    }

    fun stop() {
        app.stop()
    }

    fun withRoutes(routes: (Javalin) -> Javalin): WebApp {
        return WebApp(routes(app))
    }

    constructor(port: Port) : this(Javalin.create().port(port.value()))

    fun withStaticFolder(folder: String): WebApp {
        app.enableStaticFiles(folder)
        return this
    }
}