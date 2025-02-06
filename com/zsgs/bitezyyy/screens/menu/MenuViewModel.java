package com.zsgs.bitezyyy.screens.menu;

import java.util.List;

import com.zsgs.bitezyyy.datalayer.BitezyyyRepository;
import com.zsgs.bitezyyy.dto.FoodItem;
import com.zsgs.bitezyyy.dto.Restaurant;

public class MenuViewModel {
    
    private MenuScreen view ;

    public MenuViewModel(MenuScreen menuScreen){
        this.view = menuScreen;
    }

    public List<FoodItem> getMenu(Restaurant selectedRestaurant) {
        return selectedRestaurant.getMenu();
    }

    public void addToCart(FoodItem selectedFoodItem, int quantity) {
        BitezyyyRepository.getInstance().getOrder().addItem(selectedFoodItem, quantity);
        view.takeOrder();
        // BitezyyyRepository.getInstance().getCart().viewCart();
    }


}
