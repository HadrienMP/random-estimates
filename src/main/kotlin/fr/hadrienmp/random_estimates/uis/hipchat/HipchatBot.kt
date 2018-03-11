package fr.hadrienmp.random_estimates.uis.hipchat

import fr.hadrienmp.random_estimates.uis.internationalEstimateStore
import io.javalin.Context
import java.util.*

object HipchatBot {
    private val estimates = internationalEstimateStore

    fun estimate(context: Context) {
        val rawResponse = estimates.get(Locale.FRENCH)
        val response = HipChatResponse(rawResponse)
        context.result(response.toString())
    }
}