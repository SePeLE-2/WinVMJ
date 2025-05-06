package TicketingSystem.socialmedia.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class SocialMediaResourceDecorator extends SocialMediaResourceComponent{
	protected SocialMediaResourceComponent record;

    public SocialMediaResourceDecorator(SocialMediaResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveSocialMedia(VMJExchange vmjExchange){
		return record.saveSocialMedia(vmjExchange);
	}

    public SocialMedia createSocialMedia(VMJExchange vmjExchange){
		return record.createSocialMedia(vmjExchange);
	}

    public SocialMedia createSocialMedia(VMJExchange vmjExchange, int id){
		return record.createSocialMedia(vmjExchange, id);
	}

    public HashMap<String, Object> updateSocialMedia(VMJExchange vmjExchange){
		return record.updateSocialMedia(vmjExchange);
	}

    public HashMap<String, Object> getSocialMedia(VMJExchange vmjExchange){
		return record.getSocialMedia(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllSocialMedia(VMJExchange vmjExchange){
		return record.getAllSocialMedia(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteSocialMedia(VMJExchange vmjExchange){
		return record.deleteSocialMedia(vmjExchange);
	}

}
