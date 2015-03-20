package com.ufida.hellospringdm;

import com.ufida.timeservice.TimeService;

public class HelloSpringDM {

	private TimeService timeService;

	public TimeService getTimeService() {
		return timeService;
	}

	public void setTimeService(TimeService timeService) {
		this.timeService = timeService;
	}
	
	public void start() {
		System.out.println("started at " + timeService.getCurrentTime());
	}

	public void stop() {
		System.out.println("stopped at " + timeService.getCurrentTime());
	}
}
