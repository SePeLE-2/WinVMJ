package TicketingSystem.comment.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="comment_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CommentComponent implements Comment{
	@Id
	protected int idContent; 
	protected String comment;
	protected String commentAuthor;
	@ManyToOne(targetEntity=TicketingSystem..core.Component.class)
	public  eventorganizerimpl;
	@ManyToOne(targetEntity=TicketingSystem..core.Component.class)
	public  customerimpl;
	@ManyToOne(targetEntity=TicketingSystem..core.Component.class)
	public  articleimpl;
	protected String objectName = CommentComponent.class.getName();

	public CommentComponent() {

	} 

	public CommentComponent(
        int idContent, String comment, String commentAuthor, EventOrganizerImpl eventorganizerimpl, CustomerImpl customerimpl, ArticleImpl articleimpl
    ) {
        this.idContent = idContent;
        this.comment = comment;
        this.commentAuthor = commentAuthor;
        this.eventorganizerimpl = eventorganizerimpl;
        this.customerimpl = customerimpl;
        this.articleimpl = articleimpl;
    }

	public int getIdContent() {
		return this.idContent;
	}

	public void setIdContent(int idContent) {
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
	public abstract EventOrganizerImpl getEventorganizerimpl();
	public abstract void setEventorganizerimpl(EventOrganizerImpl eventorganizerimpl);
	
	public abstract CustomerImpl getCustomerimpl();
	public abstract void setCustomerimpl(CustomerImpl customerimpl);
	
	public abstract ArticleImpl getArticleimpl();
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
