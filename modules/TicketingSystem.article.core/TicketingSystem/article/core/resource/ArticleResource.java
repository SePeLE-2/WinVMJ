package TicketingSystem.article.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ArticleResource {
    HashMap<String,Object> saveArticle(VMJExchange vmjExchange);
    HashMap<String, Object> updateArticle(VMJExchange vmjExchange);
    HashMap<String, Object> getArticle(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllArticle(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteArticle(VMJExchange vmjExchange);

}
