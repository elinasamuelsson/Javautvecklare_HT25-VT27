package restaurantsim.managers;

import restaurantsim.commands.*;
import java.util.Scanner;

public class CommandManager {
    public static void mainMenu() {
        printMainMenuOptions();

        while (true) {
            String userChoiceInput = takeInUserChoiceInput();

            if (userChoiceInput.equals("create person")) {
                CreatePerson.execute();
            } else if (userChoiceInput.equals("list persons")) {
                ListPersons.execute();
            } else if (userChoiceInput.startsWith("select person")) {
                try {
                    SelectPerson.execute(userChoiceInput.substring(14));
                } catch (StringIndexOutOfBoundsException exception) {
                    System.out.println("Enter the command along with an existing person's name as follows:");
                    System.out.println("select person [person]");
                }
            } else if (userChoiceInput.equals("list restaurants")) {
                ListRestaurants.execute();
            } else if (userChoiceInput.startsWith("enter restaurant")) {
                try {
                    EnterRestaurant.execute(userChoiceInput.substring(17));
                } catch (StringIndexOutOfBoundsException exception) {
                    System.out.println("Enter the command along with an existing restaurant's name as follows:");
                    System.out.println("enter restaurant [restaurant]");
                } catch (NullPointerException exception) {
                    System.out.println("Select a valid person before entering a restaurant.");
                }
            } else if (userChoiceInput.equals("close program")) {
                System.out.println("Thank you for playing!");
                System.exit(0);
            } else {
                System.out.println("Invalid action, try again.");
            }
        }
    }

    public static void restaurantMenu() {
        printRestaurantMenuOptions();

        while (true) {
            String userChoiceInput = takeInUserChoiceInput();

            if (userChoiceInput.equals("view menu")) {
                ListMenu.execute();
            } else if (userChoiceInput.startsWith("order food")) {
                try {
                    OrderFood.execute(userChoiceInput.substring(11));
                } catch (StringIndexOutOfBoundsException exception) {
                    System.out.println("Enter the command along with an existing dish as follows:");
                    System.out.println("order food [dish]");
                } catch (NullPointerException exception) {
                    System.out.println("Select a valid food option.");
                }
            } else if (userChoiceInput.equals("eat food")) {
                EatFood.execute();
            } else if (userChoiceInput.equals("view tab")) {
                System.out.println("view tab option");
                ViewTab.execute();
            } else if (userChoiceInput.equals("pay")) {
                System.out.println("pay option");
                PayForFood.execute();
            } else if (userChoiceInput.equals("leave restaurant")) {
                LeaveRestaurant.execute();
            } else if (userChoiceInput.equals("close program")) {
                System.out.println("Thank you for playing!");
                System.exit(0);
            } else {
                System.out.println("Invalid action, try again.");
            }
        }
    }

    private static String takeInUserChoiceInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }

    private static void printMainMenuOptions() {
        System.out.println("You can try the following actions:");
        System.out.println("Create person");
        System.out.println("List persons");
        System.out.println("Select person [person]");
        System.out.println("List restaurants");
        System.out.println("Enter restaurant [restaurant]");
        System.out.println("Close program");
        System.out.println();
        System.out.print("Enter command: ");
    }

    private static void printRestaurantMenuOptions() {
        System.out.println("You can try the following actions:");
        System.out.println("View menu");
        System.out.println("Order food [menu option]");
        System.out.println("Eat food");
        System.out.println("View tab");
        System.out.println("Pay");
        System.out.println("Leave restaurant");
        System.out.println("Close program");
    }
}
