package com.zaykaExpress.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "cuisine_type")
    private String cuisineType;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Embedded
  //    private ContactInformation contactInformation;

    @Column(name = "opening_hours")
    private String openingHours;

    //@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
   // private List<Review> reviews;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    @Column(name = "num_rating")
    private Integer numRating;

    @ElementCollection
    @CollectionTable(name = "restaurant_images", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "image_url")
    private List<String> images;

    @Temporal(TemporalType.DATE)
    @Column(name = "registration_date", nullable = false)
    private Date registrationDate;

    @Column(name = "open", nullable = false)
    private Boolean open;

	/*
	 * @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval
	 * = true) private List<Food> foods;
	 */
}
