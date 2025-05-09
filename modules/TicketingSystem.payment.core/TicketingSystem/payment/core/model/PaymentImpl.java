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

	public PaymentImpl() { }

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

	@Override
	public int getAmount() {
		return this.amount;
	}
	
	@Override
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void pay() {
		System.out.println("Payment of " + amount + " made for ticket: " + ticketimpl.getTicketName());
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> paymentMap = new HashMap<String,Object>();
		paymentMap.put("amount",getAmount());
		paymentMap.put("bundlingimpl",getBundlingimpl());
		paymentMap.put("ticketimpl",getTicketimpl());

        return paymentMap;
    }

}
