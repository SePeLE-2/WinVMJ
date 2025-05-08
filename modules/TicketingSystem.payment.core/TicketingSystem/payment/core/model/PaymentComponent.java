package TicketingSystem.payment.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="payment_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PaymentComponent implements Payment{
	@Id
	
	public int amount;
	@ManyToOne(targetEntity=TicketingSystem..core.Component.class)
	public  bundlingimpl;
	@ManyToOne(targetEntity=TicketingSystem..core.Component.class)
	public  ticketimpl;
	protected String objectName = PaymentComponent.class.getName();

	public PaymentComponent() {

	} 

	public PaymentComponent(
        int amount, BundlingImpl bundlingimpl, TicketImpl ticketimpl
    ) {
        this.amount = amount;
        this.bundlingimpl = bundlingimpl;
        this.ticketimpl = ticketimpl;
    }

	public abstract int getAmount();
	public abstract void setAmount(int amount);
	
	public abstract BundlingImpl getBundlingimpl();
	public abstract void setBundlingimpl(BundlingImpl bundlingimpl);
	
	public abstract TicketImpl getTicketimpl();
	public abstract void setTicketimpl(TicketImpl ticketimpl);
	
 
	public abstract void pay();

	@Override
    public String toString() {
        return "{" +
            " amount='" + getAmount() + "'" +
            " bundlingimpl='" + getBundlingimpl() + "'" +
            " ticketimpl='" + getTicketimpl() + "'" +
            "}";
    }
	
}
