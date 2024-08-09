package com.zykaExpress.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zykaExpress.custom_excpetions.InvalidCredentialsException;
import com.zykaExpress.model.Restaurant;
import com.zykaExpress.repository.RestaurantRepository;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public String createRestaurant(Restaurant restaurant) {
		restaurantRepository.save(restaurant);
		return "your restaurant created";
	}

	@Override
	public Restaurant updateRestaurant(Long id, Restaurant restaurantDetails) {
		Restaurant existingRestaurant=restaurantRepository.findById(id).orElseThrow(()->new InvalidCredentialsException("id is not valid"));
		existingRestaurant.setName(restaurantDetails.getName());
		 existingRestaurant.setCuisineType(restaurantDetails.getCuisineType());
         existingRestaurant.setDescription(restaurantDetails.getDescription());
         existingRestaurant.setName(restaurantDetails.getName());
         existingRestaurant.setNumRating(restaurantDetails.getNumRating());
         existingRestaurant.setOpen(restaurantDetails.getOpen());
         existingRestaurant.setOpeningHours(restaurantDetails.getOpeningHours());
         existingRestaurant.setRegistrationDate(restaurantDetails.getRegistrationDate());
         //existingRestaurant.setAddressId(restaurantDetails.getAddressId());
         //existingRestaurant.setOwnerId(restaurantDetails.getOwnerId());
		
		return existingRestaurant;
	}

	@Override
	public Optional<Restaurant> getRestaurant(Long id) {
		
		return restaurantRepository.findById(id);
	}

	@Override
	public String deleteRestaurant(Long id) {
		// TODO Auto-generated method stub
		restaurantRepository.deleteById(id);
		return "your restaurant deleted";
	}

}
