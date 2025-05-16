package TicketingSystem.payment.creditcard;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;

import TicketingSystem.payment.core.PaymentResourceDecorator;
import TicketingSystem.payment.core.PaymentImpl;
import TicketingSystem.payment.core.PaymentServiceImpl;
import TicketingSystem.payment.core.PaymentResourceComponent;
import TicketingSystem.payment.core.Payment;
import TicketingSystem.payment.PaymentFactory;
import TicketingSystem.payment.core.PaymentDecorator;

import TicketingSystem.ticket.core.TicketImpl;
import TicketingSystem.bundling.core.BundlingImpl;

public class PaymentResourceImpl extends PaymentResourceDecorator {
	private PaymentFactory PaymentFactory = new PaymentFactory();
	private PaymentServiceImpl paymentServiceImpl = new PaymentServiceImpl();

	public PaymentResourceImpl(PaymentResourceComponent record) {
		super(record);
	}

	@Route(url = "call/payment/creditcard/")
	public void pay() {
		// TODO: implement this method
		System.out.println("creditcard pay() called in service; this should ideally be in entity logic.");
	}

	@Route(url = "call/payment/save")
	public HashMap<String, Object> savePayment(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String email = vmjExchange.getAuthPayload().getEmail();
		Payment payment = paymentServiceImpl.savePayment((HashMap<String, Object>) vmjExchange.getPayload(), email);
		return payment.toHashMap();
	}

	@Route(url = "call/payment")
	public HashMap<String, Object> payment(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String email = vmjExchange.getAuthPayload().getEmail();
		Payment payment = paymentServiceImpl.savePayment((HashMap<String, Object>) vmjExchange.getPayload(), email);
		return payment.toHashMap();
	}

	@Route(url = "call/payment/update")
	public HashMap<String, Object> updatePayment(VMJExchange vmjExchange) {
		Map<String, Object> requestBody = vmjExchange.getPayload();
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return paymentServiceImpl.updatePayment(requestBody).toHashMap();
	}

	@Route(url = "call/payment/detail")
	public HashMap<String, Object> getPayment(VMJExchange vmjExchange) {
		String idStr = vmjExchange.getGETParam("id");
		UUID id = UUID.fromString(idStr);
		return paymentServiceImpl.getPayment(id).toHashMap();
	}

	@Route(url = "call/payment/list")
	public List<HashMap<String, Object>> getAllPayment(VMJExchange vmjExchange) {
		List<Payment> List = paymentServiceImpl.getAllPayment();
		return paymentServiceImpl.transformListToHashMap(List);
	}

	@Route(url = "call/payment/delete")
	public List<HashMap<String, Object>> deletePayment(VMJExchange vmjExchange) {
		Map<String, Object> requestBody = vmjExchange.getPayload();
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		HashMap<String, Object> body = (HashMap<String, Object>) vmjExchange.getPayload();
		String idStr = (String) body.get("id");
		UUID id = UUID.fromString(idStr);
		Payment payment = paymentRepository.getObject(id);
		List<Payment> List = paymentServiceImpl.deletePayment(id);
		return paymentServiceImpl.transformListToHashMap(List);
	}
}
