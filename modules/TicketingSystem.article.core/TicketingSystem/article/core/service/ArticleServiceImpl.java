package TicketingSystem.article.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import TicketingSystem.article.ArticleFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

public class ArticleServiceImpl extends ArticleServiceComponent{

    public List<HashMap<String,Object>> saveArticle(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Article article = createArticle(vmjExchange);
		articleRepository.saveObject(article);
		return getAllArticle(vmjExchange);
	}

    public Article createArticle(Map<String, Object> requestBody){
		String idArticleStr = (String) requestBody.get("idArticle");
		int idArticle = Integer.parseInt(idArticleStr);
		String articleTitle = (String) requestBody.get("articleTitle");
		String articleContent = (String) requestBody.get("articleContent");
		String articleAuthor = (String) requestBody.get("articleAuthor");
		String articleDatePublished = (String) requestBody.get("articleDatePublished");
		
		//to do: fix association attributes
		Article Article = ArticleFactory.createArticle(
			"TicketingSystem.article.core.ArticleImpl",
		idArticle
		, articleTitle
		, articleContent
		, articleAuthor
		, articleDatePublished
		, eventorganizerimpl
		);
		Repository.saveObject(article);
		return article;
	}

    public Article createArticle(Map<String, Object> requestBody, int id){
		String articleTitle = (String) vmjExchange.getRequestBodyForm("articleTitle");
		String articleContent = (String) vmjExchange.getRequestBodyForm("articleContent");
		String articleAuthor = (String) vmjExchange.getRequestBodyForm("articleAuthor");
		String articleDatePublished = (String) vmjExchange.getRequestBodyForm("articleDatePublished");
		
		//to do: fix association attributes
		
		Article article = ArticleFactory.createArticle("TicketingSystem.article.core.ArticleImpl", articleTitle, articleContent, articleAuthor, articleDatePublished, eventorganizerimpl);
		return article;
	}

    public HashMap<String, Object> updateArticle(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idArticle");
		int id = Integer.parseInt(idStr);
		Article article = Repository.getObject(id);
		
		article.setArticleTitle((String) requestBody.get("articleTitle"));
		article.setArticleContent((String) requestBody.get("articleContent"));
		article.setArticleAuthor((String) requestBody.get("articleAuthor"));
		article.setArticleDatePublished((String) requestBody.get("articleDatePublished"));
		
		Repository.updateObject(article);
		
		//to do: fix association attributes
		
		return article.toHashMap();
		
	}

    public HashMap<String, Object> getArticle(Map<String, Object> requestBody){
		List<HashMap<String, Object>> articleList = getAllArticle("article_impl");
		for (HashMap<String, Object> article : articleList){
			int record_id = ((Double) article.get("record_id")).intValue();
			if (record_id == id){
				return article;
			}
		}
		return null;
	}

	public HashMap<String, Object> getArticleById(int id){
		String idStr = vmjExchange.getGETParam("idArticle"); 
		int id = Integer.parseInt(idStr);
		Article article = articleRepository.getObject(id);
		return article.toHashMap();
	}

    public List<HashMap<String,Object>> getAllArticle(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Article> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Article> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteArticle(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllArticle(requestBody);
	}

	public void publish() {
		// TODO: implement this method
	}
}
