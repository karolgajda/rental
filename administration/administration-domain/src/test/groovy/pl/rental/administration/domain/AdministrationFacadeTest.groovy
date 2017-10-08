package pl.rental.administration.domain

import pl.rental.common.domain.Result
import pl.rental.common.domain.UuidGeneratorImpl

class AdministrationFacadeTest extends spock.lang.Specification {

    def facade
    def repository

    void setup() {
        def config = new AdministrationDomainConfig()
        repository = Mock(UserRepository)
        def uuidGenerator = new UuidGeneratorImpl()
        def command = config.createCommandFactory(repository, uuidGenerator)
        facade = config.createFacade(command)

    }

    void cleanup() {
    }

    def "CreateUser - success"() {
        setup:
        def createUserDto = new CreateUserDto("karoll.gajda@gmail.com", "password", "password")
        def result
        def userEntity

        when:
        result = facade.createUser(createUserDto)

        then:
        result in Result.Success
        1 * repository.save(_) >> { arguments -> userEntity = arguments[0] }
        userEntity.uuid == result.value
        userEntity.email == createUserDto.email
        userEntity.password == createUserDto.password


    }

    def "ChangeUserPassword - success"() {
        setup:
        def userUuid = "sameUUID"
        repository.findByUuid(userUuid) >> new User(id: 1L, uuid: userUuid, email: "same@email.pl", password: "OldPassword")
        def changeUserPasswordDto = new ChangeUserPasswordDto("OldPassword", "NewPassword", "NewPassword")
        def userEntity
        def result

        when:
        result = facade.updateUserPassword(userUuid, changeUserPasswordDto)

        then:
        result in Result.Success
        1 * repository.save(_) >> { arguments -> userEntity = arguments[0] }
        userEntity.uuid == userUuid
        userEntity.password == changeUserPasswordDto.newPassword
    }

    def "ChangeUserPassword - Password not Match"() {
        setup:
        def userUuid = "sameUUID"
        repository.findByUuid(userUuid) >> new User(id: 1L, uuid: userUuid, email: "same@email.pl", password: "OldPassword")
        def changeUserPasswordDto = new ChangeUserPasswordDto("OldWrongPassword", "NewPassword", "NewPassword")

        when:
        facade.updateUserPassword(userUuid, changeUserPasswordDto)

        then:
        thrown(AdministrationPasswordNotMatch)
    }
}
