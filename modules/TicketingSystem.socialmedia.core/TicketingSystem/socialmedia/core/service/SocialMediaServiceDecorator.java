package TicketingSystem.socialmedia.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class SocialMediaServiceDecorator extends SocialMediaServiceComponent{
	protected SocialMediaServiceComponent record;

    public SocialMediaServiceDecorator(SocialMediaServiceComponent record) {
        this.record = record;
    }

	public SocialMediaImpl createSocialMedia(Map<String, Object> requestBody){
		return record.createSocialMedia(requestBody);
	}

    public SocialMedia createSocialMedia(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createSocialMedia(requestBody, response);
	}

	public HashMap<String, Object> getSocialMedia(Map<String, Object> requestBody){
		return record.getSocialMedia(requestBody);
	}

	public List<HashMap<String,Object>> getAllSocialMedia(Map<String, Object> requestBody){
		return record.getAllSocialMedia(requestBody);
	}

    public List<HashMap<String,Object>> saveSocialMedia(VMJExchange vmjExchange){
		return record.saveSocialMedia(vmjExchange);
	}

    public HashMap<String, Object> updateSocialMedia(Map<String, Object> requestBody){
		return record.updateSocialMedia(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<SocialMedia> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteSocialMedia(Map<String, Object> requestBody){
		return record.deleteSocialMedia(requestBody);
	}

	public HashMap<String, Object> getSocialMediaById(int id){
        return record.getSocialMediaById(id);
    }

}
