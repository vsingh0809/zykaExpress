package com.zykaExpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zykaExpress.dto.ResponseDto;
import com.zykaExpress.service.DeliveryServiceImpl;
import com.zykaExpress.service.RestaurentServiceImpl;

@RestController
@RequestMapping("/resto")
public class RestaurentController 
{	
	@Autowired
	private RestaurentServiceImpl restoService;
	
	@Autowired
	private DeliveryServiceImpl deliveryService;
	
	@GetMapping("/allOrders/{restId}")
	public ResponseEntity<?> getAllOrders(@PathVariable int restId)
	{
		return new ResponseEntity<>(new ResponseDto<>("success",restoService.getAllPlacedOrders(restId)),HttpStatus.OK);
				//ResponseEntity.ok(restoService.getAllPlacedOrders(restId));
	}
	
	@GetMapping("/allAcceptedOrders/{restId}")
	public ResponseEntity<?> getAllAcceptedOrders(@PathVariable int restId)
	{
		return new ResponseEntity<>(new ResponseDto<>("success",restoService.getAllAcceptedOrders(restId)),HttpStatus.OK);
				//ResponseEntity.ok(restoService.getAllPlacedOrders(restId));
	}
	
	//@R
	@GetMapping("/allAcceptedOrdersPayment/{restId}")
	public ResponseEntity<?> getAllAcceptedOrdersPayment(@PathVariable int restId)
	{
		return new ResponseEntity<>(new ResponseDto<>("success",restoService.getAllAcceptedOrdersPayment(restId)),HttpStatus.OK);
				//ResponseEntity.ok(restoService.getAllPlacedOrders(restId));
	}
	
	@PutMapping("/updateStatus/{orderId}/{status}")
	public ResponseEntity<?> updateStatus(@PathVariable String status , @PathVariable int orderId){
		
		return new ResponseEntity<>(new ResponseDto<>("success",deliveryService.updateStatus(orderId, status)),HttpStatus.OK);
	}
	
	@GetMapping("/allRatings/{restId}")
	public ResponseEntity<?> getAllRating(@PathVariable int restId)
	{
		return ResponseEntity.ok().body(new ResponseDto<>("Success" ,restoService.getAllRatings(restId) ));
				//ResponseEntity.ok(restoService.getAllRatings(restId));
	}
	
	@GetMapping("/allMenus/{restId}")
	public ResponseEntity<?> getAllMenusRating(@PathVariable int restId)
	{
		return ResponseEntity.ok(restoService.getAllMenus(restId));
	}
	
}
