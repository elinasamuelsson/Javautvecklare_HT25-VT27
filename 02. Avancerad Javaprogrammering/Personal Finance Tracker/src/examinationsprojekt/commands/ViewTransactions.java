package examinationsprojekt.commands;

import examinationsprojekt.managers.menuManager;
import examinationsprojekt.models.Transaction;
import examinationsprojekt.models.transactionTypes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

import static examinationsprojekt.Main.transactions;

public class ViewTransactions {
    static Scanner scanner = new Scanner(System.in);

    public static void byYear(boolean isEarning) {
        ArrayList<Transaction> transactionsToPrint = sortAllTransactions(earningOrSpendingTransactions(isEarning));

        int yearToPrint = LocalDateTime.now().getYear();

        while (true) {
            System.out.println("________________" + yearToPrint + "________________\n");
            for (Transaction transaction : transactionsToPrint) {
                if (transaction.getTime().getYear() == yearToPrint) {
                    printTransaction(transaction);
                }
            }

            System.out.println("What do you want to do?");
            System.out.println("1. View previous year");
            System.out.println("2. View next year");
            System.out.println("3. Manually select year");
            System.out.println("0. Return");

            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1":
                    yearToPrint--;
                    break;
                case "2":
                    yearToPrint++;
                    break;
                case "3":
                    try {
                        System.out.println("Enter the year you wish to view: ");
                        yearToPrint = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException exception) {
                        System.out.println("Please enter a valid year.");
                    }
                    break;
                case "0":
                    menuManager.sortTransactionsByMenu(isEarning);
                    break;
                default:
                    System.out.println("This option does not exist. Try again.");
            }
        }
    }

    public static void byMonth(boolean isEarning) {
        ArrayList<Transaction> transactionsToPrint = sortAllTransactions(earningOrSpendingTransactions(isEarning));

        LocalDateTime dateToPrint = LocalDateTime.now();

        while (true) {
            System.out.println("________________" + dateToPrint.getMonth().toString() + " " +
                    dateToPrint.getYear() + "________________\n");
            for (Transaction transaction : transactionsToPrint) {
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

            String userInput = scanner.nextLine();
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
                        String dateInput = scanner.nextLine();

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                        dateToPrint = LocalDateTime.parse((dateInput + "-01 12:00"), formatter);
                    } catch (DateTimeParseException exception) {
                        System.out.println("Please enter a valid date.");
                        System.out.println("Please use the format YYYY-MM");

                    }
                    break;
                case "0":
                    menuManager.sortTransactionsByMenu(isEarning);
                    break;
                default:
                    System.out.println("This option does not exist. Try again.");
            }
        }
    }

    public static void byWeek(boolean isEarning) {
        ArrayList<Transaction> transactionsToPrint = earningOrSpendingTransactions(isEarning);

        WeekFields week = WeekFields.ISO;
        LocalDateTime dateToPrint = LocalDateTime.now()
                .with(week.dayOfWeek(), 1);

        transactionsToPrint.sort(
                Comparator.comparingInt((Transaction transaction) -> transaction.getTime().get(week.weekBasedYear()))
                        .thenComparing(transaction -> transaction.getTime().get(week.weekOfWeekBasedYear())));

        while (true) {
            System.out.println("________________" + dateToPrint.get(week.weekOfWeekBasedYear()) + " " +
                    dateToPrint.get(week.weekBasedYear()) + "________________\n");
            for (Transaction transaction : transactionsToPrint) {
                if (transaction.getTime().get(week.weekBasedYear()) == dateToPrint.get(week.weekBasedYear())
                        && transaction.getTime().get(week.weekOfWeekBasedYear()) == dateToPrint.get(week.weekOfWeekBasedYear())) {
                    printTransaction(transaction);
                }
            }

            System.out.println("What do you wish to do?");
            System.out.println("1. View previous week");
            System.out.println("2. View next week");
            System.out.println("3. Manually select week");
            System.out.println("0. Return");

            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1":
                    dateToPrint = dateToPrint.minusDays(7);
                    break;
                case "2":
                    dateToPrint = dateToPrint.plusDays(7);
                    break;
                case "3":
                    try {
                        int weekInput = 0;
                        int yearInput = 0;

                        System.out.println("Enter the week you wish to view: ");
                        weekInput = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Enter the year of the week you wish to view: ");
                        yearInput = scanner.nextInt();
                        scanner.nextLine();


                        dateToPrint = LocalDateTime.of(yearInput, 1, 1, 12, 0)
                                .with(week.weekOfWeekBasedYear(), weekInput)
                                .with(week.dayOfWeek(), 1);
                    } catch (InputMismatchException exception) {
                        System.out.println("Please enter a valid week and year.");
                    }
                    break;
                case "0":
                    menuManager.sortTransactionsByMenu(isEarning);
                    break;
                default:
                    System.out.println("This option does not exist. Try again.");
            }
        }
    }

    public static void byDay(boolean isEarning) {
        ArrayList<Transaction> transactionsToPrint = sortAllTransactions(earningOrSpendingTransactions(isEarning));

        LocalDateTime dateToPrint = LocalDateTime.now();

        while (true) {
            System.out.println("________________" + dateToPrint.getDayOfMonth() + " " +
                    dateToPrint.getMonth() + " " + dateToPrint.getYear() + "________________\n");
            for (Transaction transaction : transactionsToPrint) {
                if (transaction.getTime().getDayOfYear() == dateToPrint.getDayOfYear()
                        && transaction.getTime().getYear() == dateToPrint.getYear()) {
                    printTransaction(transaction);
                }
            }

            System.out.println("What do you wish to do?");
            System.out.println("1. View previous day");
            System.out.println("2. View next day");
            System.out.println("3. Manually select day");
            System.out.println("0. Return");

            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1":
                    dateToPrint = dateToPrint.minusDays(1);
                    break;
                case "2":
                    dateToPrint = dateToPrint.plusDays(1);
                    break;
                case "3":
                    try {
                        System.out.println("Enter date of the day you wish to view: ");
                        System.out.println("Please use the format YYYY-MM-DD");
                        String dateInput = scanner.nextLine();


                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                        dateToPrint = LocalDateTime.parse((dateInput + " 12:00"), formatter);
                        break;
                    } catch (DateTimeParseException exception) {
                        System.out.println("Invalid date format. Try again.");
                        System.out.println("Please use the format YYYY-MM-DD");
                    }
                    break;
                case "0":
                    menuManager.sortTransactionsByMenu(isEarning);
                    break;
                default:
                    System.out.println("This option does not exist. Try again.");
            }
        }
    }

    public static void byCategory(boolean isEarning) {
        ArrayList<Transaction> transactionsToPrint = sortAllTransactions(earningOrSpendingTransactions(isEarning));

        String categoryToPrint = "";

        while (true) {
            try {
                System.out.println("Which category do you wish to view?");
                for (transactionTypes type : transactionTypes.values()) {
                    System.out.println(type.name());
                }
                System.out.println("To return type 'return'.");

                categoryToPrint = scanner.nextLine().toUpperCase();

                if (categoryToPrint.equals("RETURN")) {
                    menuManager.sortTransactionsByMenu(isEarning);
                }

                transactionTypes chosenCategory = transactionTypes.valueOf(categoryToPrint);

                System.out.println("________________" + chosenCategory.getTypeDescription() + "________________\n");
                for (Transaction transaction : transactionsToPrint) {
                    if (transaction.getType() == chosenCategory) {
                        printTransaction(transaction);
                    }
                }
            } catch (IllegalArgumentException exception) {
                System.out.println("Invalid category. Try again.");
            }
        }
    }

    private static ArrayList<Transaction> earningOrSpendingTransactions(boolean isEarning) {
        ArrayList<Transaction> transactionsToSort = new ArrayList<>();

        for (Transaction transaction : transactions) {
            if (isEarning && transaction.getIsEarning()) {
                transactionsToSort.add(transaction);
            } else if (!isEarning && !transaction.getIsEarning()) {
                transactionsToSort.add(transaction);
            }
        }
        return transactionsToSort;
    }

    private static ArrayList<Transaction> sortAllTransactions(ArrayList<Transaction> transactionsToSort) {
        transactionsToSort.sort(
                Comparator.comparingInt((Transaction transaction) -> transaction.getTime().getYear()).reversed()
                        .thenComparing(transaction -> transaction.getTime().getMonthValue())
                        .thenComparing(transaction -> transaction.getTime().getDayOfYear()));

        return transactionsToSort;
    }

    public static void printTransaction(Transaction transaction) {
        System.out.println("____________________________________");
        System.out.print("Time: \t \t \t" + transaction.getTime().getDayOfMonth() + "-" +
                transaction.getTime().getMonthValue() + "-" + transaction.getTime().getYear() + ", ");
        System.out.println(transaction.getTime().getHour() + ":" + transaction.getTime().getMinute());
        System.out.println("Amount: \t \t \t" + transaction.getAmount());
        System.out.println("Type: \t \t \t" + transaction.getType().getTypeDescription());
        System.out.println("Description: \t \t" + transaction.getDescription());
        System.out.println("ID: \t \t \t" + transaction.getId());
        System.out.println("____________________________________ \n");
    }
}