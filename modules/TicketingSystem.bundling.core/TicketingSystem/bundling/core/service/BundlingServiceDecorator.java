package TicketingSystem.bundling.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class BundlingServiceDecorator extends BundlingServiceComponent{
	protected BundlingServiceComponent record;

    public BundlingServiceDecorator(BundlingServiceComponent record) {
        this.record = record;
    }

	public BundlingImpl createBundling(Map<String, Object> requestBody){
		return record.createBundling(requestBody);
	}

    public Bundling createBundling(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createBundling(requestBody, response);
	}

	public HashMap<String, Object> getBundling(Map<String, Object> requestBody){
		return record.getBundling(requestBody);
	}

	public List<HashMap<String,Object>> getAllBundling(Map<String, Object> requestBody){
		return record.getAllBundling(requestBody);
	}

    public List<HashMap<String,Object>> saveBundling(VMJExchange vmjExchange){
		return record.saveBundling(vmjExchange);
	}

    public HashMap<String, Object> updateBundling(Map<String, Object> requestBody){
		return record.updateBundling(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Bundling> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteBundling(Map<String, Object> requestBody){
		return record.deleteBundling(requestBody);
	}

	public HashMap<String, Object> getBundlingById(int id){
        return record.getBundlingById(id);
    }

	protected void purchase() {
		return record.purchase();
	}
}
