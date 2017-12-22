package fr.hadrienmp.random_estimates.uis

import com.jcabi.http.Request
import fr.hadrienmp.random_estimates.testutils.WebServerRule
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test


class HomePageSpec {

    @Rule
    @JvmField
    val webServerRule = WebServerRule()

    @Test
    fun `should contain the title of the app`() {
        val response = webServerRule.request()
                .method(Request.GET)
                .fetch()
                .body()

        assertThat(response).contains("<h1>Random Estimates</h1>")
    }

    @Test
    fun `should be rendered successfully`() {
        val response = webServerRule.request()
                .method(Request.GET)
                .fetch()

        assertThat(response.status()).isEqualTo(200)
    }
}