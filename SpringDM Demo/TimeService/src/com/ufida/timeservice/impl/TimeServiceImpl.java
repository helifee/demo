package com.ufida.timeservice.impl;

import java.util.Date;

import com.ufida.timeservice.TimeService;

public class TimeServiceImpl implements TimeService {

	@Override
	public String getCurrentTime() {
		return (new Date()).toString();
	}

}
