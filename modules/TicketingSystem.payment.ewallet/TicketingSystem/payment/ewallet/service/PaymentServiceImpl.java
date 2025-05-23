package TicketingSystem.payment.ewallet;

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
        System.out.println("ewallet pay() called in service");
        return amount + 2000;
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

// import java.util.*;

// import vmj.routing.route.VMJExchange;

// import TicketingSystem.payment.core.PaymentServiceDecorator;
// import TicketingSystem.payment.core.PaymentImpl;
// import TicketingSystem.payment.core.PaymentServiceComponent;
// import TicketingSystem.payment.core.Payment;

// public class PaymentServiceImpl extends PaymentServiceDecorator {
// public PaymentServiceImpl(PaymentServiceComponent record) {
// super(record);
// }

// public void pay() {
// // TODO: implement this method
// System.out.println("ewallet pay() called in service; this should ideally be
// in entity logic.");
// }

// public List<HashMap<String, Object>> savePayment(VMJExchange vmjExchange) {
// return record.savePayment(vmjExchange);
// }

// public HashMap<String, Object> getPayment(Map<String, Object> requestBody) {
// return record.getPayment(requestBody);
// }

// public List<HashMap<String, Object>> getAllPayment(Map<String, Object>
// requestBody) {
// return record.getAllPayment(requestBody);
// }

// public HashMap<String, Object> updatePayment(Map<String, Object> requestBody)
// {
// return record.updatePayment(requestBody);
// }

// public List<HashMap<String, Object>> transformListToHashMap(List<Payment>
// List) {
// return record.transformListToHashMap(List);
// }

// public List<HashMap<String, Object>> deletePayment(Map<String, Object>
// requestBody) {
// return record.deletePayment(requestBody);
// }

// public List<HashMap<String, Object>> savePayment(Map<String, Object>
// requestBody) {
// return record.savePayment(requestBody);
// }
// }
