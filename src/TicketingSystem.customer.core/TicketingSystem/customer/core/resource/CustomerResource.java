package TicketingSystem.customer.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface CustomerResource {
    List<HashMap<String,Object>> saveCustomer(VMJExchange vmjExchange);
    HashMap<String, Object> updateCustomer(VMJExchange vmjExchange);
    HashMap<String, Object> getCustomer(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllCustomer(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteCustomer(VMJExchange vmjExchange);
	HashMap<String, Object> Customer(VMJExchange vmjExhange);
}
