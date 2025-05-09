package TicketingSystem.payment.ewallet;

import java.util.*;

import vmj.routing.route.VMJExchange;

import TicketingSystem.payment.core.PaymentServiceDecorator;
import TicketingSystem.payment.core.PaymentImpl;
import TicketingSystem.payment.core.PaymentServiceComponent;
import TicketingSystem.payment.core.Payment;

public class PaymentServiceImpl extends PaymentServiceDecorator {
    public PaymentServiceImpl(PaymentServiceComponent record) {
        super(record);
    }

    public void pay() {
        // TODO: implement this method
        System.out.println("ewallet pay() called in service; this should ideally be in entity logic.");
    }

    public List<HashMap<String, Object>> savePayment(VMJExchange vmjExchange) {
        return record.savePayment(vmjExchange);
    }

    public Payment createPayment(Map<String, Object> requestBody) {
        return record.createPayment(requestBody);
    }

    public Payment createPayment(Map<String, Object> requestBody, Map<String, Object> response) {
        return record.createPayment(requestBody, response);
    }

    public HashMap<String, Object> getPayment(Map<String, Object> requestBody) {
        return record.getPayment(requestBody);
    }

    public List<HashMap<String, Object>> getAllPayment(Map<String, Object> requestBody) {
        return record.getAllPayment(requestBody);
    }

    public HashMap<String, Object> updatePayment(Map<String, Object> requestBody) {
        return record.updatePayment(requestBody);
    }

    public List<HashMap<String, Object>> transformListToHashMap(List<Payment> List) {
        return record.transformListToHashMap(List);
    }

    public List<HashMap<String, Object>> deletePayment(Map<String, Object> requestBody) {
        return record.deletePayment(requestBody);
    }

    public List<HashMap<String, Object>> savePayment(Map<String, Object> requestBody) {
        return record.savePayment(requestBody);
    }

    public HashMap<String, Object> getPaymentById(UUID id) {
        return record.getPaymentById(id);
    }
}
