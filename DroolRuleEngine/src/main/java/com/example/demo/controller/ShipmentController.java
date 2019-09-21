package com.example.demo.controller;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Shipment;

@RestController
@RequestMapping("/start")
public class ShipmentController {

	@Autowired
	private KieSession kieSession;
	
	@PostMapping("/rest")
	public Shipment ship(@RequestBody Shipment shipment) {
		kieSession.insert(shipment);
		kieSession.fireAllRules();
		return shipment;
	}
	@RequestMapping("/test")
	public String get() {
		return "test";
	}
}
