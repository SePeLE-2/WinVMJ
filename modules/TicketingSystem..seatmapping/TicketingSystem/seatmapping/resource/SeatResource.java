package TicketingSystem..seatmapping;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface SeatResource {
    List<HashMap<String,Object>> saveSeat(VMJExchange vmjExchange);
    HashMap<String, Object> updateSeat(VMJExchange vmjExchange);
    HashMap<String, Object> getSeat(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllSeat(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteSeat(VMJExchange vmjExchange);
}
