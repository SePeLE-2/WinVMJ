package TicketingSystem.bundling.core;

import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class BundlingServiceDecorator extends BundlingServiceComponent {
	protected BundlingServiceComponent record;

	public BundlingServiceDecorator(BundlingServiceComponent record) {
		this.record = record;
	}

	// public Bundling createBundling(Map<String, Object> requestBody){
	// return record.createBundling(requestBody);
	// }

	// public Bundling createBundling(Map<String, Object> requestBody, Map<String,
	// Object> response){
	// return record.createBundling(requestBody, response);
	// }

	public Bundling getBundling(UUID Id) {
		return record.getBundling(Id);
	}

	public List<Bundling> getAllBundling() {
		return record.getAllBundling();
	}

	public Bundling saveBundling(HashMap<String, Object> body, String email) {
		return record.saveBundling(body, email);
	}

	public Bundling updateBundling(Map<String, Object> requestBody) {
		return record.updateBundling(requestBody);
	}

	public List<HashMap<String, Object>> transformListToHashMap(List<Bundling> List) {
		return record.transformListToHashMap(List);
	}

	public List<Bundling> deleteBundling(UUID Id) {
		return record.deleteBundling(Id);
	}

	// public Bundling getBundlingById(int id) {
	// return record.getBundlingById(id);
	// }

	public void purchase() {
		record.purchase();
	}
}
