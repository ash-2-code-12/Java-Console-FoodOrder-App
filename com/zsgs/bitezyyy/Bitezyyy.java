package com.zsgs.bitezyyy;


import com.zsgs.bitezyyy.screens.login.LoginScreen;

public class Bitezyyy {
    
    private String appName = "Bitezyy Food Order Application";

    private String appVersion = "0.0.1";

    public static void main(String[] args) {
        System.out.println();
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.onCreate();
    }
}
