package examinationsprojekt.managers;

import examinationsprojekt.commands.*;
import examinationsprojekt.models.ViewOptions;
import examinationsprojekt.utils.IReadUserInput;
import examinationsprojekt.utils.ReadUserTerminalInput;

public class TerminalCommandManager implements ICommandManager {
    IReadUserInput input = new ReadUserTerminalInput();

    public void run() {
        System.out.println("Welcome to the revised OOP version of the Personal Finance Tracker!");

        ICommand command;
        String userInput = "";

        while (true) {
            printMainMenuOptions();
            userInput = input.stringInput();

            switch (userInput) {
                case "1":
                    command = new AddAccountCommand();
                    command.run();
                    break;
                case "2":
                    command = new SelectAccountCommand();
                    command.run();
                    break;
                case "3":
                    command = new DeleteAccountCommand();
                    command.run();
                    break;
                case "4":
                    command = new AddTransactionCommand();
                    command.run();
                    break;
                case "5":
                    viewTransactionsSubMenu();
                    break;
                case "6":
                    command = new DeleteTransactionCommand();
                    command.run();
                    break;
                case "7":
                    command = new ViewAccountBalanceCommand();
                    command.run();
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Option does not exist. Please enter a valid option.");
            }
        }
    }

    private void viewTransactionsSubMenu() {
        ICommand command;
        String userInput = "";

        while (true) {
            printViewTransactionsMenuOptions();
            userInput = input.stringInput();

            switch (userInput) {
                case "1":
                    command = new ViewTransactionsCommand(ViewOptions.YEARLY);
                    command.run();
                    break;
                case "2":
                    command = new ViewTransactionsCommand(ViewOptions.MONTHLY);
                    command.run();
                    break;
                case "3":
                    command = new ViewTransactionsCommand(ViewOptions.WEEKLY);
                    command.run();
                    break;
                case "4":
                    command = new ViewTransactionsCommand(ViewOptions.DAILY);
                    command.run();
                    break;
                case "5":
                    command = new ViewTransactionsCommand(ViewOptions.CATEGORY);
                    command.run();
                    break;
                default:
                    break;
            }
        }
    }

    private void printMainMenuOptions() {
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println("Please select an option from the following:");
        System.out.println("\t1. Add account");
        System.out.println("\t2. Select account");
        System.out.println("\t3. Remove account");
        System.out.println("\t4. Add transaction");
        System.out.println("\t5. View transactions");
        System.out.println("\t6. Delete transaction");
        System.out.println("\t0. Exit program");
        System.out.println("-------------------------------------------");
        System.out.println();
    }

    private void printViewTransactionsMenuOptions() {
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println("Please select an option from the following:");
        System.out.println("\t1. Yearly");
        System.out.println("\t2. Monthly");
        System.out.println("\t3. Weekly");
        System.out.println("\t4. Daily");
        System.out.println("\t5. By category");
        System.out.println("\t0. Return to main menu");
        System.out.println("-------------------------------------------");
        System.out.println();
    }

    private void getCommand() {} //add logic to select command here instead of in run()-method to avoid repetition
}