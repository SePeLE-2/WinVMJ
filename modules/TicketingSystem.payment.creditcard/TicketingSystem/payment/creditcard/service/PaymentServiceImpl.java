package TicketingSystem.payment.creditcard;

import java.util.*;

import vmj.routing.route.VMJExchange;

import TicketingSystem.payment.core.*;

public class PaymentServiceImpl extends PaymentServiceDecorator {
    public PaymentServiceImpl(PaymentServiceComponent record) {
        super(record);
    }

    public void pay() {
        // TODO: implement this method
        System.out.println("creditcard pay() called in service; this should ideally be in entity logic.");
    }

    public List<HashMap<String, Object>> savePayment(VMJExchange vmjExchange) {
        return record.savePayment(vmjExchange);
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
}
