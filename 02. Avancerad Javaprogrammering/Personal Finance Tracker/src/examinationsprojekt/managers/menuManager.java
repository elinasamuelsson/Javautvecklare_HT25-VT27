package examinationsprojekt.managers;

import examinationsprojekt.commands.AddTransaction;
import examinationsprojekt.commands.DeleteTransaction;
import examinationsprojekt.commands.ViewTransactions;
import examinationsprojekt.models.Transaction;

import java.util.Scanner;

import static examinationsprojekt.Main.accountBalance;
import static examinationsprojekt.Main.transactions;

public class menuManager {
    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("What do you wish to do?");
            System.out.println("1. View account balance");
            System.out.println("2. Add earnings");
            System.out.println("3. Add spending");
            System.out.println("4. View transaction log");
            System.out.println("5. Delete transaction");
            System.out.println("0. Save and exit program");

            String userMainMenuChoice = scanner.nextLine();

            switch (userMainMenuChoice) {
                case "1": //account balance
                    System.out.println("Your current balance is " + accountBalance + ".");
                    break;
                case "2": //earn
                    Transaction newEarningsTransaction = AddTransaction.execute(true);
                    transactions.add(newEarningsTransaction);
                    fileManager.saveDataToFile();
                    System.out.println("Your transaction has been added.");
                    break;
                case "3": //spend
                    Transaction newSpendingTransaction = AddTransaction.execute(false);
                    transactions.add(newSpendingTransaction);
                    fileManager.saveDataToFile();
                    System.out.println("Your transaction has been added.");
                    break;
                case "4": //transaction log sub menu
                    menuManager.viewTransactionsMenu();
                    break;
                case "5": //delete
                    DeleteTransaction.execute();
                    fileManager.saveDataToFile();
                    break;
                case "0": //exit program
                    fileManager.saveDataToFile();
                    System.out.println("Thank you for using our program.");
                    System.out.println("We look forward to you coming back!");
                    return;
                default:
                    System.out.println("This option does not exist. Try again.");
            }
        }
    }

    public static void viewTransactionsMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you wish to do?");
        System.out.println("1. View all earnings");
        System.out.println("2. View all spending");
        System.out.println("0. Return");

        String userTransactionMenuChoice = scanner.nextLine();

        switch (userTransactionMenuChoice) {
            case "1": //view earning
                menuManager.sortTransactionsByMenu(true);
                break;
            case "2": //view spending
                menuManager.sortTransactionsByMenu(false);
                break;
            case "0": //exit to main menu
                menuManager.mainMenu();
                break;
            default:
                System.out.println("This option does not exist. Try again.");
                break;
        }
    }

    public static void sortTransactionsByMenu(boolean isEarning) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How do you want your transactions sorted?");
        System.out.println("1. View by year");
        System.out.println("2. View by month");
        System.out.println("3. View by week");
        System.out.println("4. View by day");
        System.out.println("5. View by category");
        System.out.println("0. Return");

        String userSortingMenuChoice = scanner.nextLine();

        switch (userSortingMenuChoice) {
            case "1": //by year
                ViewTransactions.byYear(isEarning);
                break;
            case "2": //by month
                ViewTransactions.byMonth(isEarning);
                break;
            case "3": //by week
                ViewTransactions.byWeek(isEarning);
                break;
            case "4": //by day
                ViewTransactions.byDay(isEarning);
                break;
            case "5"://by category
                ViewTransactions.byCategory(isEarning);
                break;
            case "0": //return to transactions submenu
                menuManager.viewTransactionsMenu();
                break;
            default:
                System.out.println("This option does not exist. Try again.");

        }
    }
}
