package pl.rental.administration.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication(scanBasePackages = arrayOf("pl.rental.administration"))
open class AdministrationAppStart


fun main(args: Array<String>) {
    SpringApplication.run(AdministrationAppStart::class.java, *args)
}




