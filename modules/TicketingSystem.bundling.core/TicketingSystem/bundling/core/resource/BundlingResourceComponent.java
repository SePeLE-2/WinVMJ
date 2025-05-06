package TicketingSystem.bundling.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class BundlingResourceComponent implements BundlingResource{
	
	public BundlingResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveBundling(VMJExchange vmjExchange);
    public abstract Bundling createBundling(VMJExchange vmjExchange);
	public abstract Bundling createBundling(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateBundling(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getBundling(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllBundling(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteBundling(VMJExchange vmjExchange);

	protected abstract void purchase();
}
