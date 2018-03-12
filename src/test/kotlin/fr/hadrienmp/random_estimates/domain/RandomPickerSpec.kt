package fr.hadrienmp.random_estimates.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class RandomPickerSpec {

    @Test(expected = IllegalArgumentException::class)
    fun `should throw an exception when given an empty list`() {
        RandomPicker(listOf<String>())
    }

    @Test
    fun `should return an element from the list`() {
        val values = listOf("titi", "toto", "tata")
        val randomPicker = RandomPicker(values)

        val pick = randomPicker.pick()

        assertThat(pick).isIn(values)
    }
}