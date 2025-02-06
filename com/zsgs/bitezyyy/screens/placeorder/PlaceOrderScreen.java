package com.zsgs.bitezyyy.screens.placeorder;

import com.zsgs.bitezyyy.datalayer.BitezyyyRepository;
import com.zsgs.bitezyyy.BaseScreen;

public class PlaceOrderScreen extends BaseScreen {

    private PlaceOrderViewModel placeOrderViewModel;

    public PlaceOrderScreen() {
        this.placeOrderViewModel = new PlaceOrderViewModel(this);
    }

    public void onCreate() {
        if(!hasNetworkConnection()){
            System.out.println("Please check database connection");
            return;
        }
        placeOrderViewModel.placeOrder();
    }

    public void displayPaymentOptions() {
        System.out.println("\nChoose payment method:");
        System.out.println("1) Cash");
        System.out.println("2) Card");

        int paymentChoice = -1;
        while (true) {
            paymentChoice = BitezyyyRepository.getInstance().getScanner().nextInt();
            if(paymentChoice == 1 || paymentChoice == 2){
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1 for Cash or 2 for Card.");
            }
        }
        placeOrderViewModel.processPayment(paymentChoice);
    }

    public void paymentSuccessful(String paymentMethod) {
        System.out.println("\nPayment successful using " + paymentMethod + ".");
        System.out.println("Thank you for your order!");
        System.exit(0);
    }

    public void requestCardDetails() {
        System.out.println("\nPlease enter your card details:");

        System.out.print("Card Number: ");
        String cardNumber = BitezyyyRepository.getInstance().getScanner().next();

        System.out.print("PIN: ");
        String pin = BitezyyyRepository.getInstance().getScanner().next();

        placeOrderViewModel.validateCardDetails(cardNumber, pin);
    }
}
