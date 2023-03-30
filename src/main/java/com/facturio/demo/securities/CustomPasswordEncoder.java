package com.facturio.demo.securities;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class CustomPasswordEncoder implements PasswordEncoder {


    /**
     * Permet de crypter un mot de passe
     * @param rawPassword
     * @return mot de passe crypté
     */
    @Override
    public String encode(CharSequence rawPassword) {
        String genereratedSecuredHash = BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(12));
        return genereratedSecuredHash;
    }


    /**
     * Comparer 2 mots de passes
     * @param rawPassword the raw password to encode and match
     * @param encodedPassword the encoded password from storage to compare with
     * @return true si les mot de passes sont égaux
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
    }
}
