package com.zsgs.bitezyyy.dto;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String name;
    private String slogan;
    private List<FoodItem> menu;

    public Restaurant(String name, String slogan){
        this.name = name;
        this.slogan = slogan;
        this.menu = new ArrayList<>();
    }

    public Restaurant(String name,String slogan, List<FoodItem> menuPassed){
        this(name, slogan); 
        this.menu.addAll(menuPassed);
    }

    public String getName(){
        return this.name;
    }

    public void addFoodItem(FoodItem dish){
        menu.add(dish);
    }

    public void removeFoodItem(FoodItem dish){
        menu.remove(dish);
    }

    public List<FoodItem> getMenu(){
        return this.menu;
    }

    public String getSlogan() {
        return slogan;
    }
}

