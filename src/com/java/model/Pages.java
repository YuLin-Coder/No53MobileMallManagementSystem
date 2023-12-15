package com.java.model;

public class Pages {
	private int startindex=0;
	private int pagesize=20;
	private int sum;
	public int getSum() {
		return startindex*pagesize;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	private String key="";
	private String order="id desc";
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public int getStartindex() {
		return startindex;
	}
	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
}
