package restaurantsim.commands;

import restaurantsim.managers.CommandManager;
import restaurantsim.managers.VariableManager;
import restaurantsim.models.Restaurant;

import static restaurantsim.managers.CommandManager.restaurantMenu;

public class EnterRestaurant {
    public static void execute(String selectedRestaurantInput) {
        for (Restaurant restaurant : VariableManager.getRestaurants()) {
            if (restaurant.getName().equalsIgnoreCase(selectedRestaurantInput)) {
                System.out.println();
                System.out.println("---------------------------------------------");
                System.out.println();
                System.out.println(VariableManager.getCurrentSelectedPerson().getName() + " has entered " + restaurant.getName() + ".");
                System.out.println("They can now look at the menu and order food.");
                System.out.println();
                System.out.println("---------------------------------------------");
                System.out.println();

                VariableManager.setCurrentSelectedRestaurant(restaurant);
                CommandManager.restaurantMenu();
            }
        }
    }
}
