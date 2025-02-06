package com.zsgs.bitezyyy.screens.login;


import com.zsgs.bitezyyy.BaseScreen;
import com.zsgs.bitezyyy.datalayer.BitezyyyRepository;
import com.zsgs.bitezyyy.dto.User;
import com.zsgs.bitezyyy.screens.restaurantlist.RestaurantListScreen;

public class LoginScreen extends BaseScreen {

    private LoginViewModel viewModel;
    public LoginScreen() {
        viewModel = new LoginViewModel(this);
    }
    
    public void onCreate() {
        if(!hasNetworkConnection()){
            System.out.println("\nPlease check internet connection");
            return;
        }
        System.out.println("Welcome to Bitezyyy Food Order Application");
        System.out.println("1) Login.");
        System.out.println("2) Exit.");
        System.out.println("Enter the choice : ");

        int choice;
        while (true) {
            choice = BitezyyyRepository.getInstance().getScanner().nextInt();
            if(choice==1 || choice==2){
                break;
            }
        }
        if(choice == 2){
            System.out.println("----------Thanks. Visit again!!!-----------");
            System.exit(0);
        }
        
        this.proceedtologin();

    }

    private void proceedtologin() {
        System.out.println("\nPlease login to proceed");

        System.out.println("Enter the user name : ");
        String userName = BitezyyyRepository.getInstance().getScanner().next();

        System.out.println("Enter the password : ");
        String password = BitezyyyRepository.getInstance().getScanner().next();


        viewModel.validateUser(userName, password);
        System.out.println();
    }

    public void navigateToRestaurantList(User loggedInUser){
        System.out.println("Welcome  "+loggedInUser.getName());
        RestaurantListScreen restaurantListScreen = new RestaurantListScreen(this);
        restaurantListScreen.showScreen();
    }
    

    public void showErroMessage(String message){
        System.out.println(message);
    }

}
