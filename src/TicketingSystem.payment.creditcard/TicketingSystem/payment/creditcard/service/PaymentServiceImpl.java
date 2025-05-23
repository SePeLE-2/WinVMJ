package TicketingSystem.payment.creditcard;

import java.util.*;
import TicketingSystem.payment.core.*;
import TicketingSystem.bundling.core.BundlingImpl;
import TicketingSystem.ticket.core.Ticket;
import TicketingSystem.ticket.core.TicketImpl;
import TicketingSystem.payment.PaymentFactory;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import vmj.auth.annotations.Restricted;

public class PaymentServiceImpl extends PaymentServiceDecorator {
    public PaymentServiceImpl(PaymentServiceComponent record) {
        super(record);
    }

    public int pay(int amount) {
        // TODO: implement this method
        System.out.println("creditcard pay() called in service");
        return amount + 1000;
    }

    @Override
    public Payment savePayment(HashMap<String, Object> body, String email) {
        if (!body.containsKey("amount")) {
            throw new FieldValidationException("Field 'amount' not found in the request body.");
        }
        int amount = (int) body.get("amount");
        amount = pay(amount);

        UUID id = UUID.randomUUID();

        // TODO: retrieve from DB
        BundlingImpl bundlingimpl = new BundlingImpl();
        TicketImpl ticketimpl = new TicketImpl();

        Payment payment = PaymentFactory.createPayment("TicketingSystem.payment.core.PaymentImpl",
                id,
                amount,
                bundlingimpl,
                ticketimpl);
        paymentRepository.saveObject(payment);
        return paymentRepository.getObject(id);
    }

    public Payment updatePayment(Map<String, Object> body) {
        if (!body.containsKey("id")) {
            throw new NotFoundException("Field 'id' not found in the request body.");
        }
        String idStr = (String) body.get("id");
        UUID id = UUID.fromString(idStr);

        Payment payment = paymentRepository.getObject(id);
        if (payment == null) {
            throw new NotFoundException("Payment with id " + id + " not found");
        }

        if (body.containsKey("amount")) {
            int amount = (int) body.get("amount");
            payment.setAmount(amount);
        }

        paymentRepository.updateObject(payment);
        payment = paymentRepository.getObject(id);

        return payment;
    }

    public Payment getPayment(UUID Id) {
        Payment payment = paymentRepository.getObject(Id);
        if (payment == null) {
            throw new NotFoundException("Payment with Id " + Id + " not found");
        }
        return payment;
    }

    public List<Payment> getAllPayment() {
        List<Payment> resultList = paymentRepository.getListObject("payment_impl", null, null);
        Set<String> uniqueNames = new HashSet<>();
        List<Payment> uniquePayment = new ArrayList<>();
        for (Payment payment : resultList) {
            uniquePayment.add(payment);
        }
        return uniquePayment;
    }

    public List<HashMap<String, Object>> transformListToHashMap(List<Payment> List) {
        List<HashMap<String, Object>> resultList = new ArrayList<>();
        for (int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
    }

    public List<Payment> deletePayment(UUID id) {
        paymentRepository.deleteObject(id);
        return getAllPayment();
    }
}
