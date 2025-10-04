package examinationsprojekt.commands;

import examinationsprojekt.models.Transaction;
import examinationsprojekt.models.transactionTypes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static examinationsprojekt.Main.accountBalance;

public class AddTransaction {
    public static Transaction execute(boolean isEarning) {


        double transactionAmount = 0;
        while (transactionAmount == 0) {
            transactionAmount = addAmount(isEarning);
        }

        transactionTypes transactionType = null;
        while (transactionType == null) {
            transactionType = addType();
        }

        String transactionDescription = "";
        while (transactionDescription == "") {
            transactionDescription = addDescription();
        }

        LocalDateTime transactionTime = null;
        while (transactionTime == null) {
            transactionTime = addTime();
        }

        accountBalance += transactionAmount;
        return new Transaction(transactionAmount, transactionTime, transactionType, transactionDescription, isEarning);
    }

    private static double addAmount(boolean isEarning) {
        Scanner scanner = new Scanner(System.in);

        double transactionAmount = 0;

        if (isEarning) {
            try {
                System.out.println("Enter amount earned;");
                transactionAmount = scanner.nextDouble();
                scanner.nextLine();
            } catch (InputMismatchException exception) {
                System.out.println("Invalid amount. Try again.");
            }
        } else {
            try {
                System.out.println("Enter amount spent;");
                transactionAmount = Double.parseDouble(("-" + scanner.nextLine()));
            } catch (InputMismatchException exception) {
                System.out.println("Invalid amount. Try again.");
            }
        }
        return transactionAmount;
    }

    private static transactionTypes addType() {
        Scanner scanner = new Scanner(System.in);

        transactionTypes transactionType;

        while (true) {
            try {
                System.out.println("Enter type of transaction from the following list:");
                for (transactionTypes type : transactionTypes.values()) {
                    System.out.println(type.name());
                }

                String transactionTypeInput = scanner.nextLine().toUpperCase();


                transactionType = transactionTypes.valueOf(transactionTypeInput);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println("Invalid transaction type. Try again.");
            }
        }

        return transactionType;
    }

    private static String addDescription() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a brief description of the transaction;");

        return scanner.nextLine();
    }

    private static LocalDateTime addTime() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter date and time of the transaction:");
        System.out.println("Please use the format YYYY-MM-DD HH:MM");

        LocalDateTime transactionTime;
        while (true) {
            try {
                String transactionTimeInput = scanner.nextLine();


                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                transactionTime = LocalDateTime.parse(transactionTimeInput, formatter);
                break;
            } catch (DateTimeParseException exception) {
                System.out.println("Invalid date format. Try again.");
                System.out.println("Please use the format YYYY-MM-DD HH:MM");
            }
        }
        return transactionTime;
    }
}
