package pl.rental.administration.domain.command

import pl.rental.administration.domain.CreateUserDto
import pl.rental.administration.domain.User
import pl.rental.administration.domain.UserRepository
import pl.rental.common.domain.Command
import pl.rental.common.domain.Result
import pl.rental.common.domain.UuidGenerator

class CreateUserCommand(
        private val dto: CreateUserDto,
        private val userRepository: UserRepository,
        private val uuidGenerator: UuidGenerator) : Command<String> {


    override fun execute(): Result<String> {
        val user = createUser()
        userRepository.save(user)
        return Result.success<String>(user.uuid)
    }

    private fun createUser(): User {
        val uuid = uuidGenerator.uuidGenerate()
        val user = User()
        user.uuid = uuid
        user.email = dto.email
        user.password = dto.password
        return user
    }
}
