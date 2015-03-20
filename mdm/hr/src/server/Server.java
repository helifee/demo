package server;

import javax.xml.ws.Endpoint;

import test.impl.TestServiceImpl;

public class Server {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/hr/ws", new TestServiceImpl());
		System.out.println("http://localhost:8080/hr/ws");
	}
}
