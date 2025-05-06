package TicketingSystem.event.seatmapping;
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
    @Route(url="call/seatmapping/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		EventSeatMapping eventseatmapping = createEventSeatMapping(vmjExchange);
		eventseatmappingRepository.saveObject(eventseatmapping);
		return getAllEventSeatMapping(vmjExchange);
	}

    public Event createEventSeatMapping(VMJExchange vmjExchange){
		
		EventSeatMapping eventseatmapping = record.createEventSeatMapping(vmjExchange);
		EventSeatMapping eventseatmappingdeco = EventSeatMappingFactory.createEventSeatMapping("TicketingSystem.seatmapping.core.EventImpl", eventseatmapping, idEvent, name, date, location, description, ticketimpl, bundlingimpl
		);
			return eventseatmappingdeco;
	}


    public Event createEventSeatMapping(VMJExchange vmjExchange, int id){
		EventSeatMapping eventseatmapping = eventseatmappingRepository.getObject(id);
		int recordEventSeatMappingId = (((EventSeatMappingDecorator) savedEventSeatMapping.getRecord()).getId();
		
		EventSeatMapping eventseatmapping = record.createEventSeatMapping(vmjExchange);
		EventSeatMapping eventseatmappingdeco = EventSeatMappingFactory.createEventSeatMapping("TicketingSystem.seatmapping.core.EventImpl", id, eventseatmapping, idEvent, name, date, location, description, ticketimpl, bundlingimpl
		);
			return eventseatmappingdeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/seatmapping/update")
    public HashMap<String, Object> updateEventSeatMapping(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("idEvent");
		int id = Integer.parseInt(idStr);
		
		EventSeatMapping eventseatmapping = eventseatmappingRepository.getObject(id);
		eventseatmapping = createEventSeatMapping(vmjExchange, id);
		
		eventseatmappingRepository.updateObject(eventseatmapping);
		eventseatmapping = eventseatmappingRepository.getObject(id);
		//to do: fix association attributes
		
		return eventseatmapping.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/seatmapping/detail")
    public HashMap<String, Object> getEventSeatMapping(VMJExchange vmjExchange){
		return record.getEventSeatMapping(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/seatmapping/list")
    public List<HashMap<String,Object>> getAllEventSeatMapping(VMJExchange vmjExchange){
		List<EventSeatMapping> eventseatmappingList = eventseatmappingRepository.getAllObject("eventseatmapping_impl");
		return transformEventSeatMappingListToHashMap(eventseatmappingList);
	}

    public List<HashMap<String,Object>> transformEventSeatMappingListToHashMap(List<EventSeatMapping> EventSeatMappingList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < EventSeatMappingList.size(); i++) {
            resultList.add(EventSeatMappingList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/seatmapping/delete")
    public List<HashMap<String,Object>> deleteEventSeatMapping(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("idEvent");
		int id = Integer.parseInt(idStr);
		eventseatmappingRepository.deleteObject(id);
		return getAllEventSeatMapping(vmjExchange);
	}

	public boolean assignSeat() {
		// TODO: implement this method
	}

	public void getAvailableSeats() {
		// TODO: implement this method
	}

	public void getSeatForUser() {
		// TODO: implement this method
	}
	
}
