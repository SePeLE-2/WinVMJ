package TicketingSystem.comment.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import TicketingSystem.eventorganizer.core.*;
import TicketingSystem.customer.core.*;
import TicketingSystem.article.core.*;

@Entity
@Table(name="comment_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CommentComponent implements Comment{
	@Id
	protected UUID idContent; 
	protected String comment;
	protected String commentAuthor;
	@ManyToOne(targetEntity=TicketingSystem.eventorganizer.core.EventOrganizerComponent.class)
	public EventOrganizerComponent eventorganizerimpl;
	@ManyToOne(targetEntity=TicketingSystem.customer.core.CustomerComponent.class)
	public CustomerComponent customerimpl;
	@ManyToOne(targetEntity=TicketingSystem.article.core.ArticleComponent.class)
	public ArticleComponent articleimpl;
	protected String objectName = CommentComponent.class.getName();

	public CommentComponent() {

	} 

	public CommentComponent(
        UUID idContent, String comment, String commentAuthor, EventOrganizerImpl eventorganizerimpl, CustomerImpl customerimpl, ArticleImpl articleimpl
    ) {
        this.idContent = idContent;
        this.comment = comment;
        this.commentAuthor = commentAuthor;
        this.eventorganizerimpl = eventorganizerimpl;
        this.customerimpl = customerimpl;
        this.articleimpl = articleimpl;
    }

	public UUID getIdContent() {
		return this.idContent;
	}

	public void setIdContent(UUID idContent) {
		this.idContent = idContent;
	}
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCommentAuthor() {
		return this.commentAuthor;
	}

	public void setCommentAuthor(String commentAuthor) {
		this.commentAuthor = commentAuthor;
	}
	public abstract EventOrganizerComponent getEventorganizerimpl();
	public abstract void setEventorganizerimpl(EventOrganizerImpl eventorganizerimpl);
	
	public abstract CustomerComponent getCustomerimpl();
	public abstract void setCustomerimpl(CustomerImpl customerimpl);
	
	public abstract ArticleComponent getArticleimpl();
	public abstract void setArticleimpl(ArticleImpl articleimpl);
	
 

	@Override
    public String toString() {
        return "{" +
            " idContent='" + getIdContent() + "'" +
            " comment='" + getComment() + "'" +
            " commentAuthor='" + getCommentAuthor() + "'" +
            " eventorganizerimpl='" + getEventorganizerimpl() + "'" +
            " customerimpl='" + getCustomerimpl() + "'" +
            " articleimpl='" + getArticleimpl() + "'" +
            "}";
    }
	
}
