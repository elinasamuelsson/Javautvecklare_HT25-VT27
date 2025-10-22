package examinationsprojekt.models;

public class SavingsAccount extends Account {
    private final double monthlyInterestRate;

    SavingsAccount(String name, String owner, AccountTypes type, double balance, double interestRate) {
        super(name, owner, type, balance);
        this.monthlyInterestRate = interestRate;
    }

    public double getMonthlyInterestRate() {
        return monthlyInterestRate;
    }
}

