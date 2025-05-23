package TicketingSystem.payment.core;

import java.util.*;

import vmj.routing.route.VMJExchange;

public interface PaymentService {
    // Payment createPayment(Map<String, Object> requestBody);
    // Payment createPayment(Map<String, Object> requestBody, Map<String, Object>
    // response);
    Payment getPayment(UUID Id);

    Payment savePayment(HashMap<String, Object> body, String email);

    Payment updatePayment(Map<String, Object> requestBody);

    // HashMap<String, Object> getPaymentById(UUID id);
    List<Payment> getAllPayment();

    List<Payment> deletePayment(UUID Id);

    List<HashMap<String, Object>> transformListToHashMap(List<Payment> List);

    int pay(int amount);
}
