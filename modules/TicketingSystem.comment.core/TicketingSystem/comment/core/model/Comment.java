package TicketingSystem.comment.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Comment {
	public int getIdContent();
	public void setIdContent(int idContent);
	public String getComment();
	public void setComment(String comment);
	public String getCommentAuthor();
	public void setCommentAuthor(String commentAuthor);
	public EventOrganizerImpl getEventorganizerimpl();
	public void setEventorganizerimpl(EventOrganizerImpl eventorganizerimpl);
	public CustomerImpl getCustomerimpl();
	public void setCustomerimpl(CustomerImpl customerimpl);
	public ArticleImpl getArticleimpl();
	public void setArticleimpl(ArticleImpl articleimpl);
	HashMap<String, Object> toHashMap();
}
