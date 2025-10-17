package restaurantsim.commands;

import restaurantsim.managers.CommandManager;
import restaurantsim.managers.VariableManager;
import restaurantsim.models.Food;

public class ViewTab {
    public static void execute() {
        System.out.println();
        System.out.println("------------ tab ------------");
        System.out.println();

        for (Food food : VariableManager.getOrderedFoodItems()) {

            System.out.println(food.getName() + "\t" + food.getCost() + ":-");
            System.out.println();
        }
        System.out.println("Food total sum \t" + VariableManager.getOrderedFoodItemsCost() + ":-");
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println();

        CommandManager.restaurantMenu();
    }
}
