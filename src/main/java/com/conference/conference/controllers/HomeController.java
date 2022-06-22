package com.conference.conference.controllers;

import com.conference.conference.models.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            model.addAttribute("user_role", user.getRoles());
            return "index";
        }

        model.addAttribute("user", "anonymous");
        model.addAttribute("user_role", "anonymous");
        return "index";
    }

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @GetMapping("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null)
            new SecurityContextLogoutHandler().logout(request, response, auth);

        return "redirect:/";
    }

//    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/user")
    public String forUser()
    {
        System.out.println("open page foruser");
        return "foruser";
    }

//    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin")
    public String forAdmin()
    {
        System.out.println("open page foradmin");
        return "foradmin";
    }
}
