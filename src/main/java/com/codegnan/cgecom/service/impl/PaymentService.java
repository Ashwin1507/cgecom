package com.codegnan.cgecom.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Service
public class PaymentService {

    private RazorpayClient razorpayClient;

    public PaymentService() throws Exception {
        this.razorpayClient = new RazorpayClient("YOUR_API_KEY", "YOUR_API_SECRET");
    }

    
    
    
    
    public Map createOrder(double amount) throws Exception {
        JSONObject options = new JSONObject();
        options.put("amount", (int) (amount * 100)); // Amount in paise
        options.put("currency", "INR");
        options.put("receipt", "txn_123456");

        Order order = razorpayClient.orders.create(options);
        
        // Convert to a Map for easy access in the JSP
        Map<String, Object> orderDetails = new HashMap<>();
        orderDetails.put("id", order.get("id"));
        orderDetails.put("amount", order.get("amount"));
        orderDetails.put("currency", order.get("currency"));
        return orderDetails;
       
    }
    
    
    
    
    
    
    
    
}
