package TicketingSystem.customer.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface CustomerService {
	Customer createCustomer(Map<String, Object> requestBody);
	Customer createCustomer(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getCustomer(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveCustomer(Map<String, Object> requestBody);
    HashMap<String, Object> updateCustomer(Map<String, Object> requestBody);
    HashMap<String, Object> getCustomerById(int id);
    List<HashMap<String,Object>> getAllCustomer(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteCustomer(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Customer> List);
}
