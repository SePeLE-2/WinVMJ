package TicketingSystem.customer.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="customer_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CustomerComponent implements Customer{
	@Id
	protected int id; 
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String phoneNumber;
	@ManyToOne(targetEntity=TicketingSystem.payment.core.PaymentComponent.class)
	public Payment paymentimpl;
	protected String objectName = CustomerComponent.class.getName();

	public CustomerComponent() {

	} 

	public CustomerComponent(
        int id, String firstName, String lastName, String email, String phoneNumber, PaymentImpl paymentimpl
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.paymentimpl = paymentimpl;
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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
	public abstract PaymentImpl getPaymentimpl();
	public abstract void setPaymentimpl(PaymentImpl paymentimpl);
	
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " firstName='" + getFirstName() + "'" +
            " lastName='" + getLastName() + "'" +
            " email='" + getEmail() + "'" +
            " phoneNumber='" + getPhoneNumber() + "'" +
            " paymentimpl='" + getPaymentimpl() + "'" +
            "}";
    }
	
}
