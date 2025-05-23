package TicketingSystem.bundling.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class BundlingResourceComponent implements BundlingResource {
    protected RepositoryUtil<Bundling> bundlingRepository;

    public BundlingResourceComponent() {
        this.bundlingRepository = new RepositoryUtil<Bundling>(TicketingSystem.bundling.core.BundlingComponent.class);
    }

    public abstract HashMap<String, Object> saveBundling(VMJExchange vmjExchange);

    public abstract HashMap<String, Object> updateBundling(VMJExchange vmjExchange);

    public abstract HashMap<String, Object> getBundling(VMJExchange vmjExchange);

    public abstract List<HashMap<String, Object>> getAllBundling(VMJExchange vmjExchange);

    public abstract List<HashMap<String, Object>> deleteBundling(VMJExchange vmjExchange);

    public abstract void purchase();
}
