package TicketingSystem.payment.creditcard;

import java.util.*;

import vmj.routing.route.VMJExchange;

import TicketingSystem.payment.core.PaymentServiceDecorator;
import TicketingSystem.payment.core.PaymentImpl;
import TicketingSystem.payment.core.PaymentServiceComponent;

public class PaymentServiceImpl extends PaymentServiceDecorator {
    public PaymentServiceImpl (PaymentServiceComponent record) {
        super(record);
    }

    
	public void pay() {
		// TODO: implement this method
	}
}
