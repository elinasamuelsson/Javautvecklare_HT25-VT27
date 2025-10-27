package examinationsprojekt.commands;

import examinationsprojekt.managers.CurrentStateManager;
import examinationsprojekt.models.Account;
import examinationsprojekt.models.Transaction;
import examinationsprojekt.models.TransactionTypes;
import examinationsprojekt.repository.IRepository;
import examinationsprojekt.repository.ListRepository;
import examinationsprojekt.utils.IReadUserInput;
import examinationsprojekt.utils.ReadUserTerminalInput;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;

public class AddTransactionCommand implements ICommand {
    private final IReadUserInput input = new ReadUserTerminalInput();

    public void run() {
        if (CurrentStateManager.getCurrentAccount() == null) {
            System.out.println("Select an account before adding transactions.");
            return;
        }
        Account account = CurrentStateManager.getCurrentAccount();
        IRepository repository = new ListRepository();

        TransactionTypes type = returnType();
        LocalDateTime time = returnTime();
        String description = returnDescription();
        double amount = 0;
        if (type == TransactionTypes.SALARY || //find a way to not hardcode this
                type == TransactionTypes.GIFT ||
                type == TransactionTypes.INTEREST ||
                type == TransactionTypes.OTHER_EARNING) {
            amount = returnAmountEarned();
        } else {
            amount = returnAmountSpent();
        }

        Transaction transaction = new Transaction(amount, time, type, description);

        account.addTransactionToList(transaction);

        if (!repository.update(account)) {
            repository.create(account);
            return;
        }

        repository.update(account);
    }

    private TransactionTypes returnType() {
        System.out.println("What type of transaction do you wish to add?");

        for (int i = 0; i < TransactionTypes.values().length; i++) {
            System.out.println("\t" + (i + 1) + ". " + TransactionTypes.values()[i]);
        }

        int userInput = 0;

        while (true) {
            userInput = input.intInput();
            try {
                if (userInput == 0 ||
                        userInput >= TransactionTypes.values().length) {
                    System.out.println("Please enter a valid option.");
                } else {
                    return TransactionTypes.values()[userInput];
                }
            } catch (InputMismatchException exception) {
                System.out.println(exception.getMessage());
                System.out.println("Please enter a valid number option.");
            }
        }
    }

    private LocalDateTime returnTime() {
        System.out.println("Enter date and time of the transaction.");
        System.out.println("Please use the format YYYY-MM-DD HH:MM");

        LocalDateTime time;
        String userInput = "";
        while (true) {
            try {
                userInput = input.stringInput();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                time = LocalDateTime.parse(userInput, formatter);

                return time;
            } catch (DateTimeParseException exception) {
                System.out.println("Invalid date format. Try again.");
                System.out.println("Please use the format YYYY-MM-DD HH:MM");
            }
        }
    }

    private String returnDescription() {
        System.out.println("Briefly describe the transaction.");

        String userInput = "";
        while (true) {
            userInput = input.stringInput();

            if (userInput.isEmpty()) {
                System.out.println("Transaction must have a description.");
            } else {
                return userInput;
            }
        }
    }

    private double returnAmountEarned() {
        System.out.println("Enter transaction amount.");
        while (true) {
            try {
                return input.doubleInput();
            } catch (InputMismatchException exception) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private double returnAmountSpent() {
        System.out.println("Enter transaction amount.");
        while (true) {
            try {
                return Double.parseDouble(("-" + input.stringInput()));
            } catch (InputMismatchException exception) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
