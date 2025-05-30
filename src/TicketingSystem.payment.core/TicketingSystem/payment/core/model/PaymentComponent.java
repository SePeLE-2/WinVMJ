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

import TicketingSystem.bundling.core.*;
// import TicketingSystem.customer.core.*;
import TicketingSystem.ticket.core.Ticket;

@Entity
@Table(name = "payment_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PaymentComponent implements Payment {
	@Id
	protected UUID id;
	public int amount;
	// @ManyToOne(targetEntity =
	// TicketingSystem.customer.core.CustomerComponent.class)
	// public Customer customer;
	@ManyToOne(targetEntity = TicketingSystem.bundling.core.BundlingImpl.class)
	public Bundling bundling;
	@ManyToOne(targetEntity = TicketingSystem.ticket.core.TicketImpl.class)
	public Ticket ticket;
	protected String objectName = PaymentComponent.class.getName();

	public PaymentComponent() {

	}

	public PaymentComponent(
			UUID idContent, int amount,
			// Customer customer,
			Bundling bundling, Ticket ticket) {
		this.id = idContent;
		this.amount = amount;
		// this.customer = customer;
		this.bundling = bundling;
		this.ticket = ticket;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public abstract Bundling getBundling();

	public abstract void setBundling(Bundling bundlingimpl);

	// public abstract Customer getCustomerimpl();

	// public abstract void setCustomerimpl(Customer customerimpl);

	public abstract Ticket getTicket();

	public abstract void setTicket(Ticket ticket);

	public int pay(int amount) {
		System.out.println("Payment of " + amount + " made for ticket");
		return amount;
	}

	@Override
	public String toString() {
		return "{" +
				" amount='" + getAmount() + "'" +
				" bundling='" + getBundling() + "'" +
				" ticket='" + getTicket() + "'" +
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
