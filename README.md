
# Bitezyyy - Food Ordering System

Bitezyyy is a console-based food ordering system that allows users to browse restaurant menus, add items to the cart, and place an order. The system provides options for payment via cash or card, where card details are validated before finalizing the order.

## Features

- **Restaurant List**: Displays a list of available restaurants.
- **Menu**: Allows users to view and select food items from the restaurant menu.
- **Cart**: Users can view items in their cart and place an order.
- **Payment**: Users can choose between cash or card as the payment method. 
- **Order Placement**: After successful payment, the order is finalized and processed.
- **Network Check**: Ensures that the system is connected to the network for various functionalities.

## Installation

### Prerequisites

- Java 8 or above
- Maven or any build tool (optional, depending on your setup)

### Steps

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/bitezyyy.git
   ```

2. **Navigate to the project folder**:
   ```bash
   cd bitezyyy
   ```

3. **Compile the project**:
   If you're using Maven, run:
   ```bash
   mvn clean install
   ```

   Or, if you're using a different Java build system, compile and build the project according to the system's instructions.

4. **Run the application**:
   The project is designed as a console-based application. To run the application, execute the `Main` class, or a similar entry point, depending on your structure.

   ```bash
   java -cp target/bitezyyy.jar com.zsgs.bitezyyy.Main
   ```

## Usage

1. **Log In**:
   - The user is prompted to log in.
   - If the user is not logged in, they can proceed to the login screen.

2. **View Restaurant List**:
   - A list of available restaurants is displayed.
   - The user can select a restaurant to view the menu.

3. **Menu Screen**:
   - The user can browse the menu of the selected restaurant.
   - The user can add items to the cart by choosing the item and specifying the quantity.

4. **Cart and Order Screen**:
   - The user can view their cart and proceed to place an order.
   - The user can select the payment method (cash or card).
   - If the user selects card payment, they will be prompted to enter card details.

5. **Payment**:
   - If the user chooses cash, the order is finalized immediately.
   - If the user chooses card, they must provide a valid card number and PIN.

6. **Place Order**:
   - After the payment is successful, the order is processed, and the system displays a confirmation message.

## Project Structure

```
Bitezyyy
├── com
│   └── zsgs
│       └── bitezyyy
│           ├── BaseScreen.java                # Base screen class for UI handling
│           ├── Main.java                       # Main class to run the application
│           ├── datalayer
│           │   └── BitezyyyRepository.java     # Data repository class for managing data
│           ├── dto
│           │   ├── FoodItem.java              # Food item class
│           │   ├── Order.java                 # Order class
│           │   └── Restaurant.java            # Restaurant class
│           ├── screens
│           │   ├── login
│           │   │   └── LoginScreen.java       # Login screen class
│           │   │   └── LoginViewModel.java       # Login screen view model class
│           │   ├── menu
│           │   │   ├── MenuScreen.java        # Menu screen class
│           │   │   └── MenuViewModel.java     # Menu screen view model class
│           │   ├── order
│           │   │   ├── OrderScreen.java       # Order screen class
│           │   │   └── OrderViewModel.java    # Order screen view model class
│           │   ├── placeorder
│           │   │   ├── PlaceOrderScreen.java  # Place order screen class
│           │   │   └── PlaceOrderViewModel.java # Place order view model class
│           │   └── restaurantlist
│           │       ├── RestaurantListScreen.java  # Restaurant list screen class
│           │       └── RestaurantListViewModel.java # Restaurant list view model class
│           └── util
│               └── NetworkUtil.java            # Utility class for network-related tasks
└── README.md                                # This file
```

## How It Works

### 1. **Screen-ViewModel Architecture**:
   - The application follows a **Screen-ViewModel** architecture, where the screen handles user interface interactions (like displaying menus and handling inputs), and the view model handles the core business logic (like processing payments or adding items to the cart).
   
### 2. **Flow**:
   - **Login Screen** -> **Restaurant List Screen** -> **Menu Screen** -> **Cart & Order Screen** -> **Place Order Screen**.

### 3. **Payment Flow**:
   - **Cash Payment**: The user selects cash and the order is immediately processed.
   - **Card Payment**: The user enters card details, and the card payment is validated. If valid, the order is processed.

## Example Output
Welcome to Bitezyyy Food Order Application
1) Login.
2) Exit.
Enter the choice : 
1

Please login to proceed
Enter the user name : 
user1
Enter the password : 
pass1
Welcome  user1

Listing the available Restaurants :
1.) Al-Arabita
2.) Golden Wok
3.) Casa de Salsa
4.) Curry Culture

Enter 0 to logoff
Enter -1 to viewCart

Enter the choice (index):
1
_______________________________________________________________________
Al-Arabita
Savor the Secrets of the Middle East
1.) Proceed to Order
2.) Back to Restaurant List
1

Menu :
Item                  Price
__________________________________
1.) Mansaf                  350.0
2.) Shawarma                  120.0
3.) Falafel                  80.0
4.) Kabsa                  300.0
5.) Hummus                  60.0
6.) Tabbouleh                  90.0
7.) Fattoush                  110.0
8.) Moutabal                  70.0
9.) Shish Taouk                  250.0
10.) Kunafa                  200.0

Enter 0 to go back to Restaurant list screen.
Enter -1 to view cart.

Enter the choice (index) :
1
Enter the quantity : 
22
added : Mansaf

Menu :
Item                  Price
__________________________________
1.) Mansaf                  350.0
2.) Shawarma                  120.0
3.) Falafel                  80.0
4.) Kabsa                  300.0
5.) Hummus                  60.0
6.) Tabbouleh                  90.0
7.) Fattoush                  110.0
8.) Moutabal                  70.0
9.) Shish Taouk                  250.0
10.) Kunafa                  200.0

Enter 0 to go back to Restaurant list screen.
Enter -1 to view cart.

Enter the choice (index) :
3
Enter the quantity : 
11
added : Falafel

Menu :
Item                  Price
__________________________________
1.) Mansaf                  350.0
2.) Shawarma                  120.0
3.) Falafel                  80.0
4.) Kabsa                  300.0
5.) Hummus                  60.0
6.) Tabbouleh                  90.0
7.) Fattoush                  110.0
8.) Moutabal                  70.0
9.) Shish Taouk                  250.0
10.) Kunafa                  200.0

Enter 0 to go back to Restaurant list screen.
Enter -1 to view cart.

Enter the choice (index) :
-1
____________________________________________________________
Name            Price           Quantity        Total Price
____________________________________________________________
Mansaf          Rs.350.00        22              Rs.7700.00      
Falafel         Rs.80.00         11              Rs.880.00
____________________________________________________________
_______________________
Enter 0 to go back.
Enter 1 to place order.
0
_______________________________________________________________________
Al-Arabita
Savor the Secrets of the Middle East
1.) Proceed to Order
2.) Back to Restaurant List
2

Listing the available Restaurants :
1.) Al-Arabita
2.) Golden Wok
3.) Casa de Salsa
4.) Curry Culture

Enter 0 to logoff
Enter -1 to viewCart

Enter the choice (index):
2
_______________________________________________________________________
Golden Wok
Wok Your Way to Happiness
1.) Proceed to Order
2.) Back to Restaurant List
1

Menu :
Item                  Price
__________________________________
1.) Sweet and Sour Pork                  220.0
2.) Kung Pao Chicken                  200.0
3.) Spring Rolls                  120.0
4.) Fried Rice                  150.0
5.) Peking Duck                  450.0
6.) Mapo Tofu                  180.0
7.) Chow Mein                  130.0
8.) Dumplings                  140.0
9.) Hot and Sour Soup                  110.0
10.) Szechuan Beef                  280.0

Enter 0 to go back to Restaurant list screen.
Enter -1 to view cart.

Enter the choice (index) :
1
Enter the quantity : 
12
added : Sweet and Sour Pork

Menu :
Item                  Price
__________________________________
1.) Sweet and Sour Pork                  220.0
2.) Kung Pao Chicken                  200.0
3.) Spring Rolls                  120.0
4.) Fried Rice                  150.0
5.) Peking Duck                  450.0
6.) Mapo Tofu                  180.0
7.) Chow Mein                  130.0
8.) Dumplings                  140.0
9.) Hot and Sour Soup                  110.0
10.) Szechuan Beef                  280.0

Enter 0 to go back to Restaurant list screen.
Enter -1 to view cart.

Enter the choice (index) :
2
Enter the quantity : 
2
added : Kung Pao Chicken

Menu :
Item                  Price
__________________________________
1.) Sweet and Sour Pork                  220.0
2.) Kung Pao Chicken                  200.0
3.) Spring Rolls                  120.0
4.) Fried Rice                  150.0
5.) Peking Duck                  450.0
6.) Mapo Tofu                  180.0
7.) Chow Mein                  130.0
8.) Dumplings                  140.0
9.) Hot and Sour Soup                  110.0
10.) Szechuan Beef                  280.0

Enter 0 to go back to Restaurant list screen.
Enter -1 to view cart.

Enter the choice (index) :
-1
____________________________________________________________
Name            Price           Quantity        Total Price
____________________________________________________________
Mansaf          Rs.350.00        22              Rs.7700.00
Falafel         Rs.80.00         11              Rs.880.00       
Sweet and Sour Pork Rs.220.00        12              Rs.2640.00
Kung Pao Chicken Rs.200.00        2               Rs.400.00
____________________________________________________________
_______________________
Enter 0 to go back.
Enter 1 to place order.
0
_______________________________________________________________________
Golden Wok
Wok Your Way to Happiness
1.) Proceed to Order
2.) Back to Restaurant List
2

Listing the available Restaurants :
1.) Al-Arabita
2.) Golden Wok
3.) Casa de Salsa
4.) Curry Culture

Enter 0 to logoff
Enter -1 to viewCart

Enter the choice (index):
4
_______________________________________________________________________
Curry Culture
Spice Up Your Life with Authentic Indian Flavors
1.) Proceed to Order
2.) Back to Restaurant List
1

Menu :
Item                  Price
__________________________________
1.) Butter Chicken                  240.0
2.) Paneer Tikka                  180.0
3.) Masala Dosa                  90.0
4.) Chole Bhature                  130.0
5.) Hyderabadi Biryani                  220.0
6.) Rogan Josh                  260.0
7.) Aloo Paratha                  80.0
8.) Dal Makhani                  150.0
9.) Samosa                  40.0
10.) Gulab Jamun                  70.0

Enter 0 to go back to Restaurant list screen.
Enter -1 to view cart.

Enter the choice (index) :
4
Enter the quantity : 
5
added : Chole Bhature

Menu :
Item                  Price
__________________________________
1.) Butter Chicken                  240.0
2.) Paneer Tikka                  180.0
3.) Masala Dosa                  90.0
4.) Chole Bhature                  130.0
5.) Hyderabadi Biryani                  220.0
6.) Rogan Josh                  260.0
7.) Aloo Paratha                  80.0
8.) Dal Makhani                  150.0
9.) Samosa                  40.0
10.) Gulab Jamun                  70.0

Enter 0 to go back to Restaurant list screen.
Enter -1 to view cart.

Enter the choice (index) :
9
Enter the quantity : 
24
added : Samosa

Menu :
Item                  Price
__________________________________
1.) Butter Chicken                  240.0
2.) Paneer Tikka                  180.0
3.) Masala Dosa                  90.0
4.) Chole Bhature                  130.0
5.) Hyderabadi Biryani                  220.0
6.) Rogan Josh                  260.0
7.) Aloo Paratha                  80.0
8.) Dal Makhani                  150.0
9.) Samosa                  40.0
10.) Gulab Jamun                  70.0

Enter 0 to go back to Restaurant list screen.
Enter -1 to view cart.

Enter the choice (index) :
-1
____________________________________________________________
Name            Price           Quantity        Total Price
____________________________________________________________
Mansaf          Rs.350.00        22              Rs.7700.00
Falafel         Rs.80.00         11              Rs.880.00
Sweet and Sour Pork Rs.220.00        12              Rs.2640.00
Kung Pao Chicken Rs.200.00        2               Rs.400.00
Chole Bhature   Rs.130.00        5               Rs.650.00
Samosa          Rs.40.00         24              Rs.960.00
____________________________________________________________
_______________________
Enter 0 to go back.
Enter 1 to place order.
1
Order finalised. Proceeding with payment...

Choose payment method:
1) Cash
2) Card
2

Please enter your card details:
Card Number: 111111111111111111
PIN: 123
Card payment successful.

Payment successful using Card.
Thank you for your order!

