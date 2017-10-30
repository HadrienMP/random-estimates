package fr.hadrienmp.random_estimates.bot.hipchat

import com.jcabi.http.Request
import com.jcabi.http.request.JdkRequest
import fr.hadrienmp.random_estimates.lib.web.PortStore
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class WebAppSpec {
    companion object {
        private val portStore = PortStore()
    }
    private val port = portStore.get()
    private val app = webapp(port)
    private val serverUrl = "http://localhost:${port.value()}"

    @Test fun `should respond to post requests with a hipchat response`() {
        val response = JdkRequest(serverUrl)
                .method(Request.POST)
                .fetch()
                .body()

        assertThat(HIPCHAT_RESPONSE_FORM.matches(response)).`as`(response + " aurait du matcher " + HIPCHAT_RESPONSE_FORM)
    }

    @Before
    fun setUp() {
        app.start()
    }

    @After
    fun stop() {
        app.stop()
        portStore.free(port)
    }
}