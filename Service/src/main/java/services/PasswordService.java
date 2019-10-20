package services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class PasswordService {

    @Bean
    @Scope("singleton")
    public PasswordEncoder getBcCryptoPasswordEncoder() {
        return new BCryptPasswordEncoder(5);
    }

}
