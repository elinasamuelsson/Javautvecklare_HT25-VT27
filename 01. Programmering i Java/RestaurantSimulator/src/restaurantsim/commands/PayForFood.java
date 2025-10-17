package restaurantsim.commands;

import restaurantsim.managers.CommandManager;
import restaurantsim.managers.VariableManager;

public class PayForFood {
    public static void execute() {
        VariableManager.getCurrentSelectedPerson().setWalletSub(VariableManager.getOrderedFoodItemsCost());
        VariableManager.getOrderedFoodItems().clear();
        VariableManager.setOrderedFoodItemsCostToZero();

        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();
        System.out.println(VariableManager.getCurrentSelectedPerson().getName() + " paid for their food.");
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();

        CommandManager.restaurantMenu();
    }
}
