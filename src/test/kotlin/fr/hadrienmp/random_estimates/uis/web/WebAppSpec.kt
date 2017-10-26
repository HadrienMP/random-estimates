package fr.hadrienmp.random_estimates.uis.web

import com.jcabi.http.Request
import com.jcabi.http.request.JdkRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Test

class WebAppSpec {
    companion object {
        private val portStore = PortStore()
    }
    private val port = portStore.get()
    private val app = WebApp(port)
    private val serverUrl = "http://localhost:${port.value()}"

    @Test fun `should respond to post requests with a hipchat response`() {
        val response = JdkRequest(serverUrl)
                .method(Request.POST)
                .fetch()
                .body()

        assertThat(HIPCHAT_RESPONSE_FORM.matches(response)).`as`(response + " aurait du matcher " + HIPCHAT_RESPONSE_FORM)
    }

    @After
    fun stop() {
        app.stop()
        portStore.free(port)
    }
}