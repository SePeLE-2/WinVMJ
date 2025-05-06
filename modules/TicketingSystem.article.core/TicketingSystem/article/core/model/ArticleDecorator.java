package TicketingSystem.article.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class ArticleDecorator extends ArticleComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected ArticleComponent record;

	public ArticleDecorator () {
		super();
		this.record = record;
		this.idArticle =  idArticle.randomUUID();
		
	public ArticleDecorator (ArticleComponent record) {
		this.idArticle =  idArticle.randomUUID();
		this.record = record;
	}

	public ArticleDecorator (int idArticle, ArticleComponent record) {
		this.idArticle =  idArticle;
		this.record = record;
	}
	
	public ArticleDecorator (ArticleComponent record, String objectName) {
		this.idArticle =  idArticle.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public ArticleDecorator() { }

	public int getIdArticle() {
		return record.getIdArticle();
	}
	public void setIdArticle(int idArticle) {
		record.setIdArticle(idArticle);
	}
	public String getArticleTitle() {
		return record.getArticleTitle();
	}
	public void setArticleTitle(String articleTitle) {
		record.setArticleTitle(articleTitle);
	}
	public String getArticleContent() {
		return record.getArticleContent();
	}
	public void setArticleContent(String articleContent) {
		record.setArticleContent(articleContent);
	}
	public String getArticleAuthor() {
		return record.getArticleAuthor();
	}
	public void setArticleAuthor(String articleAuthor) {
		record.setArticleAuthor(articleAuthor);
	}
	public String getArticleDatePublished() {
		return record.getArticleDatePublished();
	}
	public void setArticleDatePublished(String articleDatePublished) {
		record.setArticleDatePublished(articleDatePublished);
	}

	public void publish() {
		return record.publish();
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
