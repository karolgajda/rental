package pl.rental.administration.domain

interface AdministrationFacade {

    fun createUser(dto: CreateUserDto): pl.rental.common.domain.Result<String>
    fun updateUserPassword(userUuid:String, dto: ChangeUserPasswordDto): pl.rental.common.domain.Result<String>
}
