package TicketingSystem.payment.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;

public abstract class PaymentResourceComponent implements PaymentResource {
    protected RepositoryUtil<Payment> paymentRepository;

    public PaymentResourceComponent() {
        this.paymentRepository = new RepositoryUtil<Payment>(TicketingSystem.payment.core.PaymentComponent.class);
    }

    public abstract HashMap<String, Object> savePayment(VMJExchange vmjExchange);

    public abstract HashMap<String, Object> updatePayment(VMJExchange vmjExchange);

    public abstract HashMap<String, Object> getPayment(VMJExchange vmjExchange);

    public abstract List<HashMap<String, Object>> getAllPayment(VMJExchange vmjExchange);

    public abstract List<HashMap<String, Object>> deletePayment(VMJExchange vmjExchange);

    public abstract int pay(int amount);
}
