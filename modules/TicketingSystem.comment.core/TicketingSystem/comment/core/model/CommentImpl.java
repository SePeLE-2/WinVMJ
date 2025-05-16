package TicketingSystem.comment.core;

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

import TicketingSystem.eventorganizer.core.*;
import TicketingSystem.customer.core.*;
import TicketingSystem.article.core.*;

@Entity(name="comment_impl")
@Table(name="comment_impl")
public class CommentImpl extends CommentComponent {

	public CommentImpl(UUID idContent, String comment, String commentAuthor, EventOrganizerImpl eventorganizerimpl, CustomerImpl customerimpl, ArticleImpl articleimpl) {
		this.idContent = idContent;
		this.comment = comment;
		this.commentAuthor = commentAuthor;
		this.eventorganizerimpl = eventorganizerimpl;
		this.customerimpl = customerimpl;
		this.articleimpl = articleimpl;
	}

	public CommentImpl(String comment, String commentAuthor, EventOrganizerImpl eventorganizerimpl, CustomerImpl customerimpl, ArticleImpl articleimpl) {
		this.idContent =  idContent.randomUUID();;
		this.comment = comment;
		this.commentAuthor = commentAuthor;
		this.eventorganizerimpl = eventorganizerimpl;
		this.customerimpl = customerimpl;
		this.articleimpl = articleimpl;
	}

	public CommentImpl() { }

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

	public EventOrganizerComponent getEventorganizerimpl(){
		return this.eventorganizerimpl;
	}
	public void setEventorganizerimpl(EventOrganizerImpl eventorganizerimpl){
		this.eventorganizerimpl = eventorganizerimpl;
	}
	
	public CustomerComponent getCustomerimpl(){
		return this.customerimpl;
	}
	public void setCustomerimpl(CustomerImpl customerimpl){
		this.customerimpl = customerimpl;
	}
	
	public ArticleComponent getArticleimpl(){
		return this.articleimpl;
	}
	public void setArticleimpl(ArticleImpl articleimpl){
		this.articleimpl = articleimpl;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> commentMap = new HashMap<String,Object>();
		commentMap.put("idContent",getIdContent());
		commentMap.put("comment",getComment());
		commentMap.put("commentAuthor",getCommentAuthor());
		commentMap.put("eventorganizerimpl",getEventorganizerimpl());
		commentMap.put("customerimpl",getCustomerimpl());
		commentMap.put("articleimpl",getArticleimpl());

        return commentMap;
    }

}
