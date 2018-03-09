package fr.hadrienmp.random_estimates.domain

import java.io.File
import java.text.SimpleDateFormat
import java.util.*

fun languages(languageFilePaths: List<File>): List<Locale> {
    // todo simplifier en parcourant la liste et en gardant les locales valides
    return SimpleDateFormat.getAvailableLocales().filter { languageFilePaths contains it }
}

private infix fun List<File>.contains(locale: Locale): Boolean {
    return this containsAll listOf(
            "measures.txt",
            "units-${locale.toLanguageTag()}.txt",
            "phrases-${locale.toLanguageTag()}.txt")
}

private infix fun List<File>.containsAll(fileNames: List<String>): Boolean {
    return fileNames
            .map { fileName -> this contains fileName }
            .reduce { f, s -> f && s }
}

private infix fun List<File>.contains(suffix: String) = this.any { it.path.endsWith(suffix) }

