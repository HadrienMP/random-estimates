package fr.hadrienmp.random_estimates.estimates

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class EstimateSpec {

    @Test fun should_concatenate_the_unit_and_the_estimate() {
        val estimate = "1"
        val unit = "jour"

        val randomEstimate = Estimate(estimate, unit)

        assertThat(randomEstimate.toString()).isEqualTo("1 jour")
    }

    @Test fun the_task_is_already_done_when_the_estimate_is_0() {
        val estimate = "0"
        val unit = "jour"

        val randomEstimate = Estimate(estimate, unit)

        assertThat(randomEstimate.toString()).isEqualTo("Déjà terminé ! Félicitations")
    }

    @Test fun the_unit_should_be_plural_when_the_estimate_is_bigger_than_1() {
        val estimate = "2"
        val unit = "jour"

        val randomEstimate = Estimate(estimate, unit)

        assertThat(randomEstimate.toString()).isEqualTo("2 jours")
    }

    @Test fun the_unit_should_not_be_plural_when_the_estimate_is_not_a_number() {
        val estimate = "toto"
        val unit = "jour"

        val randomEstimate = Estimate(estimate, unit)

        assertThat(randomEstimate.toString()).isEqualTo("toto jour")
    }
}
