package TicketingSystem.article.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class ArticleResourceDecorator extends ArticleResourceComponent{
	protected ArticleResourceComponent record;

    public ArticleResourceDecorator(ArticleResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveArticle(VMJExchange vmjExchange){
		return record.saveArticle(vmjExchange);
	}

    public Article createArticle(VMJExchange vmjExchange){
		return record.createArticle(vmjExchange);
	}

    public Article createArticle(VMJExchange vmjExchange, int id){
		return record.createArticle(vmjExchange, id);
	}

    public HashMap<String, Object> updateArticle(VMJExchange vmjExchange){
		return record.updateArticle(vmjExchange);
	}

    public HashMap<String, Object> getArticle(VMJExchange vmjExchange){
		return record.getArticle(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllArticle(VMJExchange vmjExchange){
		return record.getAllArticle(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteArticle(VMJExchange vmjExchange){
		return record.deleteArticle(vmjExchange);
	}

	public void publish() {
		return record.publish();
	}
}
