package com.restaurantAPI.restaurant.controllers;

import com.restaurantAPI.restaurant.exception.ErrorResponse;
import com.restaurantAPI.restaurant.exception.SuccessResponse;
import com.restaurantAPI.restaurant.models.Restaurant;
import com.restaurantAPI.restaurant.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;


    //create
    @PostMapping("/create-rest")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant){
        Restaurant newRest = restaurantService.addRest(restaurant);
        return new ResponseEntity<>(restaurantService.addRest(restaurant), HttpStatus.CREATED);
    }

    //get all
    @GetMapping("/get-all")
    public ResponseEntity<List<Restaurant>> getAll(){
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    //get by id
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Restaurant existedRest = restaurantService.findByID(id);
        if (existedRest != null) {
            return ResponseEntity.ok(existedRest);
        } else {
            ErrorResponse errorResponse = new ErrorResponse("NOT FOUND");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    //update rest by id
    @PutMapping("/update-rest/{id}")
    public ResponseEntity<?> updateRest(@PathVariable Integer id, @RequestBody Restaurant newRest) {
        Restaurant existedRest = restaurantService.findByID(id);
        if (existedRest != null) {
            restaurantService.updateRest(newRest, existedRest);
            SuccessResponse successResponse = new SuccessResponse("UPDATED");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(successResponse);
        } else {
            ErrorResponse errorResponse = new ErrorResponse("NOT FOUND");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    //delete by id
    @DeleteMapping("/delete-rest/{id}")
    public ResponseEntity<?> deleteRest(@PathVariable Integer id){
        Restaurant existedRest = restaurantService.findByID(id);
        if (existedRest != null) {
            restaurantService.deleteRestById(id);
            SuccessResponse successResponse = new SuccessResponse("DELETED");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(successResponse);
        } else {
            ErrorResponse errorResponse = new ErrorResponse("NOT FOUND");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
}
