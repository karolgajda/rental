package pl.rental.administration.domain

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User,Long> {
    fun findByUuid(userUuid: String): User
}

