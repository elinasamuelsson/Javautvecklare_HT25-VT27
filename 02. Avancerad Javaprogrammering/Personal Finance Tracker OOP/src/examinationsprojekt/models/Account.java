package examinationsprojekt.models;

import java.util.ArrayList;

public class Account {
    private final String name;
    private final String owner;
    private final AccountTypes type;
    private double balance;
    private final ArrayList<Transaction> transactions;

    Account(String name, String owner, AccountTypes type, double balance) {
        this.name = name;
        this.owner = owner;
        this.type = type;
        this.balance = balance;
        this.transactions = new ArrayList<Transaction>();
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public AccountTypes getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactionsCopy() {
        return new ArrayList<Transaction>(transactions);
    }
}
