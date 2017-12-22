package fr.hadrienmp.random_estimates.uis

import com.jcabi.http.Request
import fr.hadrienmp.random_estimates.lib.bot.hipchat.HIPCHAT_RESPONSE_FORM
import fr.hadrienmp.random_estimates.testutils.WebServerRule
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test

class HipchatBotSpec {

    @Rule
    @JvmField
    val webServerRule = WebServerRule()

    @Test fun `should respond to post requests with a hipchat response`() {
        val response = webServerRule.request()
                .method(Request.POST)
                .fetch()
                .body()

        assertThat(response)
                .`as`(response + " aurait du matcher " + HIPCHAT_RESPONSE_FORM)
                .matches(HIPCHAT_RESPONSE_FORM.toPattern())
    }
}

