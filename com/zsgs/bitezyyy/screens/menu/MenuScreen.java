package com.zsgs.bitezyyy.screens.menu;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.zsgs.bitezyyy.BaseScreen;
import com.zsgs.bitezyyy.datalayer.BitezyyyRepository;
import com.zsgs.bitezyyy.dto.FoodItem;
import com.zsgs.bitezyyy.dto.Restaurant;
import com.zsgs.bitezyyy.screens.order.OrderScreen;
import com.zsgs.bitezyyy.screens.placeorder.PlaceOrderScreen;
import com.zsgs.bitezyyy.screens.restaurantlist.RestaurantListScreen;

public class MenuScreen extends BaseScreen{

    private MenuViewModel menuViewModel;
    private RestaurantListScreen calledRestaurantListScreen;
    private Restaurant currRestaurant;

    public MenuScreen(RestaurantListScreen calledListScreen){
        menuViewModel = new MenuViewModel(this); 
        this.calledRestaurantListScreen = calledListScreen;
    }

    public void onCreate(Restaurant selectedRestaurant) {
        
        if(!hasNetworkConnection()){
            System.out.println("\nPlease check the network connection");
            return;
        }
        currRestaurant = selectedRestaurant;

        Scanner sc = new Scanner(System.in);

        System.out.println("_______________________________________________________________________");
        System.out.println(selectedRestaurant.getName() + "\n" + selectedRestaurant.getSlogan());

        int navigationChoice = -1;
        while(true){
            System.out.println("1.) Proceed to Order\n2.) Back to Restaurant List");
            navigationChoice = sc.nextInt();
            if(navigationChoice!=1 && navigationChoice!=2){
                System.out.println("Enter Valid Choice");
                continue;
            }
            break;
        }

        if(navigationChoice == 2){
            calledRestaurantListScreen.showScreen();
        }

        takeOrder();
        sc.close();
        
    }

    public void takeOrder() {
        List<FoodItem> menu = currRestaurant.getMenu();
        System.out.println("\nMenu :\nItem                  Price");
        System.out.println("__________________________________");
        
        Iterator<FoodItem> itr = menu.iterator();
        int index = 1;

        while(itr.hasNext()){
            FoodItem currItem = itr.next();
            System.out.println(index++ + ".) " + currItem.getName() + "                  " + currItem.getPrice());
        }

        System.out.println("\nEnter 0 to go back to Restaurant list screen.");
        System.out.println("Enter -1 to view cart.");
        int choice = -1;
        while (true) {
            System.out.println("\nEnter the choice (index) : ");
            choice = BitezyyyRepository.getInstance().getScanner().nextInt() - 1;
            if(choice>=-2 && choice < menu.size()){
                break;
            }
            else{
                System.out.println("-----------Invalid Choice-----------");
            }
        }
        if(choice == -2){
            OrderScreen.getInstance().viewCart();
            System.out.println("_______________________\nEnter 0 to go back.");
            if(!BitezyyyRepository.getInstance().getOrder().getCartItems().isEmpty()){
                System.out.println("Enter 1 to place order.");
            }
            int ch = BitezyyyRepository.getInstance().getScanner().nextInt();
            if(ch==0){
                this.onCreate(currRestaurant);
            }
            if(ch==1 && !BitezyyyRepository.getInstance().getOrder().getCartItems().isEmpty()){
                PlaceOrderScreen placeOrderScreen = new PlaceOrderScreen();
                placeOrderScreen.onCreate();
                System.out.println("Order placed");
                System.exit(1);
            }
        }

        if(choice == -1){
            calledRestaurantListScreen.showScreen();
            return;
        }
        else{
            FoodItem selectedFoodItem = menu.get(choice);
            int quantity = 1;

            System.out.println("Enter the quantity : ");
            quantity = BitezyyyRepository.getInstance().getScanner().nextInt();

            menuViewModel.addToCart(selectedFoodItem, quantity);
        }        
    }
}
