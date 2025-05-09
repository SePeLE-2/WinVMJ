package TicketingSystem.customer.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Customer {
	HashMap<String, Object> toHashMap();
	void setId(UUID id);
	void setFirstName(String firstName);
	void setLastName(String lastName);
	void setEmail(String email);
	void setPhoneNumber(String phoneNumber);
}
