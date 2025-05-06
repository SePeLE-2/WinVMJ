package TicketingSystem.socialmedia.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface SocialMediaResource {
    List<HashMap<String,Object>> saveSocialMedia(VMJExchange vmjExchange);
    HashMap<String, Object> updateSocialMedia(VMJExchange vmjExchange);
    HashMap<String, Object> getSocialMedia(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllSocialMedia(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteSocialMedia(VMJExchange vmjExchange);
	HashMap<String, Object> SocialMedia(VMJExchange vmjExhange);
}
