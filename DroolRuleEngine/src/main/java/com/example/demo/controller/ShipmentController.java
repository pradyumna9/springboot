package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Shipment;

@RestController
@RequestMapping("/start")
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
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
	@GetMapping("/shipments")
	public List<Shipment> getShipments() {
		
		Shipment shipment1 = new Shipment("Mobile", 12, 12000);
		Shipment shipment2 = new Shipment("Bike", 2, 123000);
		Shipment shipment3 = new Shipment("Headphone", 19, 876);
		List<Shipment> shipmentList = new ArrayList<Shipment>();
		shipmentList.add(shipment1);
		shipmentList.add(shipment2);
		shipmentList.add(shipment3);
		return shipmentList;
	}
}
