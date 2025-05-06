package TicketingSystem.article.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ArticleResourceComponent implements ArticleResource{
	
	public ArticleResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveArticle(VMJExchange vmjExchange);
    public abstract Article createArticle(VMJExchange vmjExchange);
	public abstract Article createArticle(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateArticle(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getArticle(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllArticle(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteArticle(VMJExchange vmjExchange);

	public abstract void publish();
}
