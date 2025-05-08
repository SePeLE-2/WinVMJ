package TicketingSystem.bundling.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import TicketingSystem.bundling.BundlingFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

public class BundlingServiceImpl extends BundlingServiceComponent{

    public List<HashMap<String,Object>> saveBundling(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Bundling bundling = createBundling(vmjExchange);
		bundlingRepository.saveObject(bundling);
		return getAllBundling(vmjExchange);
	}

    public Bundling createBundling(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id");
		int id = Integer.parseInt(idStr);
		String bundlingName = (String) requestBody.get("bundlingName");
		String priceStr = (String) requestBody.get("price");
		int price = Integer.parseInt(priceStr);
		String availabilityStr = (String) requestBody.get("availability");
		int availability = Integer.parseInt(availabilityStr);
		
		//to do: fix association attributes
		Bundling Bundling = BundlingFactory.createBundling(
			"TicketingSystem.bundling.core.BundlingImpl",
		id
		, bundlingName
		, price
		, availability
		, ticketimpl
		);
		Repository.saveObject(bundling);
		return bundling;
	}

    public Bundling createBundling(Map<String, Object> requestBody, int id){
		String bundlingName = (String) vmjExchange.getRequestBodyForm("bundlingName");
		String priceStr = (String) vmjExchange.getRequestBodyForm("price");
		int price = Integer.parseInt(priceStr);
		String availabilityStr = (String) vmjExchange.getRequestBodyForm("availability");
		int availability = Integer.parseInt(availabilityStr);
		
		//to do: fix association attributes
		
		Bundling bundling = BundlingFactory.createBundling("TicketingSystem.bundling.core.BundlingImpl", bundlingName, price, availability, ticketimpl);
		return bundling;
	}

    public HashMap<String, Object> updateBundling(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id");
		int id = Integer.parseInt(idStr);
		Bundling bundling = Repository.getObject(id);
		
		bundling.setBundlingName((String) requestBody.get("bundlingName"));
		String priceStr = (String) requestBody.get("price");
		bundling.setPrice(Integer.parseInt(priceStr));
		String availabilityStr = (String) requestBody.get("availability");
		bundling.setAvailability(Integer.parseInt(availabilityStr));
		
		Repository.updateObject(bundling);
		
		//to do: fix association attributes
		
		return bundling.toHashMap();
		
	}

    public HashMap<String, Object> getBundling(Map<String, Object> requestBody){
		List<HashMap<String, Object>> bundlingList = getAllBundling("bundling_impl");
		for (HashMap<String, Object> bundling : bundlingList){
			int record_id = ((Double) bundling.get("record_id")).intValue();
			if (record_id == id){
				return bundling;
			}
		}
		return null;
	}

	public HashMap<String, Object> getBundlingById(int id){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		Bundling bundling = bundlingRepository.getObject(id);
		return bundling.toHashMap();
	}

    public List<HashMap<String,Object>> getAllBundling(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Bundling> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Bundling> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteBundling(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllBundling(requestBody);
	}

	protected void purchase() {
		// TODO: implement this method
	}
}
