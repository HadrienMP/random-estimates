package fr.hadrienmp.random_estimates.lib.web

class Port(private val value: Int) {
    companion object {
        private val argumentRegex = Regex("port=\\d+")
        private fun portFrom(args: Array<String>): Int {
            val port = args.toList()
                    .filter { it.matches(argumentRegex) }
                    .map { it.split("=").last().toInt() }
                    .firstOrNull()
            return port ?: 8080
        }
    }

    constructor(args: Array<String>): this(portFrom(args))
    fun value(): Int = value
}