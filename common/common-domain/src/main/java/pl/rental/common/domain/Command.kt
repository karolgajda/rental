package pl.rental.common.domain

interface Command<T> {

    fun execute(): pl.rental.common.domain.Result<T>
}
