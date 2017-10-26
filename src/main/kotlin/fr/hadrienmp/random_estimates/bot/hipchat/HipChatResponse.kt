package fr.hadrienmp.random_estimates.bot.hipchat

class HipChatResponse(private val message: String) {
    override fun toString(): String {
        val escaped = message.replace("\\", "\\\\").replace("\"", "\\\"")

        return """{
            "color": "green",
            "message": "$escaped",
            "notify": false,
            "message_format": "text"
        }"""
    }
}