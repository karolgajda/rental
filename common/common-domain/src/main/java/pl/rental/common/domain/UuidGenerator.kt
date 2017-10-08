package pl.rental.common.domain

import java.util.*

interface UuidGenerator {
    fun uuidGenerate(): String
}


    class UuidGeneratorImpl : UuidGenerator {
        override fun uuidGenerate(): String {
            return UUID.randomUUID().toString()
        }

    }
