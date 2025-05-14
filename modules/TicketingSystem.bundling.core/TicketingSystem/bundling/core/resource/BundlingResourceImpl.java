package TicketingSystem.bundling.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import TicketingSystem.bundling.BundlingFactory;
import TicketingSystem.bundling.core.BundlingService;
import vmj.auth.annotations.Restricted;
//add other required packages

public class BundlingResourceImpl extends BundlingResourceComponent {

	private BundlingServiceImpl bundlingServiceImpl = new BundlingServiceImpl();

	@Route(url = "call/bundling/save")
	public HashMap<String, Object> saveBundling(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String email = vmjExchange.getAuthPayload().getEmail();
		Bundling bundling = bundlingServiceImpl.saveBundling((HashMap<String, Object>) vmjExchange.getPayload(), email);
		return bundling.toHashMap();
	}

	@Override
	@Route(url = "call/bundling")
	public HashMap<String, Object> Bundling(VMJExchange vmjExchange) {
		// if (vmjExchange.getHttpMethod().equals("POST")) {
		// Map<String, Object> requestBody = vmjExchange.getPayload();
		// Bundling result = bundlingServiceImpl.saveBundling(requestBody);
		// return result.toHashMap();
		// }
		// throw new NotFoundException("Route tidak ditemukan");
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String email = vmjExchange.getAuthPayload().getEmail();
		Bundling bundling = bundlingServiceImpl.saveBundling((HashMap<String, Object>) vmjExchange.getPayload(), email);
		return bundling.toHashMap();
	}

	@Route(url = "call/bundling/update")
	public HashMap<String, Object> updateBundling(VMJExchange vmjExchange) {
		Map<String, Object> requestBody = vmjExchange.getPayload();
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return bundlingServiceImpl.updateBundling(requestBody).toHashMap();
	}

	@Route(url = "call/bundling/detail")
	public HashMap<String, Object> getBundling(VMJExchange vmjExchange) {
		String idStr = vmjExchange.getGETParam("id");
		UUID id = UUID.fromString(idStr);
		return bundlingServiceImpl.getBundling(id).toHashMap();
	}

	@Route(url = "call/bundling/list")
	public List<HashMap<String, Object>> getAllBundling(VMJExchange vmjExchange) {
		List<Bundling> bundlingList = bundlingServiceImpl.getAllBundling();
		return bundlingServiceImpl.transformListToHashMap(bundlingList);
	}

	@Route(url = "call/bundling/delete")
	public List<HashMap<String, Object>> deleteBundling(VMJExchange vmjExchange) {
		Map<String, Object> requestBody = vmjExchange.getPayload();
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		HashMap<String, Object> body = (HashMap<String, Object>) vmjExchange.getPayload();
		String idStr = (String) body.get("id");
		UUID id = UUID.fromString(idStr);
		Bundling bundling = bundlingRepository.getObject(id);
		List<Bundling> bundlingList = bundlingServiceImpl.deleteBundling(id);
		return bundlingServiceImpl.transformListToHashMap(bundlingList);
	}

	public void purchase() {
		// TODO: implement this method
	}
}
