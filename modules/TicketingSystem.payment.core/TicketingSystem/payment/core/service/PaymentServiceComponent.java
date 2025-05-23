package TicketingSystem.payment.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class PaymentServiceComponent implements PaymentService {
    protected RepositoryUtil<Payment> paymentRepository;

    public PaymentServiceComponent() {
        this.paymentRepository = new RepositoryUtil<Payment>(TicketingSystem.payment.core.PaymentComponent.class);
    }

    public abstract Payment savePayment(HashMap<String, Object> body, String email);

    // public abstract Payment createPayment(Map<String, Object> requestBody);
    // public abstract Payment createPayment(Map<String, Object> requestBody,
    // Map<String, Object> response);
    public abstract Payment updatePayment(Map<String, Object> requestBody);

    public abstract Payment getPayment(UUID Id);

    public abstract List<Payment> getAllPayment();

    public abstract List<HashMap<String, Object>> transformListToHashMap(List<Payment> List);

    public abstract List<Payment> deletePayment(UUID Id);
    // public abstract HashMap<String, Object> getPaymentById(UUID id);

    public abstract int pay(int amount);
}
