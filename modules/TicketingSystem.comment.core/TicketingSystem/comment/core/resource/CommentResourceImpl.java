package TicketingSystem.comment.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import TicketingSystem.comment.CommentFactory;
import vmj.auth.annotations.Restricted;
//add other required packages


public class CommentResourceImpl extends CommentResourceComponent{
	
	private CommentServiceImpl commentServiceImpl = new CommentServiceImpl();

	
    @Route(url="call/comment/save")
    public List<HashMap<String,Object>> saveComment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Comment comment = createComment(vmjExchange);
		commentRepository.saveObject(comment);
		return getAllComment(vmjExchange);
	}

	
    @Route(url="call/comment")
    public HashMap<String,Object> comment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Comment result = commentServiceImpl.createComment(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Comment createComment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Comment result = commentServiceImpl.createComment(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Comment createComment(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Comment result = commentServiceImpl.createComment(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/comment/update")
    public HashMap<String, Object> updateComment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return commentServiceImpl.updateComment(requestBody);
		
	}

	
    @Route(url="call/comment/detail")
    public HashMap<String, Object> getComment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return commentServiceImpl.getComment(requestBody);
	}

	
    @Route(url="call/comment/list")
    public List<HashMap<String,Object>> getAllComment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return commentServiceImpl.getAllComment(requestBody);
	}

	
    @Route(url="call/comment/delete")
    public List<HashMap<String,Object>> deleteComment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return commentServiceImpl.deleteComment(requestBody);
	}


}
