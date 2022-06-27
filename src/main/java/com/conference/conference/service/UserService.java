package com.conference.conference.service;

import com.conference.conference.models.User;
import com.conference.conference.models.enums.Role;
import com.conference.conference.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService
{
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public void createUser(User user)
    {
        if (userRepo.findByUsername(user.getUsername()) != null)
            return;

        String username = user.getUsername();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.USER);
        log.info("Saving new User with username: {}", username);
        userRepo.save(user);

    }
}
