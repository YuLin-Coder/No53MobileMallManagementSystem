package com.java.model;

import java.util.Date;

public class PingLun {
    private Integer id;

    private Integer thingId;
    private Thing thing;
    private Client client;
    

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	private Integer clinetId;

    private String title;

    private Date intime;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Integer getThingId() {
		return thingId;
	}

	public void setThingId(Integer thingId) {
		this.thingId = thingId;
	}

	public Thing getThing() {
		return thing;
	}

	public void setThing(Thing thing) {
		this.thing = thing;
	}

	public Integer getClinetId() {
        return clinetId;
    }

    public void setClinetId(Integer clinetId) {
        this.clinetId = clinetId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}