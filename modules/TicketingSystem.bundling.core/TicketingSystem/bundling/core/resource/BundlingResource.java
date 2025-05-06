package TicketingSystem.bundling.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface BundlingResource {
    List<HashMap<String,Object>> saveBundling(VMJExchange vmjExchange);
    HashMap<String, Object> updateBundling(VMJExchange vmjExchange);
    HashMap<String, Object> getBundling(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllBundling(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteBundling(VMJExchange vmjExchange);
	HashMap<String, Object> Bundling(VMJExchange vmjExhange);
}
