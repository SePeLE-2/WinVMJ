package TicketingSystem.payment.core;

import java.util.*;
import TicketingSystem.bundling.core.BundlingImpl;
import TicketingSystem.ticket.core.Ticket;
import TicketingSystem.ticket.core.TicketImpl;
import TicketingSystem.payment.PaymentFactory;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import vmj.auth.annotations.Restricted;

public class PaymentServiceImpl extends PaymentServiceComponent {
	private Ticket ticketimpl;
	private BundlingImpl bundlingimpl;

	@Override
	public List<HashMap<String,Object>> savePayment(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) return null;

		Map<String, Object> requestBody = vmjExchange.getPayload();
		Payment payment = createPayment(requestBody);

		Repository.saveObject(payment);
		return getAllPayment(requestBody);
	}

	@Override
	public Payment createPayment(Map<String, Object> requestBody) {
		String amountStr = (String) requestBody.get("amount");
		int amount = Integer.parseInt(amountStr);

		BundlingImpl bundlingimpl = new BundlingImpl(); // TODO: retrieve from DB
		TicketImpl ticketimpl = new TicketImpl();       // TODO: retrieve from DB

		return PaymentFactory.createPayment(
			"TicketingSystem.payment.core.PaymentImpl",
			amount,
			bundlingimpl,
			ticketimpl
		);
	}

	@Override
	public Payment createPayment(Map<String, Object> requestBody, Map<String, Object> response) {
		return createPayment(requestBody);
	}

	@Override
	public List<HashMap<String,Object>> savePayment(Map<String, Object> requestBody) {
		Payment payment = createPayment(requestBody);
		Repository.saveObject(payment);
		return getAllPayment(requestBody);
	}

	public HashMap<String, Object> updatePayment(Map<String, Object> requestBody) {
		String idStr = (String) requestBody.get("id");
		UUID id = UUID.fromString(idStr);
		Payment payment = Repository.getObject(id);

		String amountStr = (String) requestBody.get("amount");
		payment.setAmount(Integer.parseInt(amountStr));

		Repository.updateObject(payment);
		return payment.toHashMap();
	}

	public HashMap<String, Object> getPayment(Map<String, Object> requestBody) {
		UUID id = UUID.fromString((String) requestBody.get("id"));

		Map<String, Object> temp = new HashMap<>();
		temp.put("table_name", "payment_impl");

		List<HashMap<String, Object>> paymentList = getAllPayment(temp);
		for (HashMap<String, Object> payment : paymentList) {
			UUID recordId = UUID.fromString((String) payment.get("record_id"));
			if (recordId.equals(id)) {
				return payment;
			}
		}
		return null;
	}

	public HashMap<String, Object> getPaymentById(UUID id) {
		Payment payment = Repository.getObject(id);
		return payment.toHashMap();
	}

	public List<HashMap<String,Object>> getAllPayment(Map<String, Object> requestBody) {
		String table = (String) requestBody.get("table_name");
		List<Payment> list = Repository.getAllObject(table);
		return transformListToHashMap(list);
	}

	public List<HashMap<String,Object>> transformListToHashMap(List<Payment> list) {
		List<HashMap<String,Object>> resultList = new ArrayList<>();
		for (Payment payment : list) {
			resultList.add(payment.toHashMap());
		}
		return resultList;
	}

	public List<HashMap<String,Object>> deletePayment(Map<String, Object> requestBody) {
		String idStr = (String) requestBody.get("id");
		UUID id = UUID.fromString(idStr);
		Repository.deleteObject(id);
		return getAllPayment(requestBody);
	}

	public void pay() {
		// TODO: implement
	}
}
