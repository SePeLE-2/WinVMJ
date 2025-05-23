package TicketingSystem.article.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ArticleService {
	HashMap<String, Object> saveArticle(Map<String, Object> requestBody);
	// HashMap<String, Object> getArticle(Map<String, Object> requestBody);
    HashMap<String, Object> updateArticle(Map<String, Object> requestBody);
    Article getArticleById(UUID id);
    List<HashMap<String,Object>> getAllArticle(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteArticle(Map<String, Object> requestBody);
}
