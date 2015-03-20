package uap.sample;

import uap.sample.ISampleService;

public class SampleServiceImpl implements ISampleService {

	@Override
	public String query(String id) {
		return "Hello, " + id;
	}

}
