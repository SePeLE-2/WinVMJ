package TicketingSystem.socialmedia.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class SocialMediaDecorator extends SocialMediaComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected SocialMediaComponent record;

	public SocialMediaDecorator () {
		super();
		this.record = record;
		this.id =  id.randomUUID();
		
	public SocialMediaDecorator (SocialMediaComponent record) {
		this.id =  id.randomUUID();
		this.record = record;
	}

	public SocialMediaDecorator (int id, SocialMediaComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public SocialMediaDecorator (SocialMediaComponent record, String objectName) {
		this.id =  id.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public SocialMediaDecorator() { }

	public int getId() {
		return record.getId();
	}
	public void setId(int id) {
		record.setId(id);
	}
	public String getPlatform() {
		return record.getPlatform();
	}
	public void setPlatform(String platform) {
		record.setPlatform(platform);
	}
	public String getUsername() {
		return record.getUsername();
	}
	public void setUsername(String username) {
		record.setUsername(username);
	}
	public String getUrl() {
		return record.getUrl();
	}
	public void setUrl(String url) {
		record.setUrl(url);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
