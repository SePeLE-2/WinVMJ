package TicketingSystem.bundling.core;

import java.util.*;

import vmj.routing.route.VMJExchange;

public interface BundlingService {
    // Bundling createBundling(Map<String, Object> requestBody);
    // Bundling createBundling(Map<String, Object> requestBody, Map<String, Object>
    // response);
    Bundling getBundling(UUID Id);

    Bundling saveBundling(HashMap<String, Object> body, String email);

    Bundling updateBundling(Map<String, Object> requestBody);

    // Bundling getBundlingById(int id);

    List<Bundling> getAllBundling();

    List<Bundling> deleteBundling(UUID Id);

    List<HashMap<String, Object>> transformListToHashMap(List<Bundling> List);

    void purchase();
}
