package com.conference.conference.controllers;

import com.conference.conference.models.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController
{
    @GetMapping
    public String index(@AuthenticationPrincipal User user, Model model)
    {
        if (user != null)
        {
            model.addAttribute("user", user.getUsername());
            return "index";
        }

        model.addAttribute("user", "anonymous");
        return "index";
    }

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @PreAuthorize(value = "hasAuthority('ADMIN') or hasAuthority('USER')")
    @GetMapping("/foruser")
    public String forUser()
    {
        return "foruser";
    }

    @PreAuthorize(value = "hasAuthority('ADMIN')")
    @GetMapping("/foradmin")
    public String forAdmin()
    {
        return "foradmin";
    }
}
