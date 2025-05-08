package TicketingSystem.payment.creditcard;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import TicketingSystem.payment.core.PaymentDecorator;
import TicketingSystem.payment.core.Payment;
import TicketingSystem.payment.core.PaymentComponent;

@Entity(name="payment_creditcard")
@Table(name="payment_creditcard")
public class PaymentImpl extends PaymentDecorator {

	public PaymentImpl() {
        super();
        this.objectName = PaymentImpl.class.getName();
    }

	
	public PaymentImpl(PaymentComponent record, ) {
		super(record);
		this.objectName = PaymentImpl.class.getName();
	}


	public void pay() {
		// TODO: implement this method
	}

}
