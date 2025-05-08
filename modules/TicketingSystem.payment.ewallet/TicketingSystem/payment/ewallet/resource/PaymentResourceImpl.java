package TicketingSystem.payment.ewallet;
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

    
    @Route(url="call/ewallet/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		PaymentEWallet paymentewallet = createPaymentEWallet(vmjExchange);
		paymentewalletRepository.saveObject(paymentewallet);
		return getAllPaymentEWallet(vmjExchange);
	}

    public Payment createPaymentEWallet(VMJExchange vmjExchange){
		
		PaymentEWallet paymentewallet = record.createPaymentEWallet(vmjExchange);
		PaymentEWallet paymentewalletdeco = PaymentEWalletFactory.createPaymentEWallet("TicketingSystem.ewallet.core.PaymentImpl", paymentewallet, amount, bundlingimpl, ticketimpl
		);
			return paymentewalletdeco;
	}


    public Payment createPaymentEWallet(VMJExchange vmjExchange, int id){
		PaymentEWallet paymentewallet = paymentewalletRepository.getObject(id);
		int recordPaymentEWalletId = (((PaymentEWalletDecorator) savedPaymentEWallet.getRecord()).getId();
		
		PaymentEWallet paymentewallet = record.createPaymentEWallet(vmjExchange);
		PaymentEWallet paymentewalletdeco = PaymentEWalletFactory.createPaymentEWallet("TicketingSystem.ewallet.core.PaymentImpl", id, paymentewallet, amount, bundlingimpl, ticketimpl
		);
			return paymentewalletdeco;
	}

	
    @Route(url="call/ewallet/update")
    public HashMap<String, Object> updatePaymentEWallet(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		PaymentEWallet paymentewallet = paymentewalletRepository.getObject(id);
		paymentewallet = createPaymentEWallet(vmjExchange, id);
		
		paymentewalletRepository.updateObject(paymentewallet);
		paymentewallet = paymentewalletRepository.getObject(id);
		//to do: fix association attributes
		
		return paymentewallet.toHashMap();
		
	}

	
    @Route(url="call/ewallet/detail")
    public HashMap<String, Object> getPaymentEWallet(VMJExchange vmjExchange){
		return record.getPaymentEWallet(vmjExchange);
	}

	
    @Route(url="call/ewallet/list")
    public List<HashMap<String,Object>> getAllPaymentEWallet(VMJExchange vmjExchange){
		List<PaymentEWallet> paymentewalletList = paymentewalletRepository.getAllObject("paymentewallet_impl");
		return transformPaymentEWalletListToHashMap(paymentewalletList);
	}

    public List<HashMap<String,Object>> transformPaymentEWalletListToHashMap(List<PaymentEWallet> PaymentEWalletList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < PaymentEWalletList.size(); i++) {
            resultList.add(PaymentEWalletList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/ewallet/delete")
    public List<HashMap<String,Object>> deletePaymentEWallet(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		paymentewalletRepository.deleteObject(id);
		return getAllPaymentEWallet(vmjExchange);
	}

	public void pay() {
		// TODO: implement this method
	}
	
}
