package fr.hadrienmp.random_estimates.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test
import java.util.*

class RandomSpec {

    @Test fun `a random element of a list with a single element is the element`() {
        val element = "Coucou"

        val random = Random(SimpleListProvider(listOf(element)))

        assertThat(random.value()).isEqualTo(element)
    }

    @Test fun `once picked the random value never changes`() {
        val list = (1..100).map { UUID.randomUUID() }
        val listWrapper = SimpleListProvider(list)

        val random = Random(listWrapper)

        assertThat(random.value()).isEqualTo(random.value())
    }

    @Test fun `should accept lists and list wrappers`() {
        val element = "Coucou"

        val random = Random(listOf(element))

        assertThat(random.value()).isEqualTo(element)
    }

    @Test fun `the representation of the object is the representation of its value`() {
        val element = "Coucou"

        val random = Random(listOf(element))

        assertThat(random.toString()).isEqualTo(element)
    }

    @Test fun `should throw an exception when given an empty list`() {
        assertThatThrownBy { Random(listOf<String>()) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("La liste ne peut pas être vide")
    }

    class SimpleListProvider<out T>(private val list:List<T>): ListProvider<T> {
        override fun get(): List<T> {
            return list
        }
    }
}