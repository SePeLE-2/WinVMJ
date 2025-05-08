package TicketingSystem.payment.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import TicketingSystem.payment.PaymentFactory;
import vmj.auth.annotations.Restricted;
//add other required packages


public class PaymentResourceImpl extends PaymentResourceComponent{
	
	private PaymentServiceImpl paymentServiceImpl = new PaymentServiceImpl();

	
    @Route(url="call/payment/save")
    public List<HashMap<String,Object>> savePayment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Payment payment = createPayment(vmjExchange);
		paymentRepository.saveObject(payment);
		return getAllPayment(vmjExchange);
	}

	
    @Route(url="call/payment")
    public HashMap<String,Object> payment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Payment result = paymentServiceImpl.createPayment(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Payment createPayment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Payment result = paymentServiceImpl.createPayment(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Payment createPayment(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Payment result = paymentServiceImpl.createPayment(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/payment/update")
    public HashMap<String, Object> updatePayment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return paymentServiceImpl.updatePayment(requestBody);
		
	}

	
    @Route(url="call/payment/detail")
    public HashMap<String, Object> getPayment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return paymentServiceImpl.getPayment(requestBody);
	}

	
    @Route(url="call/payment/list")
    public List<HashMap<String,Object>> getAllPayment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return paymentServiceImpl.getAllPayment(requestBody);
	}

	
    @Route(url="call/payment/delete")
    public List<HashMap<String,Object>> deletePayment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return paymentServiceImpl.deletePayment(requestBody);
	}


	
	public void pay() {
		// TODO: implement this method
	}
}
