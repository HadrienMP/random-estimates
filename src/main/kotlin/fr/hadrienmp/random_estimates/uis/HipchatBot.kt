package fr.hadrienmp.random_estimates.uis

import fr.hadrienmp.random_estimates.domain.Estimates
import fr.hadrienmp.random_estimates.lib.bot.hipchat.HipChatResponse
import io.javalin.Context

object HipchatBot {
    private val estimates = Estimates()

    fun estimate(context: Context) {
        val rawResponse = estimates.get()
        val response = HipChatResponse(rawResponse)
        context.result(response.toString())
    }
}