package TicketingSystem.payment.core;
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
import TicketingSystem.payment.PaymentFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class PaymentServiceImpl extends PaymentServiceComponent{

    public List<HashMap<String,Object>> savePayment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Payment payment = createPayment(vmjExchange);
		paymentRepository.saveObject(payment);
		return getAllPayment(vmjExchange);
	}

    public Payment createPayment(Map<String, Object> requestBody){
		String amountStr = (String) requestBody.get("amount");
		int amount = Integer.parseInt(amountStr);
		
		//to do: fix association attributes
		Payment Payment = PaymentFactory.createPayment(
			"TicketingSystem.payment.core.PaymentImpl",
		amount
		, bundlingimpl
		, ticketimpl
		);
		Repository.saveObject(payment);
		return payment;
	}

    public Payment createPayment(Map<String, Object> requestBody, int id){
		String amountStr = (String) vmjExchange.getRequestBodyForm("amount");
		int amount = Integer.parseInt(amountStr);
		
		//to do: fix association attributes
		
		Payment payment = PaymentFactory.createPayment("TicketingSystem.payment.core.PaymentImpl", amount, bundlingimpl, ticketimpl);
		return payment;
	}

    public HashMap<String, Object> updatePayment(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("");
		int id = Integer.parseInt(idStr);
		Payment payment = Repository.getObject(id);
		
		String amountStr = (String) requestBody.get("amount");
		payment.setAmount(Integer.parseInt(amountStr));
		
		Repository.updateObject(payment);
		
		//to do: fix association attributes
		
		return payment.toHashMap();
		
	}

    public HashMap<String, Object> getPayment(Map<String, Object> requestBody){
		List<HashMap<String, Object>> paymentList = getAllPayment("payment_impl");
		for (HashMap<String, Object> payment : paymentList){
			int record_id = ((Double) payment.get("record_id")).intValue();
			if (record_id == id){
				return payment;
			}
		}
		return null;
	}

	public HashMap<String, Object> getPaymentById(int id){
		String idStr = vmjExchange.getGETParam(""); 
		int id = Integer.parseInt(idStr);
		Payment payment = paymentRepository.getObject(id);
		return payment.toHashMap();
	}

    public List<HashMap<String,Object>> getAllPayment(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Payment> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Payment> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deletePayment(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllPayment(requestBody);
	}

	public void pay() {
		// TODO: implement this method
	}
}
