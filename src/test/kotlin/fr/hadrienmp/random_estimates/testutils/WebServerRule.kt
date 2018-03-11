package fr.hadrienmp.random_estimates.testutils

import com.jcabi.http.request.JdkRequest
import fr.hadrienmp.random_estimates.uis.web.Port
import fr.hadrienmp.random_estimates.uis.web.PortStore
import fr.hadrienmp.random_estimates.webapp
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class WebServerRule : TestRule {

    companion object {
        private val portStore = PortStore()
    }
    private val port = portStore.get()
    private val serverUrl = "http://localhost:${port.value()}"

    fun request() = JdkRequest(serverUrl)

    override fun apply(base: Statement, description: Description?): Statement {
        return DecoratedStatment(base, port)
    }

    class DecoratedStatment(private val base: Statement, private val port: Port) : Statement() {
        private val app = webapp(port)

        override fun evaluate() {
            app.start()
            base.evaluate()
            app.stop()
            portStore.free(port)
        }

    }
}