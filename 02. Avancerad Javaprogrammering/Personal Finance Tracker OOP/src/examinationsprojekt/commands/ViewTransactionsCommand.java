package examinationsprojekt.commands;

import examinationsprojekt.managers.CurrentStateManager;
import examinationsprojekt.models.Account;
import examinationsprojekt.models.Transaction;
import examinationsprojekt.models.ViewOptions;
import examinationsprojekt.repository.ListRepository;
import examinationsprojekt.utils.IReadUserInput;
import examinationsprojekt.utils.ReadUserTerminalInput;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;

public class ViewTransactionsCommand implements ICommand {
    private final ViewOptions option;
    IReadUserInput input = new ReadUserTerminalInput();

    public ViewTransactionsCommand(ViewOptions option) {
        this.option = option;
    }

    public void run() {
        ListRepository repository = new ListRepository();
        Account accountToView = null;

        for (Account account : repository.read()) {
            if (account.equals(CurrentStateManager.getCurrentAccount())) {
                accountToView = account;
                System.out.println("Account " + account.getName() + " has been prepped for view.");
            }
        }

        try {
            printTransactions(option, accountToView);
        } catch (NullPointerException exception) {
            System.out.println("No account to print.");
        }
    }

    private void printTransactions(ViewOptions option, Account account) {
        List<Transaction> transactions = sortAllTransactions(account);

        if (option.equals(ViewOptions.YEARLY)) {
            int dateToPrint = LocalDateTime.now().getYear();

            while (true) {
                System.out.println("________________" + dateToPrint + "________________\n");
                for (Transaction transaction : transactions) {
                    if (transaction.getTime().getYear() == dateToPrint) {
                        printTransaction(transaction);
                    }
                }

                System.out.println("What do you want to do?");
                System.out.println("1. View previous year");
                System.out.println("2. View next year");
                System.out.println("3. Manually select year");
                System.out.println("0. Return");

                String userInput = input.stringInput();
                switch (userInput) {
                    case "1":
                        dateToPrint--;
                        break;
                    case "2":
                        dateToPrint++;
                        break;
                    case "3":
                        try {
                            System.out.println("Enter the year you wish to view: ");
                            dateToPrint = input.intInput();
                        } catch (InputMismatchException exception) {
                            System.out.println("Please enter a valid year.");
                        }
                        break;
                    case "0":
                        return;
                    default:
                        System.out.println("This option does not exist. Try again.");
                }
            }
        } else if (option.equals(ViewOptions.MONTHLY)) {
            System.out.println("printed monthly transactions list");
        } else if (option.equals(ViewOptions.WEEKLY)) {
            System.out.println("printed weekly transactions list");
        } else if (option.equals(ViewOptions.DAILY)) {
            System.out.println("printed daily transactions list");
        } else if (option.equals(ViewOptions.CATEGORY)) {
            System.out.println("printed transactions list by category");
        }
    }

    private List<Transaction> sortAllTransactions(Account account) {
        List<Transaction> transactionsToSort = new ArrayList<Transaction>(account.getTransactionsCopy());

        transactionsToSort.sort(
                Comparator.comparingInt((Transaction transaction) -> transaction.getTime().getYear()).reversed()
                        .thenComparing(transaction -> transaction.getTime().getMonthValue())
                        .thenComparing(transaction -> transaction.getTime().getDayOfYear()));

        return transactionsToSort;
    }

    private void printTransaction(Transaction transaction) {
        System.out.println("-------------------------------------------");
        System.out.print("Time: \t \t \t" + transaction.getTime().getDayOfMonth() + "-" +
                transaction.getTime().getMonthValue() + "-" + transaction.getTime().getYear() + ", ");
        System.out.println(transaction.getTime().getHour() + ":" + transaction.getTime().getMinute());
        System.out.println("Amount: \t \t \t" + transaction.getAmount());
        System.out.println("Type: \t \t \t" + transaction.getType().getTypeDescription());
        System.out.println("Description: \t \t" + transaction.getDescription());
        System.out.println("ID: \t \t \t" + transaction.getId());
        System.out.println("-------------------------------------------");
    }
}
