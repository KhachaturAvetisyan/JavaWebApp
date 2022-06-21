package com.conference.conference.controllers;

import com.conference.conference.models.RegistrationForm;
import com.conference.conference.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController
{
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String registration()
    {
        return "registration";
    }

    @PostMapping
    public String processUser(RegistrationForm form)
    {
        userRepo.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
