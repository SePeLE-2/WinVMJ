package TicketingSystem.comment.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class CommentServiceDecorator extends CommentServiceComponent{
	protected CommentServiceComponent record;

    public CommentServiceDecorator(CommentServiceComponent record) {
        this.record = record;
    }

	public CommentImpl createComment(Map<String, Object> requestBody){
		return record.createComment(requestBody);
	}

    public Comment createComment(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createComment(requestBody, response);
	}

	public HashMap<String, Object> getComment(Map<String, Object> requestBody){
		return record.getComment(requestBody);
	}

	public List<HashMap<String,Object>> getAllComment(Map<String, Object> requestBody){
		return record.getAllComment(requestBody);
	}

    public List<HashMap<String,Object>> saveComment(VMJExchange vmjExchange){
		return record.saveComment(vmjExchange);
	}

    public HashMap<String, Object> updateComment(Map<String, Object> requestBody){
		return record.updateComment(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Comment> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteComment(Map<String, Object> requestBody){
		return record.deleteComment(requestBody);
	}

	public HashMap<String, Object> getCommentById(int id){
        return record.getCommentById(id);
    }

}
