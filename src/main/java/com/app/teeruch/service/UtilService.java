package com.app.teeruch.service;

import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

@Service
public class UtilService {

	public String formatPrice(int sumTopThree) {
		String number = String.valueOf(sumTopThree);
		double amount = Double.parseDouble(number);
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		return formatter.format(amount);
	}
}
