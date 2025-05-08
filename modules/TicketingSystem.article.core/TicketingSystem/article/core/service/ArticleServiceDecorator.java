package TicketingSystem.article.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class ArticleServiceDecorator extends ArticleServiceComponent{
	protected ArticleServiceComponent record;

    public ArticleServiceDecorator(ArticleServiceComponent record) {
        this.record = record;
    }

	public ArticleImpl createArticle(Map<String, Object> requestBody){
		return record.createArticle(requestBody);
	}

    public Article createArticle(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createArticle(requestBody, response);
	}

	public HashMap<String, Object> getArticle(Map<String, Object> requestBody){
		return record.getArticle(requestBody);
	}

	public List<HashMap<String,Object>> getAllArticle(Map<String, Object> requestBody){
		return record.getAllArticle(requestBody);
	}

    public List<HashMap<String,Object>> saveArticle(VMJExchange vmjExchange){
		return record.saveArticle(vmjExchange);
	}

    public HashMap<String, Object> updateArticle(Map<String, Object> requestBody){
		return record.updateArticle(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Article> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteArticle(Map<String, Object> requestBody){
		return record.deleteArticle(requestBody);
	}

	public HashMap<String, Object> getArticleById(int id){
        return record.getArticleById(id);
    }

	public void publish() {
		return record.publish();
	}
}
