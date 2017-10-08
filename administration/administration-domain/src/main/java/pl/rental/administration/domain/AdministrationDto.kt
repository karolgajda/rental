package pl.rental.administration.domain

import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.NotBlank


data class CreateUserDto(
        @get: Email
        var email: String,
        @get: NotBlank
        var password: String,
        @get: NotBlank
        var confirmPassword: String
)

data class ChangeUserPasswordDto(
        @get: NotBlank
        var password: String,
        @get: NotBlank
        var newPassword: String,
        @get: NotBlank
        var confirmNewPassword: String
)