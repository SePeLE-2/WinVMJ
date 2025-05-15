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

	@Route(url = "call/payment")
	public HashMap<String, Object> payment(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("POST")) {
			Map<String, Object> requestBody = vmjExchange.getPayload();
			Payment result = paymentServiceImpl.createPayment(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	@Route(url = "call/creditcard/save")
	public List<HashMap<String, Object>> save(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Payment paymentcreditcard = createPaymentCreditcard(vmjExchange);
		Repository.saveObject(paymentcreditcard);
		return getAllPaymentCreditcard(vmjExchange);
	}

	public Payment createPaymentCreditcard(VMJExchange vmjExchange) {
		Payment paymentcreditcard = record.createPayment(vmjExchange);

		String amountStr = (String) vmjExchange.getRequestBodyForm("amount");
		int amount = Integer.parseInt(amountStr);

		BundlingImpl bundlingimpl = new BundlingImpl(); // TODO: retrieve from DB
		TicketImpl ticketimpl = new TicketImpl(); // TODO: retrieve from DB

		Payment paymentcreditcarddeco = PaymentFactory.createPayment(
				"TicketingSystem.creditcard.core.PaymentImpl", paymentcreditcard, amount, bundlingimpl, ticketimpl);
		return paymentcreditcarddeco;
	}

	public Payment createPaymentCreditcard(VMJExchange vmjExchange, int id) {
		Payment paymentcreditcard = Repository.getObject(id);
		// int recordPaymentCreditcardId = (((PaymentDecorator)
		// paymentCreditcard.getRecord()).getId());

		String amountStr = (String) vmjExchange.getRequestBodyForm("amount");
		int amount = Integer.parseInt(amountStr);
		// int recordPaymentCreditcardId = (((PaymentDecorator)
		// savedPaymentCreditcard.getRecord()).getId());

		// PaymentCreditcard paymentcreditcard =
		// record.createPaymentCreditcard(vmjExchange);
		BundlingImpl bundlingimpl = new BundlingImpl(); // TODO: retrieve from DB
		TicketImpl ticketimpl = new TicketImpl(); // TODO: retrieve from DB

		Payment paymentcreditcarddeco = PaymentFactory.createPayment(
				"TicketingSystem.creditcard.core.PaymentImpl", id, paymentcreditcard, amount, bundlingimpl, ticketimpl);
		return paymentcreditcarddeco;
	}

	@Route(url = "call/creditcard/update")
	public HashMap<String, Object> updatePaymentCreditcard(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);

		Payment paymentcreditcard = Repository.getObject(id);
		paymentcreditcard = createPaymentCreditcard(vmjExchange, id);

		Repository.updateObject(paymentcreditcard);
		paymentcreditcard = Repository.getObject(id);
		// to do: fix association attributes

		return paymentcreditcard.toHashMap();

	}

	@Route(url = "call/creditcard/detail")
	public HashMap<String, Object> getPaymentCreditcard(VMJExchange vmjExchange) {
		return record.getPayment(vmjExchange);
	}

	@Route(url = "call/creditcard/list")
	public List<HashMap<String, Object>> getAllPaymentCreditcard(VMJExchange vmjExchange) {
		List<Payment> paymentcreditcardList = Repository.getAllObject("paymentcreditcard_impl");
		return transformPaymentCreditcardListToHashMap(paymentcreditcardList);
	}

	public List<HashMap<String, Object>> transformPaymentCreditcardListToHashMap(List<Payment> PaymentCreditcardList) {
		List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < PaymentCreditcardList.size(); i++) {
			resultList.add(PaymentCreditcardList.get(i).toHashMap());
		}

		return resultList;
	}

	@Route(url = "call/creditcard/delete")
	public List<HashMap<String, Object>> deletePaymentCreditcard(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}

		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllPaymentCreditcard(vmjExchange);
	}

	public void pay() {
		// TODO: implement this method
		System.out.println("creditcard pay() called in service; this should ideally be in entity logic.");
	}

}
