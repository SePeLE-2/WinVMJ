package TicketingSystem.event.core;
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
import TicketingSystem.event.EventFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class EventServiceImpl extends EventServiceComponent{

    public List<HashMap<String,Object>> saveEvent(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Event event = createEvent(vmjExchange);
		eventRepository.saveObject(event);
		return getAllEvent(vmjExchange);
	}

    public Event createEvent(Map<String, Object> requestBody){
		String idEventStr = (String) requestBody.get("idEvent");
		int idEvent = Integer.parseInt(idEventStr);
		String name = (String) requestBody.get("name");
		String date = (String) requestBody.get("date");
		String location = (String) requestBody.get("location");
		String description = (String) requestBody.get("description");
		
		//to do: fix association attributes
		Event Event = EventFactory.createEvent(
			"TicketingSystem.event.core.EventImpl",
		idEvent
		, name
		, date
		, location
		, description
		, ticketimpl
		, bundlingimpl
		);
		Repository.saveObject(event);
		return event;
	}

    public Event createEvent(Map<String, Object> requestBody, int id){
		String name = (String) vmjExchange.getRequestBodyForm("name");
		String date = (String) vmjExchange.getRequestBodyForm("date");
		String location = (String) vmjExchange.getRequestBodyForm("location");
		String description = (String) vmjExchange.getRequestBodyForm("description");
		
		//to do: fix association attributes
		
		Event event = EventFactory.createEvent("TicketingSystem.event.core.EventImpl", name, date, location, description, ticketimpl, bundlingimpl);
		return event;
	}

    public HashMap<String, Object> updateEvent(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idEvent");
		int id = Integer.parseInt(idStr);
		Event event = Repository.getObject(id);
		
		event.setName((String) requestBody.get("name"));
		event.setDate((String) requestBody.get("date"));
		event.setLocation((String) requestBody.get("location"));
		event.setDescription((String) requestBody.get("description"));
		
		Repository.updateObject(event);
		
		//to do: fix association attributes
		
		return event.toHashMap();
		
	}

    public HashMap<String, Object> getEvent(Map<String, Object> requestBody){
		List<HashMap<String, Object>> eventList = getAllEvent("event_impl");
		for (HashMap<String, Object> event : eventList){
			int record_id = ((Double) event.get("record_id")).intValue();
			if (record_id == id){
				return event;
			}
		}
		return null;
	}

	public HashMap<String, Object> getEventById(int id){
		String idStr = vmjExchange.getGETParam("idEvent"); 
		int id = Integer.parseInt(idStr);
		Event event = eventRepository.getObject(id);
		return event.toHashMap();
	}

    public List<HashMap<String,Object>> getAllEvent(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Event> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Event> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteEvent(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllEvent(requestBody);
	}

	public void createEvent() {
		// TODO: implement this method
	}

	public String getDetails() {
		// TODO: implement this method
	}
}
