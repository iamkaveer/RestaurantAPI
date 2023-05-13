package com.restaurantAPI.restaurant.repository;

import com.restaurantAPI.restaurant.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRestaurantRepo extends JpaRepository<Restaurant,Integer> {
    @Query(value = "SELECT * FROM tbl_rest WHERE restaurant_id = :id", nativeQuery = true)
    Restaurant findByRestId(Integer id);
}
