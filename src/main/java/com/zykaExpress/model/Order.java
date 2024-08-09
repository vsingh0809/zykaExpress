 package com.zykaExpress.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private User customer;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @Column(name = "order_status", nullable = false)
    private String orderStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

	/*
	 * @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval =
	 * true) private List<OrderItem> items;
	 */

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "payment_id", nullable = false) private Payment payment;
	 */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "total_item", nullable = false)
    private Integer totalItem;

    @Column(name = "total_price", nullable = false)
    private Double totalPrice;
}
