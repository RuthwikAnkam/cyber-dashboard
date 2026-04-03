package com.cyberdashboard.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    // This handles requests to /login
    @GetMapping("/login")
    public String login() {
        // This returns the login.html page from templates folder
        return "login";
    }

    // This handles requests to the root URL
    @GetMapping("/")
    public String root() {
        // Redirect root URL to login page
        return "redirect:/login";
    }
}