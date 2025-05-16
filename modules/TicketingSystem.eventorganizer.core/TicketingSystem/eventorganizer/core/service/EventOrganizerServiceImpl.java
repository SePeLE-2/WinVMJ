package TicketingSystem.eventorganizer.core;

import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import TicketingSystem.eventorganizer.EventOrganizerFactory;
import vmj.auth.annotations.Restricted;
//add other required packages
import TicketingSystem.event.core.EventImpl;

public class EventOrganizerServiceImpl extends EventOrganizerServiceComponent{

	@Override
    public List<HashMap<String,Object>> saveEventOrganizer(VMJExchange vmjExchange){

		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}

		Map<String, Object> requestBody = vmjExchange.getPayload();
		EventOrganizer eventorganizer = createEventOrganizer(requestBody);

		Repository.saveObject(eventorganizer);
		return getAllEventOrganizer(requestBody);
		// EventOrganizer eventorganizer = createEventOrganizer(vmjExchange);
		// Repository.saveObject(eventorganizer);
		// return getAllEventOrganizer(vmjExchange);
	}

    public EventOrganizer createEventOrganizer(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id");
		int id = Integer.parseInt(idStr);
		String name = (String) requestBody.get("name");
		String email = (String) requestBody.get("email");
		String location = (String) requestBody.get("location");
		
		//to do: fix association attributes
		EventImpl eventimpl = new EventImpl();

		EventOrganizer eventOrganizer = EventOrganizerFactory.createEventOrganizer(
			"TicketingSystem.eventorganizer.core.EventOrganizerImpl",
			id, name, email, location, eventimpl
		);
		Repository.saveObject(eventOrganizer);
		return eventOrganizer;
	}

	public EventOrganizer createEventOrganizer(Map<String, Object> requestBody, Map<String, Object> response) {
		return createEventOrganizer(requestBody);
	}

    // public EventOrganizer createEventOrganizer(Map<String, Object> requestBody, int id){
	// 	String name = (String) vmjExchange.getRequestBodyForm("name");
	// 	String email = (String) vmjExchange.getRequestBodyForm("email");
	// 	String location = (String) vmjExchange.getRequestBodyForm("location");
		
	// 	//to do: fix association attributes
	// 	EventImpl eventimpl = new EventImpl();
	// 	// EventImpl eventimpl = (EventImpl) vmjExchange.getRequestBodyForm("eventimpl");
		
	// 	EventOrganizer eventorganizer = EventOrganizerFactory.createEventOrganizer("TicketingSystem.eventorganizer.core.EventOrganizerImpl", name, email, location, eventimpl);
	// 	return eventorganizer;
	// }

    public HashMap<String, Object> updateEventOrganizer(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id");
		UUID id = UUID.fromString(idStr);
		EventOrganizer eventorganizer = Repository.getObject(id);
		
		eventorganizer.setName((String) requestBody.get("name"));
		eventorganizer.setEmail((String) requestBody.get("email"));
		eventorganizer.setLocation((String) requestBody.get("location"));
		
		Repository.updateObject(eventorganizer);
		
		//to do: fix association attributes
		
		return eventorganizer.toHashMap();
		
	}

	public HashMap<String, Object> getEventOrganizer(Map<String, Object> requestBody){
		// String idStr = (String) requestBody.get("id");
		// int id = Integer.parseInt(idStr);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("table_name", "eventorganizer_impl");
		List<HashMap<String, Object>> eventorganizerList = getAllEventOrganizer(map);
		for (HashMap<String, Object> eventorganizer : eventorganizerList){
			int record_id = ((Double) eventorganizer.get("record_id")).intValue();
			if (eventorganizer.get("id").equals(record_id)){
				return eventorganizer;
			}
		}
		return null;
	}

	public HashMap<String, Object> getEventOrganizerById(int id){
		EventOrganizer eventorganizer = Repository.getObject(id);
		return eventorganizer.toHashMap();
	}

    public List<HashMap<String,Object>> getAllEventOrganizer(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<EventOrganizer> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<EventOrganizer> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteEventOrganizer(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllEventOrganizer(requestBody);
	}

	public EventOrganizer getEventOrganizerByName(String name){
		EventOrganizer eventorganizer = null;
		try {
			eventorganizer = this.Repository.getListObject("eventorganizer_comp", "name", name).get(0);
		} catch (Exception e) {
			throw new NotFoundException("Event Organizer with name " + name + " not exist.");
		}
		return eventorganizer;
	}

}
