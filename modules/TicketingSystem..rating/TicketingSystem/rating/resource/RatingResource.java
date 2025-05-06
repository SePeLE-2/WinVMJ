package TicketingSystem..rating;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface RatingResource {
    List<HashMap<String,Object>> saveRating(VMJExchange vmjExchange);
    HashMap<String, Object> updateRating(VMJExchange vmjExchange);
    HashMap<String, Object> getRating(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllRating(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteRating(VMJExchange vmjExchange);
}
