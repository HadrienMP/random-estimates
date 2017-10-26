package fr.hadrienmp.random_estimates.uis.web

import com.google.gson.JsonParseException
import com.google.gson.JsonParser
import com.pholser.junit.quickcheck.Property
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitQuickcheck::class)
class HipChatResponseSpec {

    @Property(trials = 10_000)
    fun `contains valid json`(message: String) {
        val response = HipChatResponse(message).toString()
        assertThat(isValidJson(response)).isTrue()
    }

    @Test fun `escapes quotes`() {
        val response = HipChatResponse("\"").toString()
        assertThat(response).contains("""message": "\"",""")
    }

    @Test fun `escapes backslashes`() {
        val response = HipChatResponse("\\").toString()
        assertThat(response).contains("""message": "\\",""")
    }

    private fun isValidJson(json: String): Boolean {
        return try {
            val jsonParser = JsonParser()
            jsonParser.parse(json)
            true
        } catch (e: JsonParseException) {
            false
        }
    }
}