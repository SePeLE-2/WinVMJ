package TicketingSystem.payment.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages
import TicketingSystem.bundling.core.*;
import TicketingSystem.ticket.core.*;
// import TicketingSystem.customer.core.*;

@MappedSuperclass
public abstract class PaymentDecorator extends PaymentComponent {
	@OneToOne(cascade = CascadeType.ALL)
	protected PaymentComponent record;

	public PaymentDecorator() {
		super();
		this.record = record;
		this.id = UUID.randomUUID();
	}

	public PaymentDecorator(PaymentComponent record) {
		this.id = UUID.randomUUID();
		this.record = record;
	}

	public PaymentDecorator(PaymentComponent record, String objectName) {
		this.id = UUID.randomUUID();
		this.record = record;
		this.objectName = objectName;
	}

	public int getAmount() {
		return record.getAmount();
	}

	public void setAmount(int amount) {
		record.setAmount(amount);
	}

	public Bundling getBundling() {
		return record.getBundling();
	}

	public void setBundling(Bundling bundlingimpl) {
		this.bundling = bundlingimpl;
	}

	// public Customer getCustomerimpl() {
	// return record.getCustomerimpl();
	// }

	// public void setCustomerimpl(Customer customerimpl) {
	// this.customer = customerimpl;
	// }

	public Ticket getTicket() {
		return record.getTicket();
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public int pay(int amount) {
		return record.pay(amount);
	}

	public HashMap<String, Object> toHashMap() {
		return this.record.toHashMap();
	}

}
