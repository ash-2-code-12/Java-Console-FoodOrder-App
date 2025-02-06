package com.zsgs.bitezyyy.datalayer;

import com.zsgs.bitezyyy.dto.User;
import com.zsgs.bitezyyy.dto.Order;
import com.zsgs.bitezyyy.dto.FoodItem;
import com.zsgs.bitezyyy.dto.Restaurant;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;




public class BitezyyyRepository {

    private  Scanner sc = new Scanner(System.in);

    private User loggedInUser;
    private Order userOrder;
    private List<Order> ordersHistoryLog;

    private static BitezyyyRepository respository;
    
    private List<Restaurant> restaurantsList;
    private Map<String, List<FoodItem>> allFoodCategories;


    private BitezyyyRepository() {
        //singleton class model
        initialiseAllFoodCategories();
        initialiseRestaurantsList();

    }


    public static BitezyyyRepository getInstance(){
        if(respository == null){
            respository = new BitezyyyRepository();
        }
        return respository;
    }

    public User validate(String userName, String password){

        if(userName.equals("user1") && password.equals("pass1")){
            User user = new User(userName, "zsgsUser1@asgs.in", "112se1", 1940080881);
            userOrder = new Order(user);
            user.setCurrOrder(userOrder);

            //SQL query to get user details
            return user;
        }
        return null;

    }

    private void initialiseRestaurantsList() {
        
        restaurantsList = new ArrayList<>();

        restaurantsList.add(new Restaurant("Al-Arabita","Savor the Secrets of the Middle East", allFoodCategories.get("Arabic")));
        restaurantsList.add(new Restaurant("Golden Wok", "Wok Your Way to Happiness",allFoodCategories.get("Chinese")));
        restaurantsList.add(new Restaurant("Casa de Salsa", "Salsa, Spice, and Everything Nice", allFoodCategories.get("Mexican")));
        restaurantsList.add(new Restaurant("Curry Culture", "Spice Up Your Life with Authentic Indian Flavors", allFoodCategories.get("Indian")));

    }

    private void initialiseAllFoodCategories() {
        allFoodCategories = new HashMap<>();

        // Arabic Food Items
        List<FoodItem> arabicFoodItems = new ArrayList<>();
        arabicFoodItems.add(new FoodItem("Mansaf", 350));
        arabicFoodItems.add(new FoodItem("Shawarma", 120));
        arabicFoodItems.add(new FoodItem("Falafel", 80));
        arabicFoodItems.add(new FoodItem("Kabsa", 300));
        arabicFoodItems.add(new FoodItem("Hummus", 60));
        arabicFoodItems.add(new FoodItem("Tabbouleh", 90));
        arabicFoodItems.add(new FoodItem("Fattoush", 110));
        arabicFoodItems.add(new FoodItem("Moutabal", 70));
        arabicFoodItems.add(new FoodItem("Shish Taouk", 250));
        arabicFoodItems.add(new FoodItem("Kunafa", 200));

        allFoodCategories.put("Arabic", arabicFoodItems);

        // Chinese Food Items
        List<FoodItem> chineseFoodItems = new ArrayList<>();
        chineseFoodItems.add(new FoodItem("Sweet and Sour Pork", 220));
        chineseFoodItems.add(new FoodItem("Kung Pao Chicken", 200));
        chineseFoodItems.add(new FoodItem("Spring Rolls", 120));
        chineseFoodItems.add(new FoodItem("Fried Rice", 150));
        chineseFoodItems.add(new FoodItem("Peking Duck", 450));
        chineseFoodItems.add(new FoodItem("Mapo Tofu", 180));
        chineseFoodItems.add(new FoodItem("Chow Mein", 130));
        chineseFoodItems.add(new FoodItem("Dumplings", 140));
        chineseFoodItems.add(new FoodItem("Hot and Sour Soup", 110));
        chineseFoodItems.add(new FoodItem("Szechuan Beef", 280));

        allFoodCategories.put("Chinese", chineseFoodItems);

        // Indian Food Items
        List<FoodItem> indianFoodItems = new ArrayList<>();
        indianFoodItems.add(new FoodItem("Butter Chicken", 240));
        indianFoodItems.add(new FoodItem("Paneer Tikka", 180));
        indianFoodItems.add(new FoodItem("Masala Dosa", 90));
        indianFoodItems.add(new FoodItem("Chole Bhature", 130));
        indianFoodItems.add(new FoodItem("Hyderabadi Biryani", 220));
        indianFoodItems.add(new FoodItem("Rogan Josh", 260));
        indianFoodItems.add(new FoodItem("Aloo Paratha", 80));
        indianFoodItems.add(new FoodItem("Dal Makhani", 150));
        indianFoodItems.add(new FoodItem("Samosa", 40));
        indianFoodItems.add(new FoodItem("Gulab Jamun", 70));

        allFoodCategories.put("Indian", indianFoodItems);

        // Mexican Food Items
        List<FoodItem> mexicanFoodItems = new ArrayList<>();
        mexicanFoodItems.add(new FoodItem("Tacos", 100));
        mexicanFoodItems.add(new FoodItem("Quesadilla", 130));
        mexicanFoodItems.add(new FoodItem("Enchiladas", 180));
        mexicanFoodItems.add(new FoodItem("Guacamole", 90));
        mexicanFoodItems.add(new FoodItem("Churros", 70));
        mexicanFoodItems.add(new FoodItem("Tamales", 150));
        mexicanFoodItems.add(new FoodItem("Burrito", 160));
        mexicanFoodItems.add(new FoodItem("Nachos", 120));
        mexicanFoodItems.add(new FoodItem("Pozole", 220));
        mexicanFoodItems.add(new FoodItem("Fajitas", 200));

        allFoodCategories.put("Mexican", mexicanFoodItems);

    }

    private void initialiseAllUsers(){

    }

    public void logoff() {
        loggedInUser = null;
    }

    public void addCartToLog(Order placedOrderCart){
        ordersHistoryLog.add(placedOrderCart);
    }


    // setters 

    public void login(User currUser){
        if(this.loggedInUser != null){
            System.out.println("User already logged in");
            return;
        }
        this.loggedInUser = currUser;
        return;
    }

    // Getters _______________________________________________________________________________________________

    public List<Restaurant> getRestaurantList(){
        return restaurantsList;
    }


    public User loggedInUserDetail() {
        return loggedInUser;
    }

    public Scanner getScanner(){
        return sc;
    }

    public Order getOrder(){
        return userOrder;
    }

}

