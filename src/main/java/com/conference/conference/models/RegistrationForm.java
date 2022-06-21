package com.conference.conference.models;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Data
public class RegistrationForm
{
    private String username;
    private String password;

    public User toUser(PasswordEncoder passwordEncoder)
    {
        User user = new User();

        user.setPassword(passwordEncoder.encode(password));
        user.setUsername(username);
        user.setRoles(Collections.singleton(Role.USER));

        return user;
    }
}
