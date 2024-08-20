package com.zykaExpress.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zykaExpress.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	// user login
	Optional<User> findByEmailAndPassword(String email, String password);

	// find user by id
	Optional<User> findById(Integer userid);
	
	@Query("select u from User u where u.email=?1")
	Optional<User> findByEmail(String email);
	
	@Query("select u from User u where u.role='CUSTOMER'")
	List<User> findAllCustomer();
	
	@Query("select u from User u where u.role='DELIVERYBOY'")
	List<User> findAllDeliveryBoy();
	
	@Query("select u from User u where u.role='RESTAURANT'")
	List<User> findAllRestaurant();
	
	@Query("select u from User u where u.id=?1")
	User findByUserId(int userId);

	@Query("select u from User u where u.role='RESTAURANT' and u.status='ACTIVE'")
	List<User> findByActiveRestaurent();
}
