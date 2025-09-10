package projekt.examination;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Transaction {
    public double amount;
    public LocalDateTime time;
    public String type;
    public String description;
    public boolean isEarning;

    public Transaction(double amount, LocalDateTime time, String type, String description, boolean transactionIsEarning) {
        this.amount = amount;
        this.time = time;
        this.type = type;
        this.description = description;
        this.isEarning = transactionIsEarning;
    }

    public static Transaction addTransaction(boolean isEarning) {
        Scanner scanner = new Scanner(System.in);

        double transactionAmount = 0;
        if (isEarning) {
            System.out.println("Enter amount earned;");
            transactionAmount = scanner.nextDouble();
            scanner.nextLine();
        } else {
            System.out.println("Enter amount spent;");
            transactionAmount = Double.parseDouble(("-" + scanner.nextLine()));
        }

        System.out.println("Enter type of transaction;");
        String transactionType = scanner.nextLine();

        System.out.println("Enter a brief description of the transaction;");
        String transactionDescription = scanner.nextLine();

        System.out.println("Enter time and date of the transaction:");
        System.out.println("Please use the format YYYY-MM-DD HH:MM");
        String transactionTimeInput = scanner.nextLine();

        //idea of how to convert from:
        //https://medium.com/@smita.s.kothari/converting-a-12-hour-time-format-string-to-localdatetime-in-java-f9af73dc8c88
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime transactionTime = LocalDateTime.parse(transactionTimeInput, formatter);

        return new Transaction(transactionAmount, transactionTime, transactionType, transactionDescription, isEarning);
    }

    public static void viewTransactions(boolean isEarning, ArrayList<Transaction> transactions) {
        for (Transaction transaction : transactions)
            if (transaction.isEarning == isEarning) {
                System.out.println(transaction.time);
                System.out.println("\t" + transaction.amount);
                System.out.println("\t" + transaction.type);
                System.out.println("\t" + transaction.description);
            } else {
                System.out.println(transaction.time);
                System.out.println("\t" + transaction.amount);
                System.out.println("\t" + transaction.type);
                System.out.println("\t" + transaction.description);
            }
    }
}
