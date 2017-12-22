package fr.hadrienmp.random_estimates.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class EstimateSpec {

    @Test fun `should concatenate the unit and the estimate`() {
        val estimate = "1"
        val unit = "jour"

        val randomEstimate = Estimate(estimate, unit)

        assertThat(randomEstimate.toString()).isEqualTo("1 jour")
    }

    @Test fun `the unit should be plural when the estimate is bigger than 1`() {
        val estimate = "2"
        val unit = "jour"

        val randomEstimate = Estimate(estimate, unit)

        assertThat(randomEstimate.toString()).isEqualTo("2 jours")
    }

    @Test fun `the unit should be plural when the estimate is lower than minus 1`() {
        val estimate = "-2"
        val unit = "jour"

        val randomEstimate = Estimate(estimate, unit)

        assertThat(randomEstimate.toString()).isEqualTo("-2 jours")
    }

    @Test fun `the unit should not be plural when the estimate is not a number`() {
        val estimate = "toto"
        val unit = "jour"

        val randomEstimate = Estimate(estimate, unit)

        assertThat(randomEstimate.toString()).isEqualTo("toto jour")
    }
}
