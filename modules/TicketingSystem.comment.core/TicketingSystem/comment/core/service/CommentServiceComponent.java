package TicketingSystem.comment.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class CommentServiceComponent implements CommentService{
	protected RepositoryUtil<Comment> Repository;

    public CommentServiceComponent(){
        this.Repository = new RepositoryUtil<Comment>(TicketingSystem.comment.core.CommentComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveComment(VMJExchange vmjExchange);
    public abstract Comment createComment(Map<String, Object> requestBodye);
	public abstract Comment createComment(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateComment(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getComment(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllComment(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Comment> List);
    public abstract List<HashMap<String,Object>> deleteComment(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getCommentById(int id);

}
