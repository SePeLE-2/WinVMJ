package TicketingSystem.payment.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import TicketingSystem.bundling.core.*;
import TicketingSystem.ticket.core.*;

@Entity(name = "payment_impl")
@Table(name = "payment_impl")
public class PaymentImpl extends PaymentComponent {

	public PaymentImpl(int amount, Bundling bundlingimpl, Ticket ticketimpl) {
		this.id = UUID.randomUUID();
		this.amount = amount;
		this.bundling = bundlingimpl;
		this.ticket = ticketimpl;
	}

	public PaymentImpl(UUID id, int amount, Bundling bundlingimpl, Ticket ticketimpl) {
		this.id = id;
		this.amount = amount;
		this.bundling = bundlingimpl;
		this.ticket = ticketimpl;
	}

	public PaymentImpl() {
		this.id = UUID.randomUUID();
		this.amount = 0;
		this.bundling = null;
		this.ticket = null;
	}

	public Bundling getBundling() {
		return this.bundling;
	}

	public void setBundling(Bundling bundlingimpl) {
		this.bundling = bundlingimpl;
	}

	public Ticket getTicket() {
		return this.ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
}
