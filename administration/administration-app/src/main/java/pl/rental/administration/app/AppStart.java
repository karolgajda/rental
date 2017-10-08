package pl.rental.administration.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"pl.rental.administration"})
public class AppStart {

    public static void main(String[] args) {
        SpringApplication.run(AppStart.class, args);

    }
}
