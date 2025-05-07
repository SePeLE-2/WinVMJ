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
	org.eclipse.uml2.uml.internal.impl.ClassImpl@58003262 (name: PaymentImpl, visibility: <unset>) (isLeaf: false, isAbstract: false, isFinalSpecialization: false) (isActive: false)
	public void pay();
	HashMap<String, Object> toHashMap();
}
