package com.zsgs.bitezyyy.screens.login;

import com.zsgs.bitezyyy.datalayer.BitezyyyRepository;
import com.zsgs.bitezyyy.dto.User;

public class LoginViewModel {
    
    private LoginScreen view;

    public LoginViewModel(LoginScreen screen){
        this.view = screen;
    }

    public void validateUser(String userName, String password){
        User loggedInUser = BitezyyyRepository.getInstance().validate(userName,password);
        
        if(loggedInUser!=null){
            BitezyyyRepository.getInstance().login(loggedInUser);
            view.navigateToRestaurantList(loggedInUser);
        }
        else{
            view.showErroMessage("Invalid Username or Password");
        }
        
    }

}
