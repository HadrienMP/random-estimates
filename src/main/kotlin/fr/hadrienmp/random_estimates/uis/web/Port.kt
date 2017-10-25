package fr.hadrienmp.random_estimates.uis.web

class Port(private val args: Array<String>) {
    private val argumentRegex = Regex("port=\\d+")

    fun value(): Int {
        val port = args.toList()
                .filter { it.matches(argumentRegex) }
                .map { it.split("=").last().toInt() }
                .firstOrNull()
        return port ?: 8080
    }
}