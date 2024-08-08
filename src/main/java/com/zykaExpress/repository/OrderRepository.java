package com.zykaExpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zykaExpress.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
