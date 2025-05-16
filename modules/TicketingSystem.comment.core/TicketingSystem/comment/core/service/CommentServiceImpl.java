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
import vmj.auth.annotations.Restricted;
//add other required packages

import TicketingSystem.eventorganizer.core.EventOrganizer;
import TicketingSystem.eventorganizer.core.EventOrganizerService;
import TicketingSystem.eventorganizer.core.EventOrganizerServiceImpl;
import TicketingSystem.customer.core.Customer;
import TicketingSystem.customer.core.CustomerService;
import TicketingSystem.customer.core.CustomerServiceImpl;
import TicketingSystem.article.core.Article;
import TicketingSystem.article.core.ArticleService;
import TicketingSystem.article.core.ArticleServiceImpl;

public class CommentServiceImpl extends CommentServiceComponent{
	private EventOrganizerService eventOrganizerService = new EventOrganizerServiceImpl();
	private CustomerService customerService = new CustomerServiceImpl();
	private ArticleService articleService = new ArticleServiceImpl();

    // public List<HashMap<String,Object>> saveComment(VMJExchange vmjExchange){
	// 	if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
	// 		return null;
	// 	}
	// 	Comment comment = createComment(vmjExchange);
	// 	Repository.saveObject(comment);
	// 	return getAllComment(vmjExchange);
	// }

    public HashMap<String, Object> saveComment(Map<String, Object> requestBody, int idArticle){
		String idContentStr = (String) requestBody.get("idContent");
		int idContent = Integer.parseInt(idContentStr);
		String comment = (String) requestBody.get("comment");
		String commentAuthor = (String) requestBody.get("commentAuthor");
		EventOrganizer eventorganizerimpl = eventOrganizerService.getEventOrganizerByName(commentAuthor);
		Customer customerimpl = customerService.getCustomerByName(commentAuthor);
		Article articleimpl = articleService.getArticleById(idArticle);
		
		
		//to do: fix association attributes
		Comment commentObj = CommentFactory.createComment(
			"TicketingSystem.comment.core.CommentImpl",
		idContent
		, comment
		, commentAuthor
		, eventorganizerimpl
		, customerimpl
		, articleimpl
		);
		Repository.saveObject(commentObj);
		return commentObj.toHashMap();
	}

    // public Comment createComment(Map<String, Object> requestBody, int id){
	// 	String idArticle = vmjExchange.getGETParam("idArticle"); 
	// 	String commentString = (String) vmjExchange.getRequestBodyForm("comment");
	// 	String commentAuthor = (String) vmjExchange.getRequestBodyForm("commentAuthor");
	// 	EventOrganizer eventorganizerimpl = eventOrganizerService.getEventOrganizerByName(commentAuthor);
	// 	Customer customerimpl = customerService.getCustomerByName(commentAuthor);
	// 	Article articleimpl = articleService.getArticleById(idArticle);
	// 	//to do: fix association attributes
		
	// 	Comment comment = CommentFactory.createComment("TicketingSystem.comment.core.CommentImpl", commentString, commentAuthor
	// 	// , eventorganizerimpl, customerimpl, articleimpl
	// 	);
	// 	return comment;
	// }

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

    // public HashMap<String, Object> getComment(Map<String, Object> requestBody){
	// 	List<HashMap<String, Object>> commentList = getAllComment();
	// 	for (HashMap<String, Object> comment : commentList){
	// 		int record_id = ((Double) comment.get("record_id")).intValue();
	// 		if (record_id == id){
	// 			return comment;
	// 		}
	// 	}
	// 	return null;
	// }

	// public HashMap<String, Object> getCommentById(int id){
	// 	String idStr = vmjExchange.getGETParam("idContent"); 
	// 	int idComment = Integer.parseInt(idStr);
	// 	Comment comment = commentRepository.getObject(idComment);
	// 	return comment.toHashMap();
	// }

    public List<HashMap<String,Object>> getAllComment(){
		// String table = (String) requestBody.get("table_name");
		List<Comment> List = Repository.getAllObject("comment_impl");
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
		return getAllComment();
	}

}
