package TicketingSystem.comment.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class CommentResourceDecorator extends CommentResourceComponent{
	protected CommentResourceComponent record;

    public CommentResourceDecorator(CommentResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveComment(VMJExchange vmjExchange){
		return record.saveComment(vmjExchange);
	}

    public Comment createComment(VMJExchange vmjExchange){
		return record.createComment(vmjExchange);
	}

    public Comment createComment(VMJExchange vmjExchange, int id){
		return record.createComment(vmjExchange, id);
	}

    public HashMap<String, Object> updateComment(VMJExchange vmjExchange){
		return record.updateComment(vmjExchange);
	}

    public HashMap<String, Object> getComment(VMJExchange vmjExchange){
		return record.getComment(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllComment(VMJExchange vmjExchange){
		return record.getAllComment(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteComment(VMJExchange vmjExchange){
		return record.deleteComment(vmjExchange);
	}

}
