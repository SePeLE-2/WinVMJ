package TicketingSystem.article.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Article {
	public void publish();
	public void setArticleTitle(String title);
	public void setArticleContent(String content);
	public void setArticleAuthor(String author);
	public void setArticleDatePublished(String date);
	HashMap<String, Object> toHashMap();
}
