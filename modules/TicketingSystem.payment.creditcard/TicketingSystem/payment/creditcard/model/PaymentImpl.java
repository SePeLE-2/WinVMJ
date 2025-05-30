package TicketingSystem.payment.creditcard;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import TicketingSystem.payment.core.*;

import TicketingSystem.ticket.core.TicketImpl;
import TicketingSystem.bundling.core.BundlingImpl;

@Entity(name = "payment_creditcard")
@Table(name = "payment_creditcard")
public class PaymentImpl extends PaymentDecorator {

	public PaymentImpl() {
		super();
		this.objectName = PaymentImpl.class.getName();
	}

	public PaymentImpl(PaymentComponent record) {
		super(record);
		this.objectName = PaymentImpl.class.getName();
	}

	@Override
	public int pay(int amount) {
		// TODO: implement this method
		System.out.println("creditcard pay() called in service");
		return amount + 1000;
	}

	@Override
	public String toString() {
		return "{" +
				" amount='" + getAmount() + "'" +
				" bundlingimpl='" + getBundling() + "'" +
				" ticketimpl='" + getTicket() + "'" +
				"}";
	}

	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> paymentMap = new HashMap<String, Object>();
		paymentMap.put("amount", getAmount());
		paymentMap.put("bundlingimpl", getBundling());
		paymentMap.put("ticketimpl", getTicket());
		return paymentMap;
	}

}
