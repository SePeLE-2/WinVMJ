package TicketingSystem.article.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import TicketingSystem.eventorganizer.core.EventOrganizerComponent;
import TicketingSystem.eventorganizer.core.EventOrganizerImpl;

@Entity
@Table(name="article_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ArticleComponent implements Article{
	@Id
	protected UUID idArticle; 
	protected String articleTitle;
	protected String articleContent;
	protected String articleAuthor;
	protected String articleDatePublished;
	@ManyToOne(targetEntity=TicketingSystem.eventorganizer.core.EventOrganizerComponent.class)
	public EventOrganizerComponent eventorganizerimpl;
	protected String objectName = ArticleComponent.class.getName();

	public ArticleComponent() {

	} 

	public ArticleComponent(
        UUID idArticle, String articleTitle, String articleContent, String articleAuthor, String articleDatePublished, EventOrganizerImpl eventorganizerimpl
    ) {
        this.idArticle = idArticle;
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.articleAuthor = articleAuthor;
        this.articleDatePublished = articleDatePublished;
        this.eventorganizerimpl = eventorganizerimpl;
    }

	public UUID getIdArticle() {
		return this.idArticle;
	}

	public void setIdArticle(UUID idArticle) {
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
	public abstract EventOrganizerComponent getEventorganizerimpl();
	public abstract void setEventorganizerimpl(EventOrganizerImpl eventorganizerimpl);
	
 
	public abstract void publish();

	@Override
    public String toString() {
        return "{" +
            " idArticle='" + getIdArticle() + "'" +
            " articleTitle='" + getArticleTitle() + "'" +
            " articleContent='" + getArticleContent() + "'" +
            " articleAuthor='" + getArticleAuthor() + "'" +
            " articleDatePublished='" + getArticleDatePublished() + "'" +
            " eventorganizerimpl='" + getEventorganizerimpl() + "'" +
            "}";
    }
	
}
