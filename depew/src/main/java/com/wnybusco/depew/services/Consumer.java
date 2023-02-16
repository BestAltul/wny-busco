package com.wnybusco.depew.services;

import org.springframework.web.client.RestTemplate;

public class Consumer {
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		
		String url = "https://api2.smartwitness.co/SmartWitness/RESTCommandWebService/ExecuteServerCommand/Devices/Get?RecorderID=T0MAY2100663";
		String response = restTemplate.getForObject(url,String.class);
		
		System.out.print(response);
	}

}
