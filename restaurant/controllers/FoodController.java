package com.restaurantAPI.restaurant.controllers;

import com.restaurantAPI.restaurant.exception.ErrorResponse;
import com.restaurantAPI.restaurant.exception.SuccessResponse;
import com.restaurantAPI.restaurant.models.Food;
import com.restaurantAPI.restaurant.models.Restaurant;
import com.restaurantAPI.restaurant.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {
    @Autowired
    private FoodService foodService;

    //create a food
    @PostMapping("/create-food")
    public ResponseEntity<Food> addRestaurant(@RequestBody Food food){
        return new ResponseEntity<>(foodService.addFood(food), HttpStatus.CREATED);
    }

    //get all
    @GetMapping("/get-all-food")
    public ResponseEntity<List<Food>> getAll(){
        return ResponseEntity.ok(foodService.getAllFood());
    }

    //get by id
    @GetMapping("/get-food-id/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Food existedFood = foodService.findByID(id);
        if (existedFood != null) {
            return ResponseEntity.ok(existedFood);
        } else {
            ErrorResponse errorResponse = new ErrorResponse("NOT FOUND");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    //delete by id
    @DeleteMapping("/delete-food/{id}")
    public ResponseEntity<?> deleteFood(@PathVariable Integer id){
        Food existedFood = foodService.findByID(id);
        if (existedFood != null) {
            foodService.deleteRestById(id);
            SuccessResponse successResponse = new SuccessResponse("DELETED");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(successResponse);
        } else {
            ErrorResponse errorResponse = new ErrorResponse("NOT FOUND");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @PutMapping("/update-food/{id}")
    public ResponseEntity<?> updateFood(@PathVariable Integer id, @RequestBody Food newFood) {
        Food existedFood= foodService.findByID(id);
        if (existedFood != null) {
            foodService.updateFood(newFood, existedFood);
            SuccessResponse successResponse = new SuccessResponse("UPDATED");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(successResponse);
        } else {
            ErrorResponse errorResponse = new ErrorResponse("NOT FOUND");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
}
