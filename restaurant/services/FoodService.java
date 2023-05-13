package com.restaurantAPI.restaurant.services;

import com.restaurantAPI.restaurant.models.Food;
import com.restaurantAPI.restaurant.repository.IFoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private IFoodRepo iFoodRepo;

    //create a food
    public Food addFood(Food food){
        return iFoodRepo.save(food);
    }

    //get all food
    public List<Food> getAllFood(){
        return iFoodRepo.findAll();
    }


    public Food findByID(Integer id) {
        return iFoodRepo.findFoodById(id);
    }

    public void deleteRestById(Integer id) {
        iFoodRepo.deleteById(id);
    }

    public void updateFood(Food newFood, Food existedFood) {
        existedFood.setFoodId(newFood.getFoodId());
        existedFood.setName(newFood.getName());
        existedFood.setPrice(newFood.getPrice());
        iFoodRepo.save(existedFood);
    }
}
