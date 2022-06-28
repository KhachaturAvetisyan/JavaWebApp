package com.conference.conference.controllers;

import com.conference.conference.models.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class MainController {

    @GetMapping("/")
    public String index(@AuthenticationPrincipal User user, Model model)
    {
        if (user != null)
        {
            log.info("User login name: {}", user.getUsername());
            model.addAttribute("title", "main page");
            return "main";
        }

        return "redirect:/login";
    }

}
