package TicketingSystem.ticket.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class TicketResourceDecorator extends TicketResourceComponent{
	protected TicketResourceComponent record;

    public TicketResourceDecorator(TicketResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveTicket(VMJExchange vmjExchange){
		return record.saveTicket(vmjExchange);
	}

    public Ticket createTicket(VMJExchange vmjExchange){
		return record.createTicket(vmjExchange);
	}

    public Ticket createTicket(VMJExchange vmjExchange, int id){
		return record.createTicket(vmjExchange, id);
	}

    public HashMap<String, Object> updateTicket(VMJExchange vmjExchange){
		return record.updateTicket(vmjExchange);
	}

    public HashMap<String, Object> getTicket(VMJExchange vmjExchange){
		return record.getTicket(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllTicket(VMJExchange vmjExchange){
		return record.getAllTicket(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteTicket(VMJExchange vmjExchange){
		return record.deleteTicket(vmjExchange);
	}

	public void purchase() {
		return record.purchase();
	}
}
