package restaurantsim.commands;

import restaurantsim.managers.CommandManager;
import restaurantsim.managers.VariableManager;
import restaurantsim.models.Food;

public class EatFood {
    public static void execute() {
        System.out.println("------------------------");
        System.out.println();
        System.out.println(VariableManager.getCurrentSelectedPerson().getName() + " ate:");
        System.out.println();

        for (Food food : VariableManager.getOrderedFoodItems()) {
            System.out.println(food.getName());
            System.out.println();
        }

        System.out.println("------------------------");

        CommandManager.restaurantMenu();
    }
}
