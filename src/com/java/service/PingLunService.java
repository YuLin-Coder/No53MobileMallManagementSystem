package com.java.service;



import java.util.List;

import com.java.model.*;

public interface PingLunService {

	public int Add(PingLun j);
	public PingLun GetByID(int id);
	public int Del(int id);
	public List<PingLun> GetByThingID(int jid);
	public List<PingLun> GetByClientID(int cid);
}
