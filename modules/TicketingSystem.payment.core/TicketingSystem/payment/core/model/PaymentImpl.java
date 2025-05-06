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


@Entity(name="payment_impl")
@Table(name="payment_impl")
public class PaymentImpl extends PaymentComponent {

	public PaymentImpl(int amount, BundlingImpl bundlingimpl, TicketImpl ticketimpl) {
		this.amount = amount;
		this.bundlingimpl = bundlingimpl;
		this.ticketimpl = ticketimpl;
	}

	public PaymentImpl(int amount, BundlingImpl bundlingimpl, TicketImpl ticketimpl) {
		this. =  .randomUUID();;
		this.amount = amount;
		this.bundlingimpl = bundlingimpl;
		this.ticketimpl = ticketimpl;
	}

	public PaymentImpl() { }


	public void pay() {
		// TODO: implement this method
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> paymentMap = new HashMap<String,Object>();
		paymentMap.put("amount",getAmount());
		paymentMap.put("bundlingimpl",getBundlingimpl());
		paymentMap.put("ticketimpl",getTicketimpl());

        return paymentMap;
    }

}
