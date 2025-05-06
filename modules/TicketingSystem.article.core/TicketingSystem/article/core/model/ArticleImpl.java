package TicketingSystem.article.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="article_impl")
@Table(name="article_impl")
public class ArticleImpl extends ArticleComponent {

	public ArticleImpl(int idArticle, String articleTitle, String articleContent, String articleAuthor, String articleDatePublished, EventOrganizerImpl eventorganizerimpl) {
		this.idArticle = idArticle;
		this.articleTitle = articleTitle;
		this.articleContent = articleContent;
		this.articleAuthor = articleAuthor;
		this.articleDatePublished = articleDatePublished;
		this.eventorganizerimpl = eventorganizerimpl;
	}

	public ArticleImpl(String articleTitle, String articleContent, String articleAuthor, String articleDatePublished, EventOrganizerImpl eventorganizerimpl) {
		this.idArticle =  idArticle.randomUUID();;
		this.articleTitle = articleTitle;
		this.articleContent = articleContent;
		this.articleAuthor = articleAuthor;
		this.articleDatePublished = articleDatePublished;
		this.eventorganizerimpl = eventorganizerimpl;
	}

	public ArticleImpl() { }

	public int getIdArticle() {
		return this.idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	public String getArticleTitle() {
		return this.articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleContent() {
		return this.articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	public String getArticleAuthor() {
		return this.articleAuthor;
	}

	public void setArticleAuthor(String articleAuthor) {
		this.articleAuthor = articleAuthor;
	}
	public String getArticleDatePublished() {
		return this.articleDatePublished;
	}

	public void setArticleDatePublished(String articleDatePublished) {
		this.articleDatePublished = articleDatePublished;
	}

	public void publish() {
		// TODO: implement this method
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> articleMap = new HashMap<String,Object>();
		articleMap.put("idArticle",getIdArticle());
		articleMap.put("articleTitle",getArticleTitle());
		articleMap.put("articleContent",getArticleContent());
		articleMap.put("articleAuthor",getArticleAuthor());
		articleMap.put("articleDatePublished",getArticleDatePublished());
		articleMap.put("eventorganizerimpl",getEventorganizerimpl());

        return articleMap;
    }

}
