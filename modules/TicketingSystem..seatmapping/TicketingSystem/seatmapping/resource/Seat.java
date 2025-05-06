package TicketingSystem..seatmapping;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import TicketingSystem.seatmapping.Seat;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class Seat extends Seat{
	protected Seat record;

	// @Restriced(permission = "")
	// @Restriced(permission = "")
    @Route(url="call/seatmapping/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Seat seat = createSeat(vmjExchange);
		seatRepository.saveObject(seat);
		return getAllSeat(vmjExchange);
	}

    public  create(VMJExchange vmjExchange){
		String seatNumber = (String) vmjExchange.getRequestBodyForm("seatNumber");
		String row = (String) vmjExchange.getRequestBodyForm("row");
		boolean isOccupied = (boolean) vmjExchange.getRequestBodyForm("isOccupied");
		String occupantIdStr = (String) vmjExchange.getRequestBodyForm("occupantId");
		int occupantId = Integer.parseInt(occupantIdStr);
		
		//to do: fix association attributes
		
		Seat seat = SeatFactory.createSeat("TicketingSystem.seatmapping.core.Seat", seatNumber, row, isOccupied, occupantId, customerimpl);
			return seat;
	}

    // @Restriced(permission = "")
    @Route(url="call/seatmapping/update")
    public HashMap<String, Object> update(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("occupantId");
		int id = Integer.parseInt(idStr);
		
		Seat seat = seatRepository.getObject(id);
		seat.setSeatNumber((String) vmjExchange.getRequestBodyForm("seatNumber"));
		seat.setRow((String) vmjExchange.getRequestBodyForm("row"));
		seat.setIsOccupied((String) vmjExchange.getRequestBodyForm("isOccupied"));
		String occupantIdStr = (String) vmjExchange.getRequestBodyForm("occupantId");
		seat.setOccupantId(Integer.parseInt(occupantIdStr));
		
		seatRepository.updateObject(seat);
		seat = seatRepository.getObject(id);
		//to do: fix association attributes
		
		return seat.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/seatmapping/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("occupantId"); 
		int id = Integer.parseInt(idStr);
		Seat seat = seatRepository.getObject(id);
		return seat.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/seatmapping/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		List<Seat> seatList = seatRepository.getAllObject("seat_impl");
		return transformSeatListToHashMap(seatList);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/seatmapping/delete")
    public List<HashMap<String,Object>> delete(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("occupantId");
		int id = Integer.parseInt(idStr);
		seatRepository.deleteObject(id);
		return getAllSeat(vmjExchange);
	}

	public boolean reserve() {
		// TODO: implement this method
	}

	public void release() {
		// TODO: implement this method
	}
}
