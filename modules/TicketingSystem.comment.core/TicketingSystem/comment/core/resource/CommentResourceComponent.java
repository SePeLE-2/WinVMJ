package TicketingSystem.comment.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class CommentResourceComponent implements CommentResource{
	
	public CommentResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveComment(VMJExchange vmjExchange);
    public abstract Comment createComment(VMJExchange vmjExchange);
	public abstract Comment createComment(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateComment(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getComment(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllComment(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteComment(VMJExchange vmjExchange);

}
