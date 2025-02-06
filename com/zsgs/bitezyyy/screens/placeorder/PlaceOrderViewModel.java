package com.zsgs.bitezyyy.screens.placeorder;

public class PlaceOrderViewModel {

    private PlaceOrderScreen placeOrderScreen;

    public PlaceOrderViewModel(PlaceOrderScreen placeOrderScreen) {
        this.placeOrderScreen = placeOrderScreen;
    }

    public void placeOrder() {
        System.out.println("Order finalised. Proceeding with payment...");
        placeOrderScreen.displayPaymentOptions();
    }

    public void processPayment(int paymentChoice) {
        // Handle cash payment
        if(paymentChoice == 1) {
            placeOrderScreen.paymentSuccessful("Cash");
        } 
        // Handle card payment
        else if(paymentChoice == 2) {
            placeOrderScreen.requestCardDetails();
        }
    }

    public void validateCardDetails(String cardNumber, String pin) {
        // Logic to validate card number and pin (for now, we just print them)
        System.out.println("Card payment successful.");
        placeOrderScreen.paymentSuccessful("Card");
    }
}
