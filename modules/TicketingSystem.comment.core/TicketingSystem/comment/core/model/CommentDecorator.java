package TicketingSystem.comment.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages
import TicketingSystem.eventorganizer.core.*;
import TicketingSystem.customer.core.*;
import TicketingSystem.article.core.*;

@MappedSuperclass
public abstract class CommentDecorator extends CommentComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected CommentComponent record;

	public CommentDecorator () {
		super();
		this.record = record;
		this.idContent =  idContent.randomUUID();
	}
		
	public CommentDecorator (CommentComponent record) {
		this.idContent =  idContent.randomUUID();
		this.record = record;
	}

	public CommentDecorator (UUID idContent, CommentComponent record) {
		this.idContent =  idContent;
		this.record = record;
	}
	
	public CommentDecorator (CommentComponent record, String objectName) {
		this.idContent =  idContent.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}


	public UUID getIdContent() {
		return record.getIdContent();
	}
	public void setIdContent(UUID idContent) {
		record.setIdContent(idContent);
	}
	public String getComment() {
		return record.getComment();
	}
	public void setComment(String comment) {
		record.setComment(comment);
	}
	public String getCommentAuthor() {
		return record.getCommentAuthor();
	}
	public void setCommentAuthor(String commentAuthor) {
		record.setCommentAuthor(commentAuthor);
	}
	public EventOrganizer getEventorganizerimpl(){
		return record.getEventorganizerimpl();
	}
	public void setEventorganizerimpl(EventOrganizer eventorganizerimpl){
		record.setEventorganizerimpl(eventorganizerimpl);
	}
	
	public Customer getCustomerimpl(){
		return record.getCustomerimpl();
	}
	public void setCustomerimpl(Customer customerimpl){
		record.setCustomerimpl(customerimpl);
	}
	
	public Article getArticleimpl(){
		return record.getArticleimpl();
	}
	public void setArticleimpl(Article articleimpl){
		record.setArticleimpl(articleimpl);
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
