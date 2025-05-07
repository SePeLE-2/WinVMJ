package TicketingSystem.payment.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Payment {
	public int getAmount();
	public void setAmount(int amount);
	public BundlingImpl getBundlingimpl();
	public void setBundlingimpl(BundlingImpl bundlingimpl);
	public TicketImpl getTicketimpl();
	public void setTicketimpl(TicketImpl ticketimpl);
	public void pay();
	HashMap<String, Object> toHashMap();
}
