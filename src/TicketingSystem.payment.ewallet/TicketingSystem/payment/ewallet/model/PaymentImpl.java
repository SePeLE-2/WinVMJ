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
		System.out.println("ewallet pay() called in service; this should ideally be in entity logic.");
	}

	@Override
	public int getAmount() {
		return this.amount;
	}

	@Override
	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public void setTicketimpl(TicketImpl ticketimpl) {
		this.ticketimpl = ticketimpl;
	}

	@Override
	public TicketImpl getTicketimpl() {
		return this.ticketimpl;
	}

	@Override
	public void setBundlingimpl(BundlingImpl bundlingimpl) {
		this.bundlingimpl = bundlingimpl;
	}

	@Override
	public BundlingImpl getBundlingimpl() {
		return this.bundlingimpl;
	}

}
