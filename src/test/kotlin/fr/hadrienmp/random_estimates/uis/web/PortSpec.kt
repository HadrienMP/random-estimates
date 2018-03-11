package fr.hadrienmp.random_estimates.uis.web

import fr.hadrienmp.random_estimates.uis.web.Port
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PortSpec {

    private val default_port = 8080

    @Test
    fun `should create port from argument list`() {
        val expectedPort = 1234

        val port = Port(arrayOf("port=$expectedPort"))

        assertThat(port.value()).isEqualTo(expectedPort)
    }

    @Test
    fun `should return the default port for an empty list`() {
        val port = Port(arrayOf())

        assertThat(port.value()).isEqualTo(default_port)
    }

    @Test
    fun `should return the default port for an empty port`() {
        val port = Port(arrayOf("port="))

        assertThat(port.value()).isEqualTo(default_port)
    }

    @Test
    fun `should return the default port for a port that is not a number`() {
        val port = Port(arrayOf("port=dfsf"))

        assertThat(port.value()).isEqualTo(default_port)
    }

    @Test
    fun `should return the default port for a negative number`() {
        val port = Port(arrayOf("port=-14"))

        assertThat(port.value()).isEqualTo(default_port)
    }
}