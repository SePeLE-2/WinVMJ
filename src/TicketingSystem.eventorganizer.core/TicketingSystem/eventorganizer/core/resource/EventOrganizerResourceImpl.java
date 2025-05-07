package TicketingSystem.eventorganizer.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import TicketingSystem.eventorganizer.EventOrganizerFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class EventOrganizerResourceImpl extends EventOrganizerResourceComponent{
	
	private EventOrganizerServiceImpl eventorganizerServiceImpl = new EventOrganizerServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/eventorganizer/save")
    public List<HashMap<String,Object>> saveEventOrganizer(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		EventOrganizer eventorganizer = createEventOrganizer(vmjExchange);
		eventorganizerRepository.saveObject(eventorganizer);
		return getAllEventOrganizer(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/eventorganizer")
    public HashMap<String,Object> eventorganizer(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			EventOrganizer result = eventorganizerServiceImpl.createEventOrganizer(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public EventOrganizer createEventOrganizer(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			EventOrganizer result = eventorganizerServiceImpl.createEventOrganizer(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public EventOrganizer createEventOrganizer(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			EventOrganizer result = eventorganizerServiceImpl.createEventOrganizer(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/eventorganizer/update")
    public HashMap<String, Object> updateEventOrganizer(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return eventorganizerServiceImpl.updateEventOrganizer(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/eventorganizer/detail")
    public HashMap<String, Object> getEventOrganizer(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return eventorganizerServiceImpl.getEventOrganizer(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/eventorganizer/list")
    public List<HashMap<String,Object>> getAllEventOrganizer(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return eventorganizerServiceImpl.getAllEventOrganizer(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/eventorganizer/delete")
    public List<HashMap<String,Object>> deleteEventOrganizer(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return eventorganizerServiceImpl.deleteEventOrganizer(requestBody);
	}


}
