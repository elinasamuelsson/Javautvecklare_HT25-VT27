package examinationsprojekt.managers;

import examinationsprojekt.commands.*;
import examinationsprojekt.utils.ReadUserTerminalInput;

public class TerminalCommandManager implements ICommandManager {
    public void run() {
        System.out.println("Welcome to the revised OOP version of the Personal Finance Tracker!");

        printMenuOptions();

        ReadUserTerminalInput input = new ReadUserTerminalInput();
        ICommand command;
        String userInput = "";

        while (true) {
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
        System.out.println("\t0. Exit program");
        System.out.println("-------------------------------------------");
        System.out.println();
    }

    private void getCommand() {} //add logic to select command here instead of in run()-method to avoid repetition
}
