package examinationsprojekt.commands;

import examinationsprojekt.models.Account;
import examinationsprojekt.models.AccountTypes;
import examinationsprojekt.models.CheckingAccount;
import examinationsprojekt.models.SavingsAccount;
import examinationsprojekt.repository.FileRepository;
import examinationsprojekt.repository.IRepository;
import examinationsprojekt.repository.ListRepository;
import examinationsprojekt.utils.IReadUserInput;
import examinationsprojekt.utils.ReadUserTerminalInput;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class AddAccountCommand implements ICommand {
    private final IReadUserInput input = new ReadUserTerminalInput();

    public void run() {
        Account account = null;
        IRepository repository = new FileRepository();

        //all account types need the following:
        AccountTypes type = returnAccountType();
        String name = returnAccountName();
        String owner = returnAccountOwner();

        if (type.equals(AccountTypes.CHECKING)) {
            account = new CheckingAccount(name, owner, type);
        } else if (type.equals(AccountTypes.SAVING)) {
            double interest = returnAccountInterest();
            account = new SavingsAccount(name, owner, type, interest);
        }

        List<Account> existingAccounts = repository.read();
        for (Account existingAccount : existingAccounts) {
            if (existingAccount.getName().equals(account.getName())) {
                System.out.println("Account name already exists in another account.");
                System.out.println("Restart account creation and try again.");
                return;
            }
        }

        repository.create(account);
        System.out.println("Account successfully created.");
        System.out.println("Returning to menu.");
    }


    private AccountTypes returnAccountType() {
        System.out.println("What type of account do you wish to create?"); //loop through and print Account Types rather than hardcode
        System.out.println("\t1. Checking account");
        System.out.println("\t2. Savings account");

        String userInput = "";
        while (true) {
            userInput = input.stringInput();
            switch (userInput) {
                case "1":
                    return AccountTypes.CHECKING;
                case "2":
                    return AccountTypes.SAVING;
                default:
                    System.out.println("Option does not exist. Please enter a valid option.");
                    break;
            }
        }
    }

    private String returnAccountOwner() {
        System.out.println("Enter the owner of this account.");

        String userInput = "";
        while (true) { //loop appears in multiple functions, break out and put in own helper function
            userInput = input.stringInput();

            if (userInput.isEmpty()) {
                System.out.println("Account must have an owner.");
            } else break;
        }
        return userInput;
    }

    private String returnAccountName() {
        System.out.println("Enter the name you wish to give this account.");

        String userInput = "";
        while (true) {
            userInput = input.stringInput();

            if (userInput.isEmpty()) {
                System.out.println("Account must have a name.");
            } else break;
        }
        return userInput;
    }

    private double returnAccountInterest() {
        System.out.println("Enter your savings account's monthly interest.");

        double userInput = 0;
        while (true) {
            try {
                userInput = input.doubleInput();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Interest must be a valid number.");
            }
        }
        return userInput;
    }
}
