package com.green.car.wash.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.green.car.wash.admin.model.*;

import java.util.Arrays;


@Service
public class AdminService {
	@Autowired
	private RestTemplate restTemplate;

	// Url to access the methods of Order Service
	String url1 = "http://ORDER-SERVICE/orders";
	

	/** Order controls through admin using rest template */
	// To assign a washer to the order by Admin
	public OrderDetails assignWasher(OrderDetails orderDetails) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<OrderDetails> assignedWasher = new HttpEntity<>(orderDetails, headers);
		return restTemplate.exchange(url1 + "/assignWasher", HttpMethod.PUT, assignedWasher, OrderDetails.class)
				.getBody();
	}

	
}