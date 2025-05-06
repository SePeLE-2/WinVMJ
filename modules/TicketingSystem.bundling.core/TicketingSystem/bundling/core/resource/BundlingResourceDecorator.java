package TicketingSystem.bundling.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class BundlingResourceDecorator extends BundlingResourceComponent{
	protected BundlingResourceComponent record;

    public BundlingResourceDecorator(BundlingResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveBundling(VMJExchange vmjExchange){
		return record.saveBundling(vmjExchange);
	}

    public Bundling createBundling(VMJExchange vmjExchange){
		return record.createBundling(vmjExchange);
	}

    public Bundling createBundling(VMJExchange vmjExchange, int id){
		return record.createBundling(vmjExchange, id);
	}

    public HashMap<String, Object> updateBundling(VMJExchange vmjExchange){
		return record.updateBundling(vmjExchange);
	}

    public HashMap<String, Object> getBundling(VMJExchange vmjExchange){
		return record.getBundling(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllBundling(VMJExchange vmjExchange){
		return record.getAllBundling(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteBundling(VMJExchange vmjExchange){
		return record.deleteBundling(vmjExchange);
	}

	protected void purchase() {
		return record.purchase();
	}
}
