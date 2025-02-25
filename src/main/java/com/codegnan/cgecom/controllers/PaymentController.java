package com.codegnan.cgecom.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codegnan.cgecom.service.impl.PaymentService;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    
   
    @PostMapping("/verify")
    public String verifyPayment(@RequestParam String razorpayPaymentId,
                                @RequestParam String razorpayOrderId,
                                @RequestParam String razorpaySignature,
                                Model model) {
        // Payment verification logic (optional)
        model.addAttribute("paymentId", razorpayPaymentId);
        return "success"; // Success JSP
    }
}
