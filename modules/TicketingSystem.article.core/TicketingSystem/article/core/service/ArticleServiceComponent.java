package TicketingSystem.article.core;
import java.util.*;

import TicketingSystem.article.core.Article;
import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ArticleServiceComponent implements ArticleService{
	protected RepositoryUtil<Article> Repository;

    public ArticleServiceComponent(){
        this.Repository = new RepositoryUtil<Article>(TicketingSystem.article.core.ArticleComponent.class);
    }	

    public abstract HashMap<String, Object> saveArticle(Map<String, Object> requestBodye);  
	public abstract HashMap<String, Object> updateArticle(Map<String, Object> requestBody);
    // public abstract HashMap<String, Object> getArticle(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllArticle(Map<String, Object> requestBody);
    // public abstract List<HashMap<String,Object>> transformListToHashMap(List<Article> List);
    public abstract List<HashMap<String,Object>> deleteArticle(Map<String, Object> requestBody);
	public abstract Article getArticleById(int id);

	public abstract void publish();
}
