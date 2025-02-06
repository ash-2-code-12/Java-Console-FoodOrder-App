package com.zsgs.bitezyyy.screens.restaurantlist;


import java.util.List;

import com.zsgs.bitezyyy.datalayer.BitezyyyRepository;
import com.zsgs.bitezyyy.dto.Restaurant;
import com.zsgs.bitezyyy.screens.login.LoginScreen;

public class RestaurantListViewModel {

    private RestaurantListScreen restaurantListScreen;

    public RestaurantListViewModel(RestaurantListScreen restaurantListScreen){
        this.restaurantListScreen = restaurantListScreen;
    }

    public List<Restaurant> getRestaurantList() {
        return BitezyyyRepository.getInstance().getRestaurantList();
    }

    public void  onRestaurantSelected(Restaurant selectedRestaurant){
        restaurantListScreen.navigateToRestaurantMenu(selectedRestaurant);
    }

    public void logoff(LoginScreen calledLoginScreen) {
        BitezyyyRepository.getInstance().logoff();
        calledLoginScreen.onCreate();
    }
    
}
