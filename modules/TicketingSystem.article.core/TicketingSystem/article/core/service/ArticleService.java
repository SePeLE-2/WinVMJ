package TicketingSystem.article.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ArticleService {
	Article createArticle(Map<String, Object> requestBody);
	Article createArticle(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getArticle(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveArticle(Map<String, Object> requestBody);
    HashMap<String, Object> updateArticle(Map<String, Object> requestBody);
    HashMap<String, Object> getArticleById(int id);
    List<HashMap<String,Object>> getAllArticle(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteArticle(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Article> List);
}
