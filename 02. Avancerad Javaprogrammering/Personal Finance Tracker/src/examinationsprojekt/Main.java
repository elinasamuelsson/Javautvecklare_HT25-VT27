package examinationsprojekt;

import examinationsprojekt.managers.fileManager;
import examinationsprojekt.managers.menuManager;
import examinationsprojekt.models.Transaction;

import java.util.ArrayList;

public class Main {
    public static double accountBalance = 0.00;
    public static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) {
        fileManager.loadDataFromFile();
        Transaction.testTransactions(); //COMMENT/UNCOMMENT TO ENABLE/DISABLE TEST TRANSACTIONS

        System.out.println("Welcome to your personal finance tracker!");

        menuManager.mainMenu();
    }
}