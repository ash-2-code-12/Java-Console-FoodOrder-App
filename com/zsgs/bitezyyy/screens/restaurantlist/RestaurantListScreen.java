package com.zsgs.bitezyyy.screens.restaurantlist;

import java.util.ListIterator;

import com.zsgs.bitezyyy.BaseScreen;
import com.zsgs.bitezyyy.datalayer.BitezyyyRepository;
import com.zsgs.bitezyyy.dto.Restaurant;
import com.zsgs.bitezyyy.screens.login.LoginScreen;
import com.zsgs.bitezyyy.screens.menu.MenuScreen;
import com.zsgs.bitezyyy.screens.order.OrderScreen;

public class RestaurantListScreen extends BaseScreen{

    private RestaurantListViewModel restaurantListViewModel;
    private LoginScreen calledLoginScreen;

    public RestaurantListScreen(LoginScreen loginScreen){
        restaurantListViewModel = new RestaurantListViewModel(this);
        this.calledLoginScreen = loginScreen;

    }

    public void showScreen(){
        if(!hasNetworkConnection()){
            System.out.println("Check Network Connection");
            return;
        }

        System.out.println("\nListing the available Restaurants :");
        // printing restaurant names
        ListIterator<Restaurant> itr = restaurantListViewModel.getRestaurantList().listIterator();
        int index = 1;
        while(itr.hasNext()){
            Restaurant curr = itr.next();
            System.out.println(index++ +".) " + curr.getName());
        }

        System.out.println("\nEnter 0 to logoff\nEnter -1 to viewCart");
        
        int choice = -1;
        
        while (true) {
            System.out.println("\nEnter the choice (index): ");
            choice = BitezyyyRepository.getInstance().getScanner().nextInt() -1;
            if(choice>=-2 && choice < restaurantListViewModel.getRestaurantList().size()){
                break;
            }
            else{
                System.out.println("-----------Invalid Choice-----------");
            }
        }
        if(choice==-2){
            OrderScreen.getInstance().viewCart();

            System.out.println("Enter 0 to go back.");
            if(!BitezyyyRepository.getInstance().getOrder().getCartItems().isEmpty()){
                System.out.println("Enter 1 to place order.");
            }
            int ch = BitezyyyRepository.getInstance().getScanner().nextInt();
            if(ch==0){
                this.showScreen();
            }
            if(ch==1 && !BitezyyyRepository.getInstance().getOrder().getCartItems().isEmpty()){
                //place order logic
                System.out.println("Order placed");
            }
        }
        else if(choice == -1){
            
            System.out.println("----------------- Logged off successfully ---------------------\n");
            restaurantListViewModel.logoff(calledLoginScreen);
        }
        else{
            restaurantListViewModel.onRestaurantSelected(restaurantListViewModel.getRestaurantList().get(choice));
        }
    }

    public void navigateToRestaurantMenu(Restaurant selectedRestaurant){
        MenuScreen menuScreen = new MenuScreen(this);
        menuScreen.onCreate(selectedRestaurant);
    }
}
