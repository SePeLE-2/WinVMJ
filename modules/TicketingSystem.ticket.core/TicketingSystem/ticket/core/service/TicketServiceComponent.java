package TicketingSystem.ticket.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class TicketServiceComponent implements TicketService{
	protected RepositoryUtil<Ticket> Repository;

    public TicketServiceComponent(){
        this.Repository = new RepositoryUtil<Ticket>(TicketingSystem.ticket.core.TicketComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveTicket(VMJExchange vmjExchange);
    public abstract Ticket createTicket(Map<String, Object> requestBodye);
	public abstract Ticket createTicket(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateTicket(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getTicket(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllTicket(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Ticket> List);
    public abstract List<HashMap<String,Object>> deleteTicket(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getTicketById(int id);

	public abstract void purchase();
}
