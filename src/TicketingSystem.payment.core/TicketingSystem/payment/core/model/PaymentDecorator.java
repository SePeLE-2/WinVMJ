package TicketingSystem.payment.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class PaymentDecorator extends PaymentComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected PaymentComponent record;

	public PaymentDecorator () {
		super();
		this.record = record;
		this.id = UUID.randomUUID();
	}
		
	public PaymentDecorator (PaymentComponent record) {
		this.id = UUID.randomUUID();
		this.record = record;
	}
	
	public PaymentDecorator (PaymentComponent record, String objectName) {
		this.id = UUID.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public void pay() {
		System.out.println("Paying item");
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
