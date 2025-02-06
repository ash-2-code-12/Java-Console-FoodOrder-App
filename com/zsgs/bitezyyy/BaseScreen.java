// src/
// └── com/
//     └── restaurant/
//         ├── BaseScreen.java
//         ├── Bitezyyy.java
//         |
//         |── dto/
//         |   ├── FoodItem.java
//         |   ├── Order.java
//         |   ├── Restaurant.java
//         |   ├── User.java
//         |
//         |── datalayer/
//         |   ├── BitezyyyRepository.java
//         |
//         └── screens/
//             ├── login    (each scree has a ....Screen.java and .....ViewModel.java file)
//             ├── menu
//             ├── order
//             ├── placeorder
//             └── restaurantlist

package com.zsgs.bitezyyy;

public abstract class BaseScreen {
    
    protected boolean hasNetworkConnection() { 
        return checkConnection();  //encapsulation
    }

    private boolean checkConnection() {
        return true;   // update with logic for checkking connection
    }

}
