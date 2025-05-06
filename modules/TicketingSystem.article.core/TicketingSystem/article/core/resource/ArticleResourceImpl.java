package TicketingSystem.article.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import TicketingSystem.article.ArticleFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class ArticleResourceImpl extends ArticleResourceComponent{
	
	private ArticleServiceImpl articleServiceImpl = new ArticleServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/article/save")
    public List<HashMap<String,Object>> saveArticle(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Article article = createArticle(vmjExchange);
		articleRepository.saveObject(article);
		return getAllArticle(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/article")
    public HashMap<String,Object> article(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Article result = articleServiceImpl.createArticle(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Article createArticle(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Article result = articleServiceImpl.createArticle(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Article createArticle(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Article result = articleServiceImpl.createArticle(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/article/update")
    public HashMap<String, Object> updateArticle(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return articleServiceImpl.updateArticle(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/article/detail")
    public HashMap<String, Object> getArticle(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return articleServiceImpl.getArticle(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/article/list")
    public List<HashMap<String,Object>> getAllArticle(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return articleServiceImpl.getAllArticle(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/article/delete")
    public List<HashMap<String,Object>> deleteArticle(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return articleServiceImpl.deleteArticle(requestBody);
	}


	
	public void publish() {
		// TODO: implement this method
	}
}
