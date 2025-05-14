package TicketingSystem.bundling.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class BundlingServiceComponent implements BundlingService {
    protected RepositoryUtil<Bundling> bundlingRepository;

    public BundlingServiceComponent() {
        this.bundlingRepository = new RepositoryUtil<Bundling>(TicketingSystem.bundling.core.BundlingComponent.class);
    }

    public abstract Bundling saveBundling(HashMap<String, Object> body, String email);

    // public abstract Bundling createBundling(Map<String, Object> requestBodye);
    // public abstract Bundling createBundling(Map<String, Object> requestBody,
    // Map<String, Object> response);
    public abstract Bundling updateBundling(Map<String, Object> requestBody);

    public abstract Bundling getBundling(UUID Id);

    public abstract List<Bundling> getAllBundling();

    public abstract List<HashMap<String, Object>> transformListToHashMap(List<Bundling> List);

    public abstract List<Bundling> deleteBundling(UUID Id);

    // public abstract Bundling getBundlingById(int id);

    public abstract void purchase();
}
