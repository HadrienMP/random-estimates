package fr.hadrienmp.random_estimates.testutils

import fr.hadrienmp.random_estimates.domain.Picker
import java.util.*

class PickRecorder<out T>(private val picker: Picker<T>): Picker<T> {

    private val picks = mutableListOf<T>()

    override fun pick(): T {
        val pick = picker.pick()
        picks.add(pick)
        return pick
    }

    fun replay(): PickReplay<T> {
        return PickReplay(picks)
    }
}

class PickReplay<out T> (list: List<T>): Picker<T> {
    private val queue = ArrayDeque(list)

    override fun pick(): T {
        return queue.removeFirst()
    }
}