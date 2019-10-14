package services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class BcPasswordEncoder {

    private static PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(5);

    public static PasswordEncoder get() {
        return bCryptPasswordEncoder;
    }

}
