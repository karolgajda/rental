package pl.rental.administration.app

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import pl.rental.administration.domain.AdministrationDomainConfig

@Configuration
@ComponentScan("pl.rental.administration")
@Import(AdministrationDomainConfig::class)
class AdministrationAppConfig