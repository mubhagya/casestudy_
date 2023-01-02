package com.green.car.wash.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.green.car.wash.admin.model.*;
import com.green.car.wash.admin.service.AdminService;
import com.green.car.wash.admin.service.WashPackService;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admins")
public class AdminController {
	@Autowired
	AdminService as;
	@Autowired
	WashPackService wps;

	/** Washer controls through admin using service object */
	// To find all the washpack
	@GetMapping("/findallWP")
	public List<WashPacks> findallWP() {
		return wps.findallWP();
	}

	// To find one WashPack with ID
	@GetMapping("/findoneWP/{id}")
	public ResponseEntity<WashPacks> findoneWP(@PathVariable String id) {
		return wps.findoneWP(id);
	}

	// To add a new WashPack
	@PostMapping("/addWP")
	public WashPacks addWP(@RequestBody WashPacks washPacks) {
		return wps.addWP(washPacks);
	}

	// To delete a Washpack
	@DeleteMapping("/deleteWP/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteWP(@PathVariable String id) {
		return wps.deleteWP(id);
	}

	// To update a Washpack
	@PutMapping("/updateWP/{id}")
	public ResponseEntity<WashPacks> updateWP(@PathVariable String id, @RequestBody WashPacks washPacks) {
		return wps.updateWP(id, washPacks);
	}

	// To find washpack with washpack name 
	@GetMapping("/wpbyname/{name}")
	public WashPacks wpbyname(@PathVariable String name) {
		return wps.findbyname(name);
	}

	/** Order controls through admin using rest template */
	// To assign a washer to the order by Admin
	@PutMapping("/assignWasher")
	public OrderDetails assignWasher(@RequestBody OrderDetails orderDetails) {
		return as.assignWasher(orderDetails);
	}
	
}
