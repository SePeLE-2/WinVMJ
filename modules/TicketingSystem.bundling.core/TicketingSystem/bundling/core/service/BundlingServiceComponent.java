package TicketingSystem.bundling.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class BundlingServiceComponent implements BundlingService{
	protected RepositoryUtil<Bundling> Repository;

    public BundlingServiceComponent(){
        this.Repository = new RepositoryUtil<Bundling>(TicketingSystem.bundling.core.BundlingComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveBundling(VMJExchange vmjExchange);
    public abstract Bundling createBundling(Map<String, Object> requestBodye);
	public abstract Bundling createBundling(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateBundling(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getBundling(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllBundling(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Bundling> List);
    public abstract List<HashMap<String,Object>> deleteBundling(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getBundlingById(int id);

	protected abstract void purchase();
}
