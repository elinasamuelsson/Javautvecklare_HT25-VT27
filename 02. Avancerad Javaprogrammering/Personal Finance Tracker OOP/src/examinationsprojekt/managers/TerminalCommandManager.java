package examinationsprojekt.managers;

import examinationsprojekt.commands.*;
import examinationsprojekt.utils.IReadUserInput;
import examinationsprojekt.utils.ReadUserTerminalInput;

public class TerminalCommandManager implements ICommandManager {
    public void run() {
        System.out.println("Welcome to the revised OOP version of the Personal Finance Tracker!");

        IReadUserInput input = new ReadUserTerminalInput();
        ICommand command;
        String userInput = "";

        while (true) {
            printMenuOptions();
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
                    command = new ViewTransactionsCommand();
                    command.run();
                    break;
                case "6":
                    command = new DeleteTransactionCommand();
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

    private void printMenuOptions() {
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

    private void getCommand() {} //add logic to select command here instead of in run()-method to avoid repetition
}
