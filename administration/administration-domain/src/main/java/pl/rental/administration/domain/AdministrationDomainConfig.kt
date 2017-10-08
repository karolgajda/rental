package pl.rental.administration.domain

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import pl.rental.administration.domain.command.AdministrationCommandFactory
import pl.rental.common.domain.UuidGenerator
import pl.rental.common.domain.UuidGeneratorImpl

@ComponentScan("pl.rental.administration.domain")
@EnableJpaRepositories("pl.rental.administration.domain")
@EntityScan(basePackages = arrayOf("pl.rental.administration.domain"))
class AdministrationDomainConfig {


    @Bean
    fun createUuid(): UuidGenerator {
        return UuidGeneratorImpl()

    }

    @Bean
    fun createFacade(command: AdministrationCommandFactory): AdministrationFacade {
        return AdministrationFacadeImpl(command)

    }

    @Bean
    fun createCommandFactory(repository: UserRepository, uuidGenerator: UuidGenerator): AdministrationCommandFactory {
        return AdministrationCommandFactory(repository, uuidGenerator)
    }
}