package pl.rental.administration.domain.command

import pl.rental.administration.domain.ChangeUserPasswordDto
import pl.rental.administration.domain.CreateUserDto
import pl.rental.administration.domain.UserRepository
import pl.rental.common.domain.UuidGenerator


class AdministrationCommandFactory(
        private val userRepository: UserRepository,
        private val uuidGenerator: UuidGenerator
) {
    fun createUserCommand(dto: CreateUserDto): CreateUserCommand {
        return CreateUserCommand(dto, userRepository, uuidGenerator)
    }

    fun createChangeUserPasswordCommand(uuid: String, dto: ChangeUserPasswordDto): ChangeUserPasswordCommand {
        return ChangeUserPasswordCommand(uuid, dto, userRepository)
    }
}
