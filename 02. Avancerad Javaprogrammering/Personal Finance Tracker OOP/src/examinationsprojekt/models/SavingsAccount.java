package examinationsprojekt.models;

public class SavingsAccount extends Account {
    private final double monthlyInterestRate;

    public SavingsAccount(String name, String owner, AccountTypes type, double interestRate) {
        super(name, owner, type);
        this.monthlyInterestRate = interestRate;
    }

    public double getMonthlyInterestRate() {
        return monthlyInterestRate;
    }
}

