package com.codegnan.cgecom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codegnan.cgecom.model.Order;
import com.codegnan.cgecom.model.User;
import com.codegnan.cgecom.service.iface.OrderService;


import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public String viewOrders(HttpSession session, Model model) {
        // Fetch the logged-in user from the session
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            return "redirect:/login"; // Redirect to login page if not logged in
        }

        // Fetch all orders for the logged-in user
        List<Order> userOrders = orderService.getOrdersByUser(loggedInUser);

        // Add orders to the model
        model.addAttribute("orders", userOrders);

        return "orders"; // JSP page to display the orders
    }
}
