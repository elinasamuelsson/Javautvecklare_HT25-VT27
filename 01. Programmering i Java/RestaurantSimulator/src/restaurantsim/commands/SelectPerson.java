package restaurantsim.commands;

import restaurantsim.managers.CommandManager;
import restaurantsim.managers.VariableManager;
import restaurantsim.models.Person;

public class SelectPerson {
    public static void execute(String selectedPersonInput) {
        for (Person person : VariableManager.getPersons()) {
            if (person.getName().equalsIgnoreCase(selectedPersonInput)) {
                System.out.println();
                System.out.println("--------------------------------");
                System.out.println();
                System.out.println(person.getName() + " selected.");
                System.out.println("They can now enter a restaurant.");
                System.out.println();
                System.out.println("--------------------------------");
                System.out.println();

                VariableManager.setCurrentSelectedPerson(person);
            }
        }
        CommandManager.mainMenu();
    }
}