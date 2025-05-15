package TicketingSystem.payment.ewallet;

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

	@Route(url = "call/ewallet/save")
	public List<HashMap<String, Object>> save(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Payment paymentewallet = createPaymentEWallet(vmjExchange);
		Repository.saveObject(paymentewallet);
		return getAllPaymentEWallet(vmjExchange);
	}

	public Payment createPaymentEWallet(VMJExchange vmjExchange) {
		Payment paymentewallet = record.createPayment(vmjExchange);

		String amountStr = (String) vmjExchange.getRequestBodyForm("amount");
		int amount = Integer.parseInt(amountStr);

		BundlingImpl bundlingimpl = new BundlingImpl(); // TODO: retrieve from DB
		TicketImpl ticketimpl = new TicketImpl(); // TODO: retrieve from DB

		Payment paymentewalletdeco = PaymentFactory.createPayment(
				"TicketingSystem.ewallet.core.PaymentImpl", paymentewallet, amount, bundlingimpl, ticketimpl);
		return paymentewalletdeco;
	}

	public Payment createPaymentEWallet(VMJExchange vmjExchange, int id) {
		Payment paymentewallet = Repository.getObject(id);
		// int recordPaymentEWalletId = (((PaymentDecorator)
		// paymentEWallet.getRecord()).getId());

		String amountStr = (String) vmjExchange.getRequestBodyForm("amount");
		int amount = Integer.parseInt(amountStr);
		// int recordPaymentEWalletId = (((PaymentDecorator)
		// savedPaymentEWallet.getRecord()).getId());

		// PaymentEWallet paymentewallet = record.createPaymentEWallet(vmjExchange);
		BundlingImpl bundlingimpl = new BundlingImpl(); // TODO: retrieve from DB
		TicketImpl ticketimpl = new TicketImpl(); // TODO: retrieve from DB

		Payment paymentewalletdeco = PaymentFactory.createPayment(
				"TicketingSystem.ewallet.core.PaymentImpl", id, paymentewallet, amount, bundlingimpl, ticketimpl);
		return paymentewalletdeco;
	}

	@Route(url = "call/ewallet/update")
	public HashMap<String, Object> updatePaymentEWallet(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);

		Payment paymentewallet = Repository.getObject(id);
		paymentewallet = createPaymentEWallet(vmjExchange, id);

		Repository.updateObject(paymentewallet);
		paymentewallet = Repository.getObject(id);
		// to do: fix association attributes

		return paymentewallet.toHashMap();

	}

	@Route(url = "call/ewallet/detail")
	public HashMap<String, Object> getPaymentEWallet(VMJExchange vmjExchange) {
		return record.getPayment(vmjExchange);
	}

	@Route(url = "call/ewallet/list")
	public List<HashMap<String, Object>> getAllPaymentEWallet(VMJExchange vmjExchange) {
		List<Payment> paymentewalletList = Repository.getAllObject("paymentewallet_impl");
		return transformPaymentEWalletListToHashMap(paymentewalletList);
	}

	public List<HashMap<String, Object>> transformPaymentEWalletListToHashMap(List<Payment> PaymentEWalletList) {
		List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < PaymentEWalletList.size(); i++) {
			resultList.add(PaymentEWalletList.get(i).toHashMap());
		}

		return resultList;
	}

	@Route(url = "call/ewallet/delete")
	public List<HashMap<String, Object>> deletePaymentEWallet(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}

		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllPaymentEWallet(vmjExchange);
	}

	public void pay() {
		// TODO: implement this method
		System.out.println("ewallet pay() called in service; this should ideally be in entity logic.");
	}
}
