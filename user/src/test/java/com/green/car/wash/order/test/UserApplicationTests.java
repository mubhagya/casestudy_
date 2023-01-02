package com.green.car.wash.order.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.green.car.wash.user.Repository.RatingRepo;
import com.green.car.wash.user.Repository.UserRepo;
import com.green.car.wash.user.controller.UserController;
import com.green.car.wash.user.model.OrderDetails;
import com.green.car.wash.user.model.Ratings;
import com.green.car.wash.user.service.userService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserApplicationTests {

	@MockBean
	UserRepo ur;
	@Autowired
	userService us;
//	@Test
	/*
	 * public void UserSpecificRatingTest() {
	 * when(ur.findAll()).thenReturn(Stream.of(new
	 * OrderDetails("123","clean@gmail.com","sam","cleanwash","234555"), new
	 * OrderDetails("124","cccc@gmail.com","200","aaaa","2345678")
	 * ).collect(Collectors.toList()));
	 * assertEquals(2,service.CustomerSpecific("123").size()); }
	 */

	}
	

