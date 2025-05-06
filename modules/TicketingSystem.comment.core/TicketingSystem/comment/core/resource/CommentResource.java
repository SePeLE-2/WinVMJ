package TicketingSystem.comment.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface CommentResource {
    List<HashMap<String,Object>> saveComment(VMJExchange vmjExchange);
    HashMap<String, Object> updateComment(VMJExchange vmjExchange);
    HashMap<String, Object> getComment(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllComment(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteComment(VMJExchange vmjExchange);
	HashMap<String, Object> Comment(VMJExchange vmjExhange);
}
