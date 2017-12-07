package com.fufang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

	@Autowired
	private DiscoveryClient client;

	// call service-B
	@RequestMapping(value = "/cliadd", method = RequestMethod.GET)
	public String cliadd(@RequestParam Integer a, @RequestParam Integer b) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:7778/add?a=" + a + "&b=" + b, String.class);
	}

}
