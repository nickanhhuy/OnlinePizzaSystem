package com.example.Online_Pizza_System.controller;

import com.example.Online_Pizza_System.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/OnlinePizzaSystem")
    public String showOrderPage(Model model) {
        model.addAttribute("order", new Order());
        return "order";
    }
}
