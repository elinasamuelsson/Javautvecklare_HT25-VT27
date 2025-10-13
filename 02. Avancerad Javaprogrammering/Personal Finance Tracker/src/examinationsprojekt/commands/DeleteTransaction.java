package examinationsprojekt.commands;

import examinationsprojekt.managers.menuManager;
import examinationsprojekt.models.Transaction;

import java.util.Scanner;

import static examinationsprojekt.Main.transactions;

public class DeleteTransaction {
    public static void execute() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the ID of the transaction you wish to delete, whole or partial.");
            String IDInput = scanner.nextLine();

            for (Transaction transaction : transactions) {
                if (transaction.getId().toString().contains(IDInput)) {
                    ViewTransactions.printTransaction(transaction);
                    System.out.println("Is this the transaction you wish to delete?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    String confirmInput = scanner.nextLine();

                    switch (confirmInput) {
                        case "1":
                            transactions.remove(transaction);
                            System.out.println("Transaction successfully deleted.\n");
                            menuManager.mainMenu();
                            break;
                        case "2":
                            System.out.println("Returning to main menu.\n");
                            menuManager.mainMenu();
                            break;
                        default:
                            System.out.println("Invalid input, try again.");
                    }

                }
            }
        }
    }
}
