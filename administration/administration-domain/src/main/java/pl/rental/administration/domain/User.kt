package pl.rental.administration.domain

import javax.persistence.*

@Entity
@Table(name = "users", schema = "administration")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    var uuid: String? = null
    var email: String? = null
    var password: String? = null

    fun changePassword(password: String, newPassword: String) {
        if (this.password == password) {
            this.password = newPassword
        } else {
            throw AdministrationPasswordNotMatch()
        }
    }
}

class AdministrationPasswordNotMatch : RuntimeException()
