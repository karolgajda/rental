package pl.rental.administration.domain.command

import pl.rental.administration.domain.ChangeUserPasswordDto
import pl.rental.administration.domain.UserRepository
import pl.rental.common.domain.Command
import pl.rental.common.domain.Result

class ChangeUserPasswordCommand(
        private val userUuid: String,
        private val dto: ChangeUserPasswordDto,
        private val userRepository: UserRepository) : Command<String> {


    override fun execute(): Result<String> {
        val user = userRepository.findByUuid(userUuid)
        user.changePassword(dto.password, dto.newPassword)
        userRepository.save(user)
        return Result.success<String>(userUuid)
    }
}