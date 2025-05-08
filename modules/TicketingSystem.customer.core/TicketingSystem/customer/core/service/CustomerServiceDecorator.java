package TicketingSystem.customer.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class CustomerServiceDecorator extends CustomerServiceComponent{
	protected CustomerServiceComponent record;

    public CustomerServiceDecorator(CustomerServiceComponent record) {
        this.record = record;
    }

	public CustomerImpl createCustomer(Map<String, Object> requestBody){
		return record.createCustomer(requestBody);
	}

    public Customer createCustomer(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createCustomer(requestBody, response);
	}

	public HashMap<String, Object> getCustomer(Map<String, Object> requestBody){
		return record.getCustomer(requestBody);
	}

	public List<HashMap<String,Object>> getAllCustomer(Map<String, Object> requestBody){
		return record.getAllCustomer(requestBody);
	}

    public List<HashMap<String,Object>> saveCustomer(VMJExchange vmjExchange){
		return record.saveCustomer(vmjExchange);
	}

    public HashMap<String, Object> updateCustomer(Map<String, Object> requestBody){
		return record.updateCustomer(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Customer> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteCustomer(Map<String, Object> requestBody){
		return record.deleteCustomer(requestBody);
	}

	public HashMap<String, Object> getCustomerById(int id){
        return record.getCustomerById(id);
    }

}
