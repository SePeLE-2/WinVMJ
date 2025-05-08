package TicketingSystem.payment.creditcard;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import TicketingSystem.payment.core.PaymentResourceDecorator;
import TicketingSystem.payment.core.PaymentImpl;
import TicketingSystem.payment.core.PaymentResourceComponent;

public class PaymentResourceImpl extends PaymentResourceDecorator {
    public PaymentResourceImpl (PaymentResourceComponent record) {
        super(record);
    }

    
    @Route(url="call/creditcard/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		PaymentCreditCard paymentcreditcard = createPaymentCreditCard(vmjExchange);
		paymentcreditcardRepository.saveObject(paymentcreditcard);
		return getAllPaymentCreditCard(vmjExchange);
	}

    public Payment createPaymentCreditCard(VMJExchange vmjExchange){
		
		PaymentCreditCard paymentcreditcard = record.createPaymentCreditCard(vmjExchange);
		PaymentCreditCard paymentcreditcarddeco = PaymentCreditCardFactory.createPaymentCreditCard("TicketingSystem.creditcard.core.PaymentImpl", paymentcreditcard, amount, bundlingimpl, ticketimpl
		);
			return paymentcreditcarddeco;
	}


    public Payment createPaymentCreditCard(VMJExchange vmjExchange, int id){
		PaymentCreditCard paymentcreditcard = paymentcreditcardRepository.getObject(id);
		int recordPaymentCreditCardId = (((PaymentCreditCardDecorator) savedPaymentCreditCard.getRecord()).getId();
		
		PaymentCreditCard paymentcreditcard = record.createPaymentCreditCard(vmjExchange);
		PaymentCreditCard paymentcreditcarddeco = PaymentCreditCardFactory.createPaymentCreditCard("TicketingSystem.creditcard.core.PaymentImpl", id, paymentcreditcard, amount, bundlingimpl, ticketimpl
		);
			return paymentcreditcarddeco;
	}

	
    @Route(url="call/creditcard/update")
    public HashMap<String, Object> updatePaymentCreditCard(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		PaymentCreditCard paymentcreditcard = paymentcreditcardRepository.getObject(id);
		paymentcreditcard = createPaymentCreditCard(vmjExchange, id);
		
		paymentcreditcardRepository.updateObject(paymentcreditcard);
		paymentcreditcard = paymentcreditcardRepository.getObject(id);
		//to do: fix association attributes
		
		return paymentcreditcard.toHashMap();
		
	}

	
    @Route(url="call/creditcard/detail")
    public HashMap<String, Object> getPaymentCreditCard(VMJExchange vmjExchange){
		return record.getPaymentCreditCard(vmjExchange);
	}

	
    @Route(url="call/creditcard/list")
    public List<HashMap<String,Object>> getAllPaymentCreditCard(VMJExchange vmjExchange){
		List<PaymentCreditCard> paymentcreditcardList = paymentcreditcardRepository.getAllObject("paymentcreditcard_impl");
		return transformPaymentCreditCardListToHashMap(paymentcreditcardList);
	}

    public List<HashMap<String,Object>> transformPaymentCreditCardListToHashMap(List<PaymentCreditCard> PaymentCreditCardList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < PaymentCreditCardList.size(); i++) {
            resultList.add(PaymentCreditCardList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/creditcard/delete")
    public List<HashMap<String,Object>> deletePaymentCreditCard(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		paymentcreditcardRepository.deleteObject(id);
		return getAllPaymentCreditCard(vmjExchange);
	}

	public void pay() {
		// TODO: implement this method
	}
	
}
