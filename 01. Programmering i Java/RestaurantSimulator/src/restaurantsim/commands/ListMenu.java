package restaurantsim.commands;

import restaurantsim.managers.CommandManager;
import restaurantsim.managers.VariableManager;
import restaurantsim.models.Food;

public class ListMenu {
    public static void execute() {
        System.out.println("---------- menu ----------");
        System.out.println();

        for (Food menuItem : VariableManager.getCurrentSelectedRestaurant().getMenu()) {
            System.out.println(menuItem.getName() + ",\t" + menuItem.getCost() + ":-");
            System.out.println();
        }

        System.out.println("--------------------------");
        System.out.println();

        CommandManager.restaurantMenu();
    }
}
