package pl.rental.administration.app.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import pl.rental.administration.domain.AdministrationFacade
import pl.rental.administration.domain.ChangeUserPasswordDto
import pl.rental.administration.domain.CreateUserDto

@RestController
@RequestMapping(value = "/v1/user")
class UserCommandController (
    @Autowired private val administrationFacade: AdministrationFacade
){

    @PostMapping(value = "/")
    fun createUser(@RequestBody createUserDto: CreateUserDto) {
        administrationFacade.createUser(createUserDto)
    }

    @PutMapping(value = "/{userUuid}/password")
    fun changeUserPassword(@PathVariable userUuid: String,
                           @RequestBody changeUserPasswordDto: ChangeUserPasswordDto) {
        administrationFacade.updateUserPassword(userUuid, changeUserPasswordDto)
    }
}
