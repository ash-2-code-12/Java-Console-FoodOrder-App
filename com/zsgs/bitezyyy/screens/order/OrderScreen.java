package com.zsgs.bitezyyy.screens.order;

import com.zsgs.bitezyyy.BaseScreen;
import com.zsgs.bitezyyy.dto.FoodItem;
import com.zsgs.bitezyyy.dto.Order;
import com.zsgs.bitezyyy.dto.Order.OrderStatus;

import java.util.Date;
import java.util.Map.Entry;



public class OrderScreen extends BaseScreen {

    private static OrderScreen orderScreenInstance;
    private Order currOrder;
    private OrderViewModel orderViewModel;

    private OrderScreen(){
        orderViewModel = new OrderViewModel(this);
        currOrder = orderViewModel.getCurrOrder();
    }

    public static OrderScreen getInstance(){
        if(orderScreenInstance==null){
            orderScreenInstance = new OrderScreen();
        }
        return orderScreenInstance;
    }

    public void onCreate() {
        if(!hasNetworkConnection()){
            System.out.println("Please check database connection");
            return;
        }
    }

    private void printLine(){
        System.out.println("____________________________________________________________");
    }

    public void printBill() {
        System.out.println("\n\nOrder Id : " + currOrder.getOrderId());
        System.out.println("User Id : " + currOrder.getcartUser().getUserId());
        
        System.out.println(currOrder.getOrderStatus() == OrderStatus.COMPLETED ? currOrder.getOrderDate() : new Date());
        printLine();
    
        if (currOrder.getCartItems().isEmpty()) {
            System.out.println("Cart Empty. Order Items to show in Cart!!!");
            printLine();
            return;
        }
    
        System.out.printf("%-15s %-15s %-15s %-15s\n", "Name", "Price", "Quantity", "Total Price");
        printLine();    
        for (Entry<FoodItem, Integer> entry : currOrder.getCartItems().entrySet()) {
            FoodItem item = entry.getKey();
            float itemPrice = item.getPrice();
            int quantity = entry.getValue();
            
            System.out.printf("%-15s Rs.%-13.2f %-15d Rs.%-13.2f\n", item.getName(), itemPrice, quantity, quantity * itemPrice);
        }
    
        printLine();
        System.out.printf("%-33s Rs.%-13.2f\n", "Total Bill Amount:", currOrder.getBillAmount());
        printLine();
    }
    

    public void viewCart() {
        printLine();
        
        if (currOrder.getCartItems().isEmpty()) {
            System.out.println("Cart Empty. Order Items to show in Cart!!!");
            printLine();
            return;
        }
        
        System.out.printf("%-15s %-15s %-15s %-15s\n", "Name", "Price", "Quantity", "Total Price");
        printLine();
    
        for (Entry<FoodItem, Integer> entry : currOrder.getCartItems().entrySet()) {
            FoodItem item = entry.getKey();
            float itemPrice = item.getPrice();
            int quantity = entry.getValue();
            
            System.out.printf("%-15s Rs.%-13.2f %-15d Rs.%-13.2f\n", item.getName(), itemPrice, quantity, quantity * itemPrice);
        }
        printLine();
        
    }
}








