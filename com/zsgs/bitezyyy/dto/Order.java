package com.zsgs.bitezyyy.dto;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Order {
    private static int orderCount = 0;
    private String orderId;
    private float billAmount = 0;
    private User cartUser ;
    private Date orderDate;
    private OrderStatus orderStatus = OrderStatus.PENDING; // Default status is PENDING
    private Map<FoodItem, Integer> cart;   // Map structure  : <foodItem, quantity>
    
    public enum OrderStatus {
        PENDING, COMPLETED, CANCELLED
    }

    public Order(User currUser){
        this.cartUser = currUser;
        currUser.setCurrOrder(this);
        Order.orderCount++;
        this.orderId = this.setOrderId();
        this.cart = new LinkedHashMap<>();
    }

    public void addItem(FoodItem item, int quantity){
        cart.put(item, (cart.getOrDefault(item, 0)) + quantity);
        System.out.println("added : " + item.getName());
        updateBillAmount(item.getPrice(), quantity);
    }

    public void removeItem(FoodItem item, int quantity){
        if(quantity>cart.get(item)){
            quantity = cart.get(item);
        }
        cart.put(item, cart.get(item)-quantity);
        if(cart.get(item)==0){
            cart.remove(item);
        }
        updateBillAmount(-item.getPrice(), quantity);
    }

    private void updateBillAmount(float itemPrice, int quantity) {
        billAmount += itemPrice * quantity;
        
    }
    
    public Map<FoodItem, Integer> getCartItems() {
        return cart;
    }

    public String getOrderId(){
        return orderId;
    }

    public float getBillAmount(){
        return cart.isEmpty() ? 0.0f : billAmount;
    }

    // public User getcartUser(){
    //     return cartUser;
    // }

    private String setOrderId(){
        String id = String.valueOf(Order.orderCount);
        StringBuilder filler = new StringBuilder(5);
        for(int i=0; i<6-id.length(); i++){
            filler.append("0");
        }
        filler.append(id);
        return filler.toString();
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

        // Complete the order
    public void completeOrder() {
        this.orderStatus = OrderStatus.COMPLETED;
        this.orderDate = new Date(); // Set the order date to current date when completed
        System.out.println("Order completed!");
    }

    // Cancel the order
    public void cancelOrder() {
        this.orderStatus = OrderStatus.CANCELLED;
        System.out.println("Order cancelled.");
    }

    public User getcartUser() {
        return cartUser;
    }
    
}


