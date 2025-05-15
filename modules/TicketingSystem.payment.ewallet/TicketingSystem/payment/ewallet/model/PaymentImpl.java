package TicketingSystem.payment.ewallet;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import TicketingSystem.payment.core.PaymentDecorator;
import TicketingSystem.payment.core.Payment;
import TicketingSystem.payment.core.PaymentComponent;

import TicketingSystem.bundling.core.BundlingImpl;
import TicketingSystem.ticket.core.TicketImpl;

@Entity(name = "payment_ewallet")
@Table(name = "payment_ewallet")
public class PaymentImpl extends PaymentDecorator {

	public PaymentImpl() {
		super();
		this.objectName = PaymentImpl.class.getName();
	}

	public PaymentImpl(PaymentComponent record) {
		super(record);
		this.objectName = PaymentImpl.class.getName();
	}

	public void pay() {
		// TODO: implement this method
		System.out.println("ewallet pay() called in service");
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public BundlingImpl getBundlingimpl() {
		return this.bundlingimpl;
	}

	public void setBundlingimpl(BundlingImpl bundlingimpl) {
		this.bundlingimpl = bundlingimpl;
	}

	public TicketImpl getTicketimpl() {
		return this.ticketimpl;
	}

	public void setTicketimpl(TicketImpl ticketimpl) {
		this.ticketimpl = ticketimpl;
	}

	@Override
	public String toString() {
		return "{" +
				" amount='" + getAmount() + "'" +
				" bundlingimpl='" + getBundlingimpl() + "'" +
				" ticketimpl='" + getTicketimpl() + "'" +
				"}";
	}

	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> paymentMap = new HashMap<String, Object>();
		paymentMap.put("amount", getAmount());
		paymentMap.put("bundlingimpl", getBundlingimpl());
		paymentMap.put("ticketimpl", getTicketimpl());
		return paymentMap;
	}
}
