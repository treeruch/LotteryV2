package com.app.teeruch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.teeruch.Repository.LotteryRepository;
import com.app.teeruch.model.LotteryModel;



@Service
public class LotterService {

	
	@Autowired
	private LotteryRepository lotteryRepository;
	
	public LotteryModel findDashboard() {
		return lotteryRepository.findDashboard();
		
	}
}
