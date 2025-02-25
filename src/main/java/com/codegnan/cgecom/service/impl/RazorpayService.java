package com.codegnan.cgecom.service.impl;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;

import jakarta.annotation.PostConstruct;

@Service
public class RazorpayService {

    @Value("${razorpay.key}")
    private String razorpayKey;

    @Value("${razorpay.secret}")
    private String razorpaySecret;
    
    private RazorpayClient client;

    @PostConstruct
    public void init() throws Exception {
        if (razorpayKey == null || razorpaySecret == null) {
            throw new IllegalArgumentException("Razorpay Key and Secret must not be null");
        }
        client = new RazorpayClient(razorpayKey, razorpaySecret);
    }

    public Order createOrder(double amount, String currency, String receipt) throws Exception {
        // Prepare order options as a JSONObject
        JSONObject options = new JSONObject();
        options.put("amount", (int) (amount * 100)); // Amount in paise (e.g., ₹1 = 100 paise)
        options.put("currency", currency);
        options.put("receipt", receipt);

        // Create the order using the Razorpay client
        return client.orders.create(options);
    }
    
    public String getPaymentStatus(String paymentId) throws Exception {
        // Fetch payment details using the payment ID
        Payment payment = client.payments.fetch(paymentId);

        // Extract and return the payment status (e.g., "captured", "failed")
        return payment.get("status");
    }
}
