package TicketingSystem.customer.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class CustomerDecorator extends CustomerComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected CustomerComponent record;

	public CustomerDecorator () {
		super();
		this.record = record;
		this.id =  id.randomUUID();
	}
		
	public CustomerDecorator (CustomerComponent record) {
		this.id =  id.randomUUID();
		this.record = record;
	}

	public CustomerDecorator (int id, CustomerComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public CustomerDecorator (CustomerComponent record, String objectName) {
		this.id =  id.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}


	public int getId() {
		return record.getId();
	}
	public void setId(int id) {
		record.setId(id);
	}
	public String getFirstName() {
		return record.getFirstName();
	}
	public void setFirstName(String firstName) {
		record.setFirstName(firstName);
	}
	public String getLastName() {
		return record.getLastName();
	}
	public void setLastName(String lastName) {
		record.setLastName(lastName);
	}
	public String getEmail() {
		return record.getEmail();
	}
	public void setEmail(String email) {
		record.setEmail(email);
	}
	public String getPhoneNumber() {
		return record.getPhoneNumber();
	}
	public void setPhoneNumber(String phoneNumber) {
		record.setPhoneNumber(phoneNumber);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
