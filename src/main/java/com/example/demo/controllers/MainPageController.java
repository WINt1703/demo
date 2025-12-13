package com.example.demo.controllers;

import com.example.demo.services.MainPageService;
import com.example.demo.models.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainPageController {
    private final MainPageService service;

    public MainPageController(MainPageService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getView(@RequestParam(name = "sort", required = false) String sortCode,
                          @RequestParam(name = "search", required = false) String searchQuery,
                          HttpSession session,
                          Model model) {
        if(session.getAttribute("user") instanceof User user) {
            var modelData = service.getMainPageData(searchQuery, sortCode);

            model.addAttribute("products", modelData.products());
            model.addAttribute("userName", user.getUsername());
            model.addAttribute("suppliers", modelData.suppliers());
            model.addAttribute("categories", modelData.categories());
            model.addAttribute("unittypes", modelData.unitTypes());
            model.addAttribute("manufacturers", modelData.manufacturers());

            return "main";
        }
        else {
            return "redirect:/login";
        }
    }
}
