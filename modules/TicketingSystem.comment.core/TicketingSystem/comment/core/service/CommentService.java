package TicketingSystem.comment.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface CommentService {
	Comment createComment(Map<String, Object> requestBody);
	Comment createComment(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getComment(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveComment(Map<String, Object> requestBody);
    HashMap<String, Object> updateComment(Map<String, Object> requestBody);
    HashMap<String, Object> getCommentById(int id);
    List<HashMap<String,Object>> getAllComment(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteComment(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
