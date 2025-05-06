package TicketingSystem.comment.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class CommentDecorator extends CommentComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected CommentComponent record;

	public CommentDecorator () {
		super();
		this.record = record;
		this.idContent =  idContent.randomUUID();
		
	public CommentDecorator (CommentComponent record) {
		this.idContent =  idContent.randomUUID();
		this.record = record;
	}

	public CommentDecorator (int idContent, CommentComponent record) {
		this.idContent =  idContent;
		this.record = record;
	}
	
	public CommentDecorator (CommentComponent record, String objectName) {
		this.idContent =  idContent.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public CommentDecorator() { }

	public int getIdContent() {
		return record.getIdContent();
	}
	public void setIdContent(int idContent) {
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


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
