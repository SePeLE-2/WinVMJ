package TicketingSystem.customer.core;

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

import TicketingSystem.payment.core.Payment;
import TicketingSystem.payment.core.PaymentImpl;


@Entity(name="customer_impl")
@Table(name="customer_impl")
public class CustomerImpl extends CustomerComponent {

	public CustomerImpl(UUID id, String firstName, String lastName, String email, String phoneNumber, PaymentImpl paymentimpl) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.paymentimpl = paymentimpl;
	}

	public CustomerImpl(String firstName, String lastName, String email, String phoneNumber, PaymentImpl paymentimpl) {
		this.id =  id.randomUUID();;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.paymentimpl = paymentimpl;
	}

	public CustomerImpl() { }

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PaymentImpl getPaymentimpl() {
		return this.paymentimpl;
	}

	public void setPaymentimpl(PaymentImpl paymentimpl) {
		this.paymentimpl = paymentimpl;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> customerMap = new HashMap<String,Object>();
		customerMap.put("id",getId());
		customerMap.put("firstName",getFirstName());
		customerMap.put("lastName",getLastName());
		customerMap.put("email",getEmail());
		customerMap.put("phoneNumber",getPhoneNumber());
		customerMap.put("paymentimpl",getPaymentimpl());

        return customerMap;
    }

}
