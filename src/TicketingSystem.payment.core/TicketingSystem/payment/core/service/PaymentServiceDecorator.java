package TicketingSystem.payment.core;

import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class PaymentServiceDecorator extends PaymentServiceComponent {
	protected PaymentServiceComponent record;

	public PaymentServiceDecorator(PaymentServiceComponent record) {
		this.record = record;
	}

	// public Payment createPayment(Map<String, Object> requestBody){
	// return record.createPayment(requestBody);
	// }

	// public Payment createPayment(Map<String, Object> requestBody, Map<String,
	// Object> response){
	// return record.createPayment(requestBody, response);
	// }

	public Payment getPayment(UUID id) {
		return record.getPayment(id);
	}

	public List<Payment> getAllPayment() {
		return record.getAllPayment();
	}

	public Payment savePayment(HashMap<String, Object> body, String email) {
		return record.savePayment(body, email);
	}

	public Payment updatePayment(Map<String, Object> requestBody) {
		return record.updatePayment(requestBody);
	}

	public List<HashMap<String, Object>> transformListToHashMap(List<Payment> List) {
		return record.transformListToHashMap(List);
	}

	public List<Payment> deletePayment(UUID Id) {
		return record.deletePayment(Id);
	}

	// public HashMap<String, Object> getPaymentById(UUID id) {
	// return record.getPaymentById(id);
	// }

	public int pay(int amount) {
		return record.pay(amount);
	}
}
