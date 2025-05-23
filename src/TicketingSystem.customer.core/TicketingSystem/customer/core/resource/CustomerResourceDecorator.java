package TicketingSystem.customer.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class CustomerResourceDecorator extends CustomerResourceComponent{
	protected CustomerResourceComponent record;

    public CustomerResourceDecorator(CustomerResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveCustomer(VMJExchange vmjExchange){
		return record.saveCustomer(vmjExchange);
	}

    public Customer createCustomer(VMJExchange vmjExchange){
		return record.createCustomer(vmjExchange);
	}

    public Customer createCustomer(VMJExchange vmjExchange, int id){
		return record.createCustomer(vmjExchange, id);
	}

    public HashMap<String, Object> updateCustomer(VMJExchange vmjExchange){
		return record.updateCustomer(vmjExchange);
	}

    public HashMap<String, Object> getCustomer(VMJExchange vmjExchange){
		return record.getCustomer(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllCustomer(VMJExchange vmjExchange){
		return record.getAllCustomer(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteCustomer(VMJExchange vmjExchange){
		return record.deleteCustomer(vmjExchange);
	}

}
