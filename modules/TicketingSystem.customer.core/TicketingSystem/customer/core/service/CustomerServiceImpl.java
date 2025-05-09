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
import TicketingSystem.payment.core.Payment;
import vmj.auth.annotations.Restricted;
//add other required packages
import TicketingSystem.payment.core.PaymentImpl;

public class CustomerServiceImpl extends CustomerServiceComponent {

	@Override
	public List<HashMap<String, Object>> saveCustomer(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		// Customer customer = createCustomer(vmjExchange);

		Map<String, Object> requestBody = vmjExchange.getPayload();
		Customer customer = createCustomer(requestBody);
		Repository.saveObject(customer);
		return getAllCustomer(requestBody);
	}

	public Customer createCustomer(Map<String, Object> requestBody) {
		String idStr = (String) requestBody.get("id");
		int id = Integer.parseInt(idStr);
		String firstName = (String) requestBody.get("firstName");
		String lastName = (String) requestBody.get("lastName");
		String email = (String) requestBody.get("email");
		String phoneNumber = (String) requestBody.get("phoneNumber");
		Payment paymentimpl = new PaymentImpl();

		// to do: fix association attributes
		Customer customer = CustomerFactory.createCustomer(
				"TicketingSystem.customer.core.CustomerImpl",
				id, firstName, lastName, email, phoneNumber, paymentimpl);
		Repository.saveObject(customer);
		return customer;
	}

	public Customer createCustomer(Map<String, Object> requestBody, Map<String, Object> response) {
		return createCustomer(requestBody);
	}

	// public Customer createCustomer(Map<String, Object> requestBody, int id) {
	// 	String firstName = (String) vmjExchange.getRequestBodyForm("firstName");
	// 	String lastName = (String) vmjExchange.getRequestBodyForm("lastName");
	// 	String email = (String) vmjExchange.getRequestBodyForm("email");
	// 	String phoneNumber = (String) vmjExchange.getRequestBodyForm("phoneNumber");
	// 	Payment paymentimpl = new PaymentImpl();

	// 	// to do: fix association attributes

	// 	Customer customer = CustomerFactory.createCustomer(
	// 			"TicketingSystem.customer.core.CustomerImpl",
	// 			firstName, lastName, email, phoneNumber, paymentimpl);
	// 	return customer;
	// }

	public HashMap<String, Object> updateCustomer(Map<String, Object> requestBody) {
		String idStr = (String) requestBody.get("id");
		int id = Integer.parseInt(idStr);
		Customer customer = Repository.getObject(id);

		customer.setFirstName((String) requestBody.get("firstName"));
		customer.setLastName((String) requestBody.get("lastName"));
		customer.setEmail((String) requestBody.get("email"));
		customer.setPhoneNumber((String) requestBody.get("phoneNumber"));

		Repository.updateObject(customer);

		// to do: fix association attributes

		return customer.toHashMap();

	}

	public HashMap<String, Object> getCustomer(Map<String, Object> requestBody) {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("table_name", "customer_impl");
		List<HashMap<String, Object>> customerList = getAllCustomer(map);
		for (HashMap<String, Object> customer : customerList) {
			int record_id = ((Double) customer.get("record_id")).intValue();
			if (customer.get("id").equals(record_id)) {
				return customer;
			}
		}
		return null;
	}

	public HashMap<String, Object> getCustomerById(UUID id) {
		// String idStr = vmjExchange.getGETParam("id");
		// int id = Integer.parseInt(idStr);
		Customer customer = Repository.getObject(id);
		return customer.toHashMap();
	}

	public List<HashMap<String, Object>> getAllCustomer(Map<String, Object> requestBody) {
		String table = (String) requestBody.get("table_name");
		List<Customer> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

	public List<HashMap<String, Object>> transformListToHashMap(List<Customer> List) {
		List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < List.size(); i++) {
			resultList.add(List.get(i).toHashMap());
		}

		return resultList;
	}

	public List<HashMap<String, Object>> deleteCustomer(Map<String, Object> requestBody) {
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllCustomer(requestBody);
	}

	public Customer getCustomerByName(String name) {
		Customer customer = null;
		try {
			customer = Repository.getListObject("customer_comp", "name", name).get(0);
		} catch (Exception e) {
			throw new NotFoundException("Event Organizer with name " + name + " not exist.");
		}
		return customer;
	}

}
