package restaurantsim.commands;

import restaurantsim.managers.CommandManager;
import restaurantsim.managers.VariableManager;
import restaurantsim.models.Restaurant;

public class ListRestaurants {
    public static void execute() {
        System.out.println();
        System.out.println("----- list of restaurants -----");
        System.out.println();

        for (Restaurant restaurant : VariableManager.getRestaurants()) {
            System.out.println(restaurant.getName());
            System.out.println();
        }

        System.out.println("--------------------------------");
        System.out.println();

        CommandManager.mainMenu();
    }
}
