package TicketingSystem.socialmedia.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="socialmedia_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SocialMediaComponent implements SocialMedia{
	@Id
	protected int id; 
	protected String platform;
	protected String username;
	protected String url;
	@ManyToOne(targetEntity=TicketingSystem..core.Component.class)
	public  eventorganizerimpl;
	protected String objectName = SocialMediaComponent.class.getName();

	public SocialMediaComponent() {

	} 

	public SocialMediaComponent(
        int id, String platform, String username, String url, EventOrganizerImpl eventorganizerimpl
    ) {
        this.id = id;
        this.platform = platform;
        this.username = username;
        this.url = url;
        this.eventorganizerimpl = eventorganizerimpl;
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getPlatform() {
		return this.platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public abstract EventOrganizerImpl getEventorganizerimpl();
	public abstract void setEventorganizerimpl(EventOrganizerImpl eventorganizerimpl);
	
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " platform='" + getPlatform() + "'" +
            " username='" + getUsername() + "'" +
            " url='" + getUrl() + "'" +
            " eventorganizerimpl='" + getEventorganizerimpl() + "'" +
            "}";
    }
	
}
