package com.zykaExpress.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zykaExpress.dto.CartDto;
import com.zykaExpress.dto.ResponseDto;
import com.zykaExpress.entities.Cart;
import com.zykaExpress.service.CartServiceImpl;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartServiceImpl cartService;

	// add to cart
	@PostMapping("/add")
	public ResponseEntity<?> addToCart(@RequestBody CartDto cartDto) {
		Integer menuId = cartDto.getMenuId();
		Integer quantity = cartDto.getQuantity();
		Integer userId = cartDto.getUserId();

		return new ResponseEntity<>(new ResponseDto<>("success", cartService.addItemToCart(menuId, quantity, userId)),
				HttpStatus.CREATED);
	}

	// get all contents of cart by userId
	@GetMapping("/all/{userId}")
	public ResponseEntity<?> getCartContents(@PathVariable Integer userId) {
		List<Cart> cartItems = cartService.getAllCartContents(userId);
		return new ResponseEntity<>(new ResponseDto<>("success", cartItems), HttpStatus.OK);
	}

	// remove from cart
	@DeleteMapping("/delete/{cartId}")
	public ResponseEntity<?> removeFromCart(@PathVariable int cartId) {
		String MenuName = cartService.findById(cartId).get().getSelectedMenu().getProductName();
		cartService.deleteFromCart(cartId);
		return new ResponseEntity<>(new ResponseDto<>("success", MenuName + " removed from cart"), HttpStatus.OK);
	}

	// remove all from cart
	@DeleteMapping("/delete/all/{userId}")
	public ResponseEntity<?> removeAllFromCart(@PathVariable int userId) {
		cartService.deleteAllFromCart(userId);
		return new ResponseEntity<>(new ResponseDto<>("success", "Cart destroyed for user with userId: " + userId),
				HttpStatus.OK);
	}

	// Update Quantity
	@PutMapping("/update")
	public ResponseEntity<?> updateQuantity(@RequestBody HashMap<String, Integer> map) {
		Integer cartId = map.get("cartId");
		Integer quantity = map.get("quantity");
		String message = cartService.updateQuantity(cartId, quantity);
		Cart updatedCart = cartService.findById(cartId).get();
		return new ResponseEntity<>(new ResponseDto<>(message, updatedCart), HttpStatus.ACCEPTED);
	}
}
