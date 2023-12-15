package com.java.model;

import java.util.Date;

public class Buy {
    private Integer id;

    private Integer clientId;

    private Date intime;
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Date getIntime() {
		return intime;
	}

	public void setIntime(Date intime) {
		this.intime = intime;
	}


	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String[] getStates() {
		return states;
	}

	public void setStates(String[] states) {
		this.states = states;
	}

	private Integer state;
    private Client client;
    private String stateText;
    private Pages page;
    public Pages getPage() {
		return page;
	}

	public void setPage(Pages page) {
		this.page = page;
	}

	String[] states = { "<span style='color:blue'>待发货</span>",  "<span style='color:Green'>已发货</span>",  "<span style='color:Green'>已签收</span>" };
    public String getStateText() {
		return states[state];
	}

	public void setStateText(String stateText) {
		this.stateText = stateText;
	}

	
}