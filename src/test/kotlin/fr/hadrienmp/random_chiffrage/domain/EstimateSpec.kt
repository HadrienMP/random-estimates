package fr.hadrienmp.random_chiffrage.domain

import fr.hadrienmp.random_chiffrage.domain.Estimate
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class EstimateSpec {

    @Test fun should_concatenate_the_unit_and_the_estimate() {
        val chiffre = "1"
        val unit = "jour"

        val randomChiffrage = Estimate(chiffre, unit)

        assertThat(randomChiffrage.toString()).isEqualTo("1 jour")
    }

    @Test fun the_task_is_already_done_when_the_estimate_is_0() {
        val chiffre = "0"
        val unit = "jour"

        val randomChiffrage = Estimate(chiffre, unit)

        assertThat(randomChiffrage.toString()).isEqualTo("Déjà terminé ! Félicitations")
    }

    @Test fun the_unit_should_be_plural_when_the_estimate_is_bigger_than_1() {
        val chiffre = "2"
        val unit = "jour"

        val randomChiffrage = Estimate(chiffre, unit)

        assertThat(randomChiffrage.toString()).isEqualTo("2 jours")
    }

    @Test fun the_unit_should_not_be_plural_when_the_estimate_is_not_a_number() {
        val chiffre = "toto"
        val unit = "jour"

        val randomChiffrage = Estimate(chiffre, unit)

        assertThat(randomChiffrage.toString()).isEqualTo("toto jour")
    }
}
