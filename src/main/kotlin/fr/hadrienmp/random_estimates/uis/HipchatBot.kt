package fr.hadrienmp.random_estimates.uis

import fr.hadrienmp.random_estimates.domain.RandomEstimatesBot
import fr.hadrienmp.random_estimates.lib.bot.hipchat.HipChatResponse
import io.javalin.Context

object HipchatBot {
    private val bot = RandomEstimatesBot()

    fun estimate(context: Context) {
        val rawResponse = bot.response()
        val response = HipChatResponse(rawResponse)
        context.result(response.toString())
    }
}