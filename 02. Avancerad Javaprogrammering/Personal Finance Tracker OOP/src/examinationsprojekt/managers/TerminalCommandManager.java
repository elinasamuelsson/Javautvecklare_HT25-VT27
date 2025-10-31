package examinationsprojekt.managers;

import examinationsprojekt.commands.*;
import examinationsprojekt.models.Account;
import examinationsprojekt.models.ViewOptions;
import examinationsprojekt.repository.FileRepository;
import examinationsprojekt.repository.IRepository;
import examinationsprojekt.repository.ListRepository;
import examinationsprojekt.utils.IReadUserInput;
import examinationsprojekt.utils.ReadUserTerminalInput;

import java.util.List;

public class TerminalCommandManager implements ICommandManager {
    IReadUserInput input = new ReadUserTerminalInput();

    public void run() {
        System.out.println("Welcome to the revised OOP version of the Personal Finance Tracker!");

        while (true) {
            printMainMenuOptions();

            String userInput = input.stringInput();
            ICommand command = getMainMenuCommand(userInput);

            if (command != null) {
                command.run();
            } else if (userInput.equals("5")) { //move validation into viewTransactionsCommand
                IRepository repository = new FileRepository();
                Account accountToView = null;

                if (CurrentStateManager.getCurrentAccount() == null) {
                    System.out.println("Select an account before viewing account balance.");
                    continue;
                }

                List<Account> accounts = repository.read();
                for (Account account : accounts) {
                    if (account.getName().equals(CurrentStateManager.getCurrentAccount().getName())) {
                        accountToView = account;
                    }
                }

                if (accountToView == null) {
                    System.out.println("Select an account before viewing transactions.");
                } else {
                    viewTransactionsSubMenu();
                }
            } else if (userInput.equals("0")) {
                System.out.println("Exiting program.");
                System.exit(0);
            } else {
                System.out.println("Invalid command. Try again.");
            }
        }
    }

    private void viewTransactionsSubMenu() {
        ICommand command;
        String userInput = "";
        while (true) {
            boolean viewEarning = userWantsToViewEarning();

            printViewTransactionsMenuOptions();
            userInput = input.stringInput();
            command = getViewTransactionsMenuCommand(userInput, viewEarning);

            if (command != null) {
                command.run();
            } else if (userInput.equals("0")) {
                return;
            } else {
                System.out.println("Invalid command. Try again.");
            }
        }
    }

    private void printMainMenuOptions() {
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println("Please select an option from the following:");
        System.out.println("\t1. Add account");
        System.out.println("\t2. Select account");
        System.out.println("\t3. Delete account");
        System.out.println("\t4. Add transaction");
        System.out.println("\t5. View transactions");
        System.out.println("\t6. Delete transaction");
        System.out.println("\t7. Search transactions");
        System.out.println("\t8. View account balance");
        System.out.println("\t0. Exit program");
        System.out.println("-------------------------------------------");
        System.out.println();
    }

    private ICommand getMainMenuCommand(String userInput) {
        return switch (userInput) {
            case "1" -> new AddAccountCommand();
            case "2" -> new SelectAccountCommand();
            case "3" -> new DeleteAccountCommand();
            case "4" -> new AddTransactionCommand();
            case "6" -> new DeleteTransactionCommand();
            case "7" -> new SearchTransactionCommand();
            case "8" -> new ViewAccountBalanceCommand();
            default -> null;
        };
    }

    private void printEarningOrSpendingMenuOptions() {
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println("Please select an option from the following:");
        System.out.println("\t1. View earnings");
        System.out.println("\t2. View spending");
        System.out.println("\t0. Return to main menu");
        System.out.println("-------------------------------------------");
        System.out.println();
    }

    private boolean userWantsToViewEarning() {
        String userInput = "";

        while (true) {
            printEarningOrSpendingMenuOptions();

            userInput = input.stringInput();

            if (userInput.equals("1")) {
                return true;
            } else if (userInput.equals("2")) {
                return false;
            } else if (userInput.equals("0")) {
                run();
            }
        }
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
        System.out.println("\t0. Return to earnings or spending");
        System.out.println("-------------------------------------------");
        System.out.println();
    }

    private ICommand getViewTransactionsMenuCommand(String userInput, boolean viewEarning) {
        return switch (userInput) {
            case "1" -> new ViewTransactionsCommand(ViewOptions.YEARLY, viewEarning);
            case "2" -> new ViewTransactionsCommand(ViewOptions.MONTHLY, viewEarning);
            case "3" -> new ViewTransactionsCommand(ViewOptions.WEEKLY, viewEarning);
            case "4" -> new ViewTransactionsCommand(ViewOptions.DAILY, viewEarning);
            case "5" -> new ViewTransactionsCommand(ViewOptions.CATEGORY, viewEarning);
            default -> null;
        };
    }
}