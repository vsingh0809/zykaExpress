package com.zykaExpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zykaExpress.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

	
	
}
