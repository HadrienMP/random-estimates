package fr.hadrienmp.random_estimates.uis.web

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
        val response = request().fetch().body()

        assertThat(response).containsPattern(Regex("<h1>.*Random.*Estimate.*").toPattern())
    }

    @Test
    fun `should contain an estimate`() {
        val response = request().fetch().body()

        assertThat(response).containsPattern(Regex("id=\"estimate\">[^>]+").toPattern())
    }

    @Test
    fun `should be rendered successfully`() {
        val response = request().fetch()

        assertThat(response.status()).isEqualTo(200)
    }

    private fun request() = webServerRule.request().method(Request.GET)
}