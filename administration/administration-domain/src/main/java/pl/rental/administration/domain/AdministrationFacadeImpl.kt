package pl.rental.administration.domain

import pl.rental.administration.domain.command.AdministrationCommandFactory
import pl.rental.common.domain.Result

class AdministrationFacadeImpl(
        private val administrationCommandFactory: AdministrationCommandFactory
) : AdministrationFacade {
    override fun createUser(dto: CreateUserDto): Result<String> {
        return administrationCommandFactory.createUserCommand(dto).execute()
    }

    override fun updateUserPassword(userUuid: String, dto: ChangeUserPasswordDto): Result<String> {
        return administrationCommandFactory.createChangeUserPasswordCommand(userUuid, dto).execute()
    }
}
