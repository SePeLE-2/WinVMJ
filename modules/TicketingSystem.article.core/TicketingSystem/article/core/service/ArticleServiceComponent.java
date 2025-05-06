package TicketingSystem.article.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ArticleServiceComponent implements ArticleService{
	protected RepositoryUtil<Article> Repository;

    public ArticleServiceComponent(){
        this.Repository = new RepositoryUtil<Article>(TicketingSystem.article.core.ArticleComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveArticle(VMJExchange vmjExchange);
    public abstract Article createArticle(Map<String, Object> requestBodye);
	public abstract Article createArticle(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateArticle(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getArticle(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllArticle(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Article> List);
    public abstract List<HashMap<String,Object>> deleteArticle(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getArticleById(int id);

	public abstract void publish();
}
