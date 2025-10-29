package examinationsprojekt.commands;

import examinationsprojekt.managers.CurrentStateManager;
import examinationsprojekt.models.Account;
import examinationsprojekt.models.Transaction;
import examinationsprojekt.models.ViewOptions;
import examinationsprojekt.repository.ListRepository;
import examinationsprojekt.utils.IReadUserInput;
import examinationsprojekt.utils.ReadUserTerminalInput;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
            List<Transaction> transactions = sortAllTransactions(accountToView);

            if (option.equals(ViewOptions.YEARLY)) {
                viewYearly(transactions);
            } else if (option.equals(ViewOptions.MONTHLY)) {
                viewMonthly(transactions);
            } else if (option.equals(ViewOptions.WEEKLY)) {
                System.out.println("printed weekly transactions list");
            } else if (option.equals(ViewOptions.DAILY)) {
                System.out.println("printed daily transactions list");
            } else if (option.equals(ViewOptions.CATEGORY)) {
                System.out.println("printed transactions list by category");
            }
        } catch (NullPointerException exception) {
            System.out.println("No account to print.");
        }
    }

    private void viewYearly(List<Transaction> transactions) {
        int dateToPrint = LocalDateTime.now().getYear();

        while (true) {
            System.out.println("----------------" + dateToPrint + "----------------");
            System.out.println();
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
    }

    private void viewMonthly(List<Transaction> transactions) {
        LocalDateTime dateToPrint = LocalDateTime.now();

        while (true) {
            System.out.println("----------------" + dateToPrint.getMonth().toString() + " " +
                    dateToPrint.getYear() + "----------------");
            System.out.println();
            for (Transaction transaction : transactions) {
                if (transaction.getTime().getMonthValue() == dateToPrint.getMonthValue()
                        && transaction.getTime().getYear() == dateToPrint.getYear()) {
                    printTransaction(transaction);
                }
            }

            System.out.println("What do you wish to do?");
            System.out.println("1. View previous month");
            System.out.println("2. View next month");
            System.out.println("3. Manually select month");
            System.out.println("0. Return");

            String userInput = input.stringInput();
            switch (userInput) {
                case "1":
                    dateToPrint = dateToPrint.minusMonths(1);
                    break;
                case "2":
                    dateToPrint = dateToPrint.plusMonths(1);
                    break;
                case "3":
                    try {
                        System.out.println("Enter date of the day you wish to view: ");
                        System.out.println("Please use the format YYYY-MM");
                        String dateInput = input.stringInput();

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                        dateToPrint = LocalDateTime.parse((dateInput + "-01 12:00"), formatter);
                    } catch (DateTimeParseException exception) {
                        System.out.println("Please enter a valid date.");
                        System.out.println("Please use the format YYYY-MM");

                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println("This option does not exist. Try again.");
            }
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
