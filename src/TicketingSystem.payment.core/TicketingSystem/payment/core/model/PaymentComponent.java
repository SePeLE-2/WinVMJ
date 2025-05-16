package TicketingSystem.payment.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import TicketingSystem.bundling.core.BundlingImpl;
import TicketingSystem.ticket.core.TicketImpl;

@Entity
@Table(name = "payment_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PaymentComponent implements Payment {
	@Id
	protected UUID id;
	public int amount;
	@ManyToOne(targetEntity = TicketingSystem.bundling.core.BundlingImpl.class)
	public BundlingImpl bundlingimpl;
	@ManyToOne(targetEntity = TicketingSystem.ticket.core.TicketImpl.class)
	public TicketImpl ticketimpl;
	protected String objectName = PaymentComponent.class.getName();

	public PaymentComponent() {

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

	public void pay() {
		System.out.println("Payment of " + amount + " made for ticket: " + ticketimpl.getTicketName());
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
