package fr.hadrienmp.random_estimates.estimates


// todo the need for your presence is unclear
interface ListWrapper<T> {
    fun list(): List<T>
}

class SimpleListWrapper<T>(private val list:List<T>): ListWrapper<T> {
    override fun list(): List<T> {
        return list
    }
}