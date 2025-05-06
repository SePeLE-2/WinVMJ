package TicketingSystem.socialmedia.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class SocialMediaServiceComponent implements SocialMediaService{
	protected RepositoryUtil<SocialMedia> Repository;

    public SocialMediaServiceComponent(){
        this.Repository = new RepositoryUtil<SocialMedia>(TicketingSystem.socialmedia.core.SocialMediaComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveSocialMedia(VMJExchange vmjExchange);
    public abstract SocialMedia createSocialMedia(Map<String, Object> requestBodye);
	public abstract SocialMedia createSocialMedia(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateSocialMedia(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getSocialMedia(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllSocialMedia(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<SocialMedia> List);
    public abstract List<HashMap<String,Object>> deleteSocialMedia(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getSocialMediaById(int id);

}
