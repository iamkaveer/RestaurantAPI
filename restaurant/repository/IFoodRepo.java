package com.restaurantAPI.restaurant.repository;

import com.restaurantAPI.restaurant.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IFoodRepo extends JpaRepository<Food,Integer> {
    @Query(value = "SELECT * FROM tbl_food WHERE food_id = :id", nativeQuery = true)
    Food findFoodById(Integer id);
}
