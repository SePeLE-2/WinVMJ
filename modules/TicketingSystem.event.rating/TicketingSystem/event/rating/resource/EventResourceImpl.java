package TicketingSystem.event.rating;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import TicketingSystem.event.core.EventResourceDecorator;
import TicketingSystem.event.core.EventImpl;
import TicketingSystem.event.core.EventResourceComponent;

public class EventResourceImpl extends EventResourceDecorator {
    public EventResourceImpl (EventResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/rating/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		EventRating eventrating = createEventRating(vmjExchange);
		eventratingRepository.saveObject(eventrating);
		return getAllEventRating(vmjExchange);
	}

    public Event createEventRating(VMJExchange vmjExchange){
		
		EventRating eventrating = record.createEventRating(vmjExchange);
		EventRating eventratingdeco = EventRatingFactory.createEventRating("TicketingSystem.rating.core.EventImpl", eventrating, idEvent, name, date, location, description, ticketimpl, bundlingimpl
		);
			return eventratingdeco;
	}


    public Event createEventRating(VMJExchange vmjExchange, int id){
		EventRating eventrating = eventratingRepository.getObject(id);
		int recordEventRatingId = (((EventRatingDecorator) savedEventRating.getRecord()).getId();
		
		EventRating eventrating = record.createEventRating(vmjExchange);
		EventRating eventratingdeco = EventRatingFactory.createEventRating("TicketingSystem.rating.core.EventImpl", id, eventrating, idEvent, name, date, location, description, ticketimpl, bundlingimpl
		);
			return eventratingdeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/rating/update")
    public HashMap<String, Object> updateEventRating(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("idEvent");
		int id = Integer.parseInt(idStr);
		
		EventRating eventrating = eventratingRepository.getObject(id);
		eventrating = createEventRating(vmjExchange, id);
		
		eventratingRepository.updateObject(eventrating);
		eventrating = eventratingRepository.getObject(id);
		//to do: fix association attributes
		
		return eventrating.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/rating/detail")
    public HashMap<String, Object> getEventRating(VMJExchange vmjExchange){
		return record.getEventRating(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/rating/list")
    public List<HashMap<String,Object>> getAllEventRating(VMJExchange vmjExchange){
		List<EventRating> eventratingList = eventratingRepository.getAllObject("eventrating_impl");
		return transformEventRatingListToHashMap(eventratingList);
	}

    public List<HashMap<String,Object>> transformEventRatingListToHashMap(List<EventRating> EventRatingList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < EventRatingList.size(); i++) {
            resultList.add(EventRatingList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/rating/delete")
    public List<HashMap<String,Object>> deleteEventRating(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("idEvent");
		int id = Integer.parseInt(idStr);
		eventratingRepository.deleteObject(id);
		return getAllEventRating(vmjExchange);
	}

	public void addRating() {
		// TODO: implement this method
	}

	public int getAverageRating() {
		// TODO: implement this method
	}
	
}
