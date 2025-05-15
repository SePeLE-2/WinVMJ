package TicketingSystem.payment.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages
import TicketingSystem.bundling.core.BundlingImpl;
import TicketingSystem.ticket.core.TicketImpl;

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

	public BundlingImpl getBundlingimpl() {
		return record.getBundlingimpl();
	}

	public void setBundlingimpl(BundlingImpl bundlingimpl) {
		record.setBundlingimpl(bundlingimpl);
	}

	public TicketImpl getTicketimpl() {
		return record.getTicketimpl();
	}

	public void setTicketimpl(TicketImpl ticketimpl) {
		this.ticketimpl = ticketimpl;
	}

	public void pay() {
		record.pay();
	}

	public HashMap<String, Object> toHashMap() {
		return this.record.toHashMap();
	}

}
