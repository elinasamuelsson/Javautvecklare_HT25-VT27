package restaurantsim.commands;

import restaurantsim.managers.CommandManager;
import restaurantsim.managers.VariableManager;

public class LeaveRestaurant {
    public static void execute() {
        if (personHasPayed()) {
            System.out.println();
            System.out.println("------------------------");
            System.out.println();
            System.out.println(VariableManager.getCurrentSelectedPerson().getName() + " left " + VariableManager.getCurrentSelectedRestaurant().getName() + ".");
            System.out.println();
            System.out.println("------------------------");
            System.out.println();

            VariableManager.setCurrentSelectedRestaurant(null);
            CommandManager.mainMenu();
        } else {
            System.out.println();
            System.out.println("------------------------");
            System.out.println();
            System.out.println(VariableManager.getCurrentSelectedPerson().getName() + " has to pay before leaving.");
            System.out.println();
            System.out.println("------------------------");
            System.out.println();

            CommandManager.restaurantMenu();
        }
    }

    private static boolean personHasPayed() {
        return VariableManager.getOrderedFoodItemsCost() == 0;
    }
}
