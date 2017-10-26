package fr.hadrienmp.random_estimates.bot.hipchat

import com.google.gson.JsonParseException
import com.google.gson.JsonParser
import com.pholser.junit.quickcheck.Property
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith

val HIPCHAT_RESPONSE_FORM = Regex("""\{\s*"color":\s?"\w+",\s*"message":\s?".*",\s*"notify":\s?(true|false),\s*"message_format":\s?"\w+"\s*}""")

@RunWith(JUnitQuickcheck::class)
class HipChatResponseSpec {

    @Property(trials = 1_000)
    fun `contains valid json`(message: String) {
        val response = HipChatResponse(message).toString()
        assertThat(isValidJson(response)).isTrue()
    }

    @Property(trials = 1_000)
    fun `matched the hip chat response spec`(message: String) {
        val response = HipChatResponse(message).toString()
        assertThat(HIPCHAT_RESPONSE_FORM.matches(response)).`as`(response + " aurait du matcher " + HIPCHAT_RESPONSE_FORM)
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