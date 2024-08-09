package com.zykaExpress.service;

import java.util.Optional;

import com.zykaExpress.model.Restaurant;


public interface RestaurantService {
	String createRestaurant(Restaurant restaurant);
	Restaurant updateRestaurant(Long id ,Restaurant restaurant);
	Optional<Restaurant> getRestaurant(Long id);
	String deleteRestaurant(Long  id);

}
