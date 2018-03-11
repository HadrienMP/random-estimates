package fr.hadrienmp.random_estimates.uis

import fr.hadrienmp.random_estimates.domain.*
import fr.hadrienmp.random_estimates.lib.JsonLanguage
import fr.hadrienmp.random_estimates.lib.LanguageFile
import fr.hadrienmp.random_estimates.lib.languageFilePaths
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

val log: Logger = LoggerFactory.getLogger("Bindings")

val internationalEstimateStore = internationalEstimateStore()

fun internationalEstimateStore(): InternationalEstimateStore {
    val estimateStores = estimateStores()
    return InternationalEstimateStore(
            estimateStores[Locale.ENGLISH]!!,
            estimateStores)
}

private fun estimateStores(): Map<Locale, DefaultEstimateStore> {
    val languageFilePaths = languageFilePaths()
    log.info(languageFilePaths.toString())
    return languageFilePaths
            .map { LanguageFile(it) }
            .map { Pair(it.locale, estimateStore(it.content())) }
            .toMap()
}

private fun estimateStore(json: String): DefaultEstimateStore {
    val jsonLanguage = JsonLanguage(json)
    return DefaultEstimateStore(
            RandomPicker(jsonLanguage.measures()),
            RandomPicker(jsonLanguage.units()),
            RandomPicker(jsonLanguage.phrases())
    )
}