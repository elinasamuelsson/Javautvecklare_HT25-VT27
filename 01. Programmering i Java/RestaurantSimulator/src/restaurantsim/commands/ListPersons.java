package restaurantsim.commands;

import restaurantsim.managers.CommandManager;
import restaurantsim.managers.VariableManager;
import restaurantsim.models.Person;

public class ListPersons {
    public static void execute() {
        System.out.println();
        System.out.println("----- list of persons -----");
        System.out.println();

        for (Person person : VariableManager.getPersons()) {
            System.out.println(person.getName() + ", available funds: " + person.getWallet() + ":-");
            System.out.println();
        }

        System.out.println("----------------------------");
        System.out.println();

        CommandManager.mainMenu();
    }
}
