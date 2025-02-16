package com.example.Online_Pizza_System.controller;

import com.example.Online_Pizza_System.model.Order;
import com.example.Online_Pizza_System.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class OrderController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping("/receipt")
    public String submitOrder(@ModelAttribute Order order, Model model) {
        Order receipt = pizzaService.processOrder(order);
        model.addAttribute("receipt", receipt);
        return "receipt";
    }
}
