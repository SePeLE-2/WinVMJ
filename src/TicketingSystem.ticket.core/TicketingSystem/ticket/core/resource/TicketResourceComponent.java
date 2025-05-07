package TicketingSystem.ticket.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class TicketResourceComponent implements TicketResource{
	
	public TicketResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveTicket(VMJExchange vmjExchange);
    public abstract Ticket createTicket(VMJExchange vmjExchange);
	public abstract Ticket createTicket(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateTicket(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getTicket(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllTicket(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteTicket(VMJExchange vmjExchange);

	public abstract void purchase();
}
