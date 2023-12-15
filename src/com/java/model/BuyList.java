package com.java.model;

import java.util.Date;

public class BuyList {
    private Integer id;

    private Integer buyId;
    private Buy buy;
    private Integer thingId;
    private Thing thing;
    private String desknum;
    private Integer numMax;
	private String address;
	private String color;
	private String size;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getNumMax() {
		return numMax;
	}

	public void setNumMax(Integer numMax) {
		this.numMax = numMax;
	}

	public String getDesknum() {
		return desknum;
	}
	public void setDesknum(String desknum) {
		this.desknum = desknum;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBuyId() {
		return buyId;
	}
	public void setBuyId(Integer buyId) {
		this.buyId = buyId;
	}
	public Buy getBuy() {
		return buy;
	}
	public void setBuy(Buy buy) {
		this.buy = buy;
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
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	private Integer num;

}