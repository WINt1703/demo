package com.example.demo.controllers;

import com.example.demo.models.Product;
import com.example.demo.models.User;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String getView(HttpSession session) {
        if(session.getAttribute("user") instanceof User) {
            return "redirect:/";
        }

        return "login";
    }

    @PostMapping
    public String authenticate(@RequestParam String username, @RequestParam String password, HttpSession session) {
        var user = loginService.getUserByUsernameAndPassword(username, password);

        if(user.isPresent()) {
            session.setAttribute("user", user.orElseThrow());
            return "redirect:/";
        }
        else {
            return "redirect:/login?error";
        }
    }
}
