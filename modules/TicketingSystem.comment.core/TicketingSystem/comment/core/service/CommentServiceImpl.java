package TicketingSystem.comment.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import TicketingSystem.comment.CommentFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class CommentServiceImpl extends CommentServiceComponent{

    public List<HashMap<String,Object>> saveComment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Comment comment = createComment(vmjExchange);
		commentRepository.saveObject(comment);
		return getAllComment(vmjExchange);
	}

    public Comment createComment(Map<String, Object> requestBody){
		String idContentStr = (String) requestBody.get("idContent");
		int idContent = Integer.parseInt(idContentStr);
		String comment = (String) requestBody.get("comment");
		String commentAuthor = (String) requestBody.get("commentAuthor");
		
		//to do: fix association attributes
		Comment Comment = CommentFactory.createComment(
			"TicketingSystem.comment.core.CommentImpl",
		idContent
		, comment
		, commentAuthor
		, eventorganizerimpl
		, customerimpl
		, articleimpl
		);
		Repository.saveObject(comment);
		return comment;
	}

    public Comment createComment(Map<String, Object> requestBody, int id){
		String comment = (String) vmjExchange.getRequestBodyForm("comment");
		String commentAuthor = (String) vmjExchange.getRequestBodyForm("commentAuthor");
		
		//to do: fix association attributes
		
		Comment comment = CommentFactory.createComment("TicketingSystem.comment.core.CommentImpl", comment, commentAuthor, eventorganizerimpl, customerimpl, articleimpl);
		return comment;
	}

    public HashMap<String, Object> updateComment(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idContent");
		int id = Integer.parseInt(idStr);
		Comment comment = Repository.getObject(id);
		
		comment.setComment((String) requestBody.get("comment"));
		comment.setCommentAuthor((String) requestBody.get("commentAuthor"));
		
		Repository.updateObject(comment);
		
		//to do: fix association attributes
		
		return comment.toHashMap();
		
	}

    public HashMap<String, Object> getComment(Map<String, Object> requestBody){
		List<HashMap<String, Object>> commentList = getAllComment("comment_impl");
		for (HashMap<String, Object> comment : commentList){
			int record_id = ((Double) comment.get("record_id")).intValue();
			if (record_id == id){
				return comment;
			}
		}
		return null;
	}

	public HashMap<String, Object> getCommentById(int id){
		String idStr = vmjExchange.getGETParam("idContent"); 
		int id = Integer.parseInt(idStr);
		Comment comment = commentRepository.getObject(id);
		return comment.toHashMap();
	}

    public List<HashMap<String,Object>> getAllComment(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Comment> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Comment> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteComment(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllComment(requestBody);
	}

}
