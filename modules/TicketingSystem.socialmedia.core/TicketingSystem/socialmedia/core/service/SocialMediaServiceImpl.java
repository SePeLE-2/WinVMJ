package TicketingSystem.socialmedia.core;
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
import TicketingSystem.socialmedia.SocialMediaFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

public class SocialMediaServiceImpl extends SocialMediaServiceComponent{

    public List<HashMap<String,Object>> saveSocialMedia(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		SocialMedia socialmedia = createSocialMedia(vmjExchange);
		socialmediaRepository.saveObject(socialmedia);
		return getAllSocialMedia(vmjExchange);
	}

    public SocialMedia createSocialMedia(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id");
		int id = Integer.parseInt(idStr);
		String platform = (String) requestBody.get("platform");
		String username = (String) requestBody.get("username");
		String url = (String) requestBody.get("url");
		
		//to do: fix association attributes
		SocialMedia SocialMedia = SocialMediaFactory.createSocialMedia(
			"TicketingSystem.socialmedia.core.SocialMediaImpl",
		id
		, platform
		, username
		, url
		, eventorganizerimpl
		);
		Repository.saveObject(socialmedia);
		return socialmedia;
	}

    public SocialMedia createSocialMedia(Map<String, Object> requestBody, int id){
		String platform = (String) vmjExchange.getRequestBodyForm("platform");
		String username = (String) vmjExchange.getRequestBodyForm("username");
		String url = (String) vmjExchange.getRequestBodyForm("url");
		
		//to do: fix association attributes
		
		SocialMedia socialmedia = SocialMediaFactory.createSocialMedia("TicketingSystem.socialmedia.core.SocialMediaImpl", platform, username, url, eventorganizerimpl);
		return socialmedia;
	}

    public HashMap<String, Object> updateSocialMedia(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id");
		int id = Integer.parseInt(idStr);
		SocialMedia socialmedia = Repository.getObject(id);
		
		socialmedia.setPlatform((String) requestBody.get("platform"));
		socialmedia.setUsername((String) requestBody.get("username"));
		socialmedia.setUrl((String) requestBody.get("url"));
		
		Repository.updateObject(socialmedia);
		
		//to do: fix association attributes
		
		return socialmedia.toHashMap();
		
	}

    public HashMap<String, Object> getSocialMedia(Map<String, Object> requestBody){
		List<HashMap<String, Object>> socialmediaList = getAllSocialMedia("socialmedia_impl");
		for (HashMap<String, Object> socialmedia : socialmediaList){
			int record_id = ((Double) socialmedia.get("record_id")).intValue();
			if (record_id == id){
				return socialmedia;
			}
		}
		return null;
	}

	public HashMap<String, Object> getSocialMediaById(int id){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		SocialMedia socialmedia = socialmediaRepository.getObject(id);
		return socialmedia.toHashMap();
	}

    public List<HashMap<String,Object>> getAllSocialMedia(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<SocialMedia> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<SocialMedia> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteSocialMedia(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllSocialMedia(requestBody);
	}

}
