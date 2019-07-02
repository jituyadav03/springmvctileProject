package com.vserv.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vserv.sample.model.StatusUpdate;
import com.vserv.sample.model.StatusUpdateDao;

@Service
public class StatusUpdateService {
	
	@Autowired
	private StatusUpdateDao statusUpdateDao;
	
	public void save(StatusUpdate statusUpdate) {
		statusUpdateDao.save(statusUpdate);
	}
	
	public StatusUpdate getLatest() {
		return statusUpdateDao.findFirstByOrderByAddedDesc();
	}
}
