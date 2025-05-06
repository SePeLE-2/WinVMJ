package TicketingSystem.socialmedia.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import TicketingSystem.socialmedia.SocialMediaFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class SocialMediaResourceImpl extends SocialMediaResourceComponent{
	
	private SocialMediaServiceImpl socialmediaServiceImpl = new SocialMediaServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/socialmedia/save")
    public List<HashMap<String,Object>> saveSocialMedia(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		SocialMedia socialmedia = createSocialMedia(vmjExchange);
		socialmediaRepository.saveObject(socialmedia);
		return getAllSocialMedia(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/socialmedia")
    public HashMap<String,Object> socialmedia(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			SocialMedia result = socialmediaServiceImpl.createSocialMedia(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public SocialMedia createSocialMedia(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			SocialMedia result = socialmediaServiceImpl.createSocialMedia(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public SocialMedia createSocialMedia(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			SocialMedia result = socialmediaServiceImpl.createSocialMedia(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/socialmedia/update")
    public HashMap<String, Object> updateSocialMedia(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return socialmediaServiceImpl.updateSocialMedia(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/socialmedia/detail")
    public HashMap<String, Object> getSocialMedia(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return socialmediaServiceImpl.getSocialMedia(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/socialmedia/list")
    public List<HashMap<String,Object>> getAllSocialMedia(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return socialmediaServiceImpl.getAllSocialMedia(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/socialmedia/delete")
    public List<HashMap<String,Object>> deleteSocialMedia(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return socialmediaServiceImpl.deleteSocialMedia(requestBody);
	}


}
