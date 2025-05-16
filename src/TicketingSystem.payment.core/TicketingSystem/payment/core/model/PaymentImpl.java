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
import TicketingSystem.bundling.core.BundlingImpl;
import TicketingSystem.ticket.core.TicketImpl;

@Entity(name="payment_impl")
@Table(name="payment_impl")
public class PaymentImpl extends PaymentComponent {

	public PaymentImpl(int amount, BundlingImpl bundlingimpl, TicketImpl ticketimpl) {
		this.id = UUID.randomUUID();
		this.amount = amount;
		this.bundlingimpl = bundlingimpl;
		this.ticketimpl = ticketimpl;
	}

	public PaymentImpl(UUID id, int amount, BundlingImpl bundlingimpl, TicketImpl ticketimpl) {
		this.id = id;
		this.amount = amount;
		this.bundlingimpl = bundlingimpl;
		this.ticketimpl = ticketimpl;
	}

	public PaymentImpl() { 
		this.id = UUID.randomUUID();
		this.amount = 0;
		this.bundlingimpl = null;
		this.ticketimpl = null;
	}
}
