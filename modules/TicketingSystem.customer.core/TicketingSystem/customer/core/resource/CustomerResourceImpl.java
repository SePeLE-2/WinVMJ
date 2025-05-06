package TicketingSystem.customer.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import TicketingSystem.customer.CustomerFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class CustomerResourceImpl extends CustomerResourceComponent{
	
	private CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/customer/save")
    public List<HashMap<String,Object>> saveCustomer(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Customer customer = createCustomer(vmjExchange);
		customerRepository.saveObject(customer);
		return getAllCustomer(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/customer")
    public HashMap<String,Object> customer(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Customer result = customerServiceImpl.createCustomer(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Customer createCustomer(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Customer result = customerServiceImpl.createCustomer(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Customer createCustomer(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Customer result = customerServiceImpl.createCustomer(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/customer/update")
    public HashMap<String, Object> updateCustomer(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return customerServiceImpl.updateCustomer(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/customer/detail")
    public HashMap<String, Object> getCustomer(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return customerServiceImpl.getCustomer(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/customer/list")
    public List<HashMap<String,Object>> getAllCustomer(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return customerServiceImpl.getAllCustomer(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/customer/delete")
    public List<HashMap<String,Object>> deleteCustomer(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return customerServiceImpl.deleteCustomer(requestBody);
	}


}
