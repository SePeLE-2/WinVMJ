package TicketingSystem.socialmedia.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface SocialMediaService {
	SocialMedia createSocialMedia(Map<String, Object> requestBody);
	SocialMedia createSocialMedia(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getSocialMedia(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveSocialMedia(Map<String, Object> requestBody);
    HashMap<String, Object> updateSocialMedia(Map<String, Object> requestBody);
    HashMap<String, Object> getSocialMediaById(int id);
    List<HashMap<String,Object>> getAllSocialMedia(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteSocialMedia(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<SocialMedia> List);
}
