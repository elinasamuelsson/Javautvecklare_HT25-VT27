package restaurantsim.commands;

import restaurantsim.managers.CommandManager;
import restaurantsim.managers.VariableManager;
import restaurantsim.models.Person;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreatePerson {
    public static void execute() {
        Scanner scanner = new Scanner(System.in);

        Person person = new Person();
        double userFundsInput = 0;

        System.out.print("Enter person's name: ");
        while (true) {
            person.setName(scanner.nextLine());

            if (!nameIsValid(person.getName())) {
                System.out.println("Enter a valid name.");
            } else {
                break;
            }
        }


        System.out.print("Enter person's available funds: ");
        while (userFundsInput <= 0) {
            try {
                userFundsInput = scanner.nextDouble();
                scanner.nextLine();
            } catch (InputMismatchException exception) {
                scanner.nextLine();
                System.out.println("Invalid amount.");
                System.out.println("Enter a number greater than 0.");
            }
        }

        person.setWalletAdd(userFundsInput);

        VariableManager.getPersons().add(person);

        System.out.println();
        System.out.println("----------------------------");
        System.out.println();
        System.out.println("Person created successfully.");
        System.out.println();
        System.out.println("----------------------------");
        System.out.println();

        CommandManager.mainMenu();
    }

    private static boolean nameIsValid(String nameInput) {
        return !nameInput.isEmpty() && nameInput.matches("[a-zA-ZåäöÅÄÖ ]+");
    }
}
