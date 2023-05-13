package com.restaurantAPI.restaurant.services;

import com.restaurantAPI.restaurant.models.Restaurant;
import com.restaurantAPI.restaurant.repository.IRestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private IRestaurantRepo iRestaurantRepo;

    //create a restaurant
    public Restaurant addRest(Restaurant restaurant){
        return iRestaurantRepo.save(restaurant);
    }

    //get all restaurant
    public List<Restaurant> getAllRestaurants() {
        return iRestaurantRepo.findAll();
    }

    //get restaurant by id
    public Restaurant findByID(Integer id) {
        return iRestaurantRepo.findByRestId(id);
    }


    //update restaurant by id
    public void updateRest(Restaurant newRest, Restaurant existedRest) {
        existedRest.setRestaurantId(newRest.getRestaurantId());
        existedRest.setName(newRest.getName());
        existedRest.setAddress(newRest.getAddress());
        existedRest.setMenu(newRest.getMenu());
        iRestaurantRepo.save(existedRest);
    }

    public void deleteRestById(Integer id) {
        iRestaurantRepo.deleteById(id);
    }
}
