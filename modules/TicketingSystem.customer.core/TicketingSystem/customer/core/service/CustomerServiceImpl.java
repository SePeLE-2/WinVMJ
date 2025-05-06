package TicketingSystem.customer.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import TicketingSystem.customer.CustomerFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class CustomerServiceImpl extends CustomerServiceComponent{

    public List<HashMap<String,Object>> saveCustomer(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Customer customer = createCustomer(vmjExchange);
		customerRepository.saveObject(customer);
		return getAllCustomer(vmjExchange);
	}

    public Customer createCustomer(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id");
		int id = Integer.parseInt(idStr);
		String firstName = (String) requestBody.get("firstName");
		String lastName = (String) requestBody.get("lastName");
		String email = (String) requestBody.get("email");
		String phoneNumber = (String) requestBody.get("phoneNumber");
		
		//to do: fix association attributes
		Customer Customer = CustomerFactory.createCustomer(
			"TicketingSystem.customer.core.CustomerImpl",
		id
		, firstName
		, lastName
		, email
		, phoneNumber
		, paymentimpl
		);
		Repository.saveObject(customer);
		return customer;
	}

    public Customer createCustomer(Map<String, Object> requestBody, int id){
		String firstName = (String) vmjExchange.getRequestBodyForm("firstName");
		String lastName = (String) vmjExchange.getRequestBodyForm("lastName");
		String email = (String) vmjExchange.getRequestBodyForm("email");
		String phoneNumber = (String) vmjExchange.getRequestBodyForm("phoneNumber");
		
		//to do: fix association attributes
		
		Customer customer = CustomerFactory.createCustomer("TicketingSystem.customer.core.CustomerImpl", firstName, lastName, email, phoneNumber, paymentimpl);
		return customer;
	}

    public HashMap<String, Object> updateCustomer(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id");
		int id = Integer.parseInt(idStr);
		Customer customer = Repository.getObject(id);
		
		customer.setFirstName((String) requestBody.get("firstName"));
		customer.setLastName((String) requestBody.get("lastName"));
		customer.setEmail((String) requestBody.get("email"));
		customer.setPhoneNumber((String) requestBody.get("phoneNumber"));
		
		Repository.updateObject(customer);
		
		//to do: fix association attributes
		
		return customer.toHashMap();
		
	}

    public HashMap<String, Object> getCustomer(Map<String, Object> requestBody){
		List<HashMap<String, Object>> customerList = getAllCustomer("customer_impl");
		for (HashMap<String, Object> customer : customerList){
			int record_id = ((Double) customer.get("record_id")).intValue();
			if (record_id == id){
				return customer;
			}
		}
		return null;
	}

	public HashMap<String, Object> getCustomerById(int id){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		Customer customer = customerRepository.getObject(id);
		return customer.toHashMap();
	}

    public List<HashMap<String,Object>> getAllCustomer(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Customer> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Customer> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteCustomer(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllCustomer(requestBody);
	}

}
