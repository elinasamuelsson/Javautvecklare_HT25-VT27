package restaurantsim.commands;

import restaurantsim.managers.CommandManager;
import restaurantsim.managers.VariableManager;
import restaurantsim.models.Food;

public class OrderFood {
    public static void execute(String orderedFoodItem) {
        for (Food food : VariableManager.getCurrentSelectedRestaurant().getMenu()) {
            if (food.getName().equalsIgnoreCase(orderedFoodItem)) {
                if (personHasEnoughMoney(food)) {
                    VariableManager.getOrderedFoodItems().add(food);
                    VariableManager.setOrderedFoodItemsCost(food.getCost());

                    System.out.println();
                    System.out.println("---------------------------------------------");
                    System.out.println();
                    System.out.println(VariableManager.getCurrentSelectedPerson().getName() + " has ordered " + food.getName() + ".");
                    System.out.println();
                    System.out.println("---------------------------------------------");
                    System.out.println();
                } else {
                    System.out.println("---------------------------------------------");
                    System.out.println();
                    System.out.println(VariableManager.getCurrentSelectedPerson().getName() + " can't afford " + food.getName() + ".");
                    System.out.println();
                    System.out.println("---------------------------------------------");
                }
            }
        }
        CommandManager.restaurantMenu();
    }

    private static boolean personHasEnoughMoney(Food orderedFoodItem) {
        return !((VariableManager.getOrderedFoodItemsCost() + orderedFoodItem.getCost())
                > VariableManager.getCurrentSelectedPerson().getWallet());
    }
}
