package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"entities"})
@ComponentScan(basePackages = {"services", "web"})
@EnableJpaRepositories(basePackages = {"repositories"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}