package TicketingSystem.bundling.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface BundlingService {
	Bundling createBundling(Map<String, Object> requestBody);
	Bundling createBundling(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getBundling(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveBundling(Map<String, Object> requestBody);
    HashMap<String, Object> updateBundling(Map<String, Object> requestBody);
    HashMap<String, Object> getBundlingById(int id);
    List<HashMap<String,Object>> getAllBundling(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteBundling(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
