package TicketingSystem.bundling.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import TicketingSystem.bundling.BundlingFactory;
import vmj.auth.annotations.Restricted;
//add other required packages


public class BundlingResourceImpl extends BundlingResourceComponent{
	
	private BundlingServiceImpl bundlingServiceImpl = new BundlingServiceImpl();

	
    @Route(url="call/bundling/save")
    public List<HashMap<String,Object>> saveBundling(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Bundling bundling = createBundling(vmjExchange);
		bundlingRepository.saveObject(bundling);
		return getAllBundling(vmjExchange);
	}

	
    @Route(url="call/bundling")
    public HashMap<String,Object> bundling(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Bundling result = bundlingServiceImpl.createBundling(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Bundling createBundling(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Bundling result = bundlingServiceImpl.createBundling(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Bundling createBundling(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Bundling result = bundlingServiceImpl.createBundling(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/bundling/update")
    public HashMap<String, Object> updateBundling(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return bundlingServiceImpl.updateBundling(requestBody);
		
	}

	
    @Route(url="call/bundling/detail")
    public HashMap<String, Object> getBundling(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return bundlingServiceImpl.getBundling(requestBody);
	}

	
    @Route(url="call/bundling/list")
    public List<HashMap<String,Object>> getAllBundling(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return bundlingServiceImpl.getAllBundling(requestBody);
	}

	
    @Route(url="call/bundling/delete")
    public List<HashMap<String,Object>> deleteBundling(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return bundlingServiceImpl.deleteBundling(requestBody);
	}


	
	protected void purchase() {
		// TODO: implement this method
	}
}
