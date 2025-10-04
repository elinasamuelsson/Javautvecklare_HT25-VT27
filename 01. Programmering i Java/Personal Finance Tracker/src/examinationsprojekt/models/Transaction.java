package examinationsprojekt.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import static examinationsprojekt.Main.accountBalance;
import static examinationsprojekt.Main.transactions;

public class Transaction implements Serializable {
    private final UUID id;
    private final double amount;
    private final LocalDateTime time;
    private final transactionTypes type;
    private final String description;
    private final boolean isEarning;


    public Transaction(double amount, LocalDateTime time, transactionTypes type,
                       String description, boolean transactionIsEarning) {
        this.id = UUID.randomUUID();
        this.amount = amount;
        this.time = time;
        this.type = type;
        this.description = description;
        this.isEarning = transactionIsEarning;
    }

    public UUID getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public transactionTypes getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public boolean getIsEarning() {
        return isEarning;
    }

    public static void testTransactions() {
        transactions.add(new Transaction(25000.00, LocalDateTime.of(2025, 1, 25, 10, 0), transactionTypes.SALARY, "Monthly salary", true));
        transactions.add(new Transaction(-9500.00, LocalDateTime.of(2025, 1, 1, 9, 0), transactionTypes.HOUSING, "Apartment rent", false));
        transactions.add(new Transaction(-1200.75, LocalDateTime.of(2025, 1, 5, 18, 0), transactionTypes.FOOD, "Groceries at ICA Maxi", false));
        transactions.add(new Transaction(-300.00, LocalDateTime.of(2025, 1, 7, 8, 0), transactionTypes.TRANSPORT, "SL monthly card", false));
        transactions.add(new Transaction(-200.00, LocalDateTime.of(2025, 1, 10, 14, 0), transactionTypes.HEALTH, "Pharmacy purchase", false));
        transactions.add(new Transaction(500.00, LocalDateTime.of(2025, 1, 12, 16, 0), transactionTypes.GIFT, "Birthday gift from family", true));
        transactions.add(new Transaction(-1500.00, LocalDateTime.of(2025, 1, 15, 9, 0), transactionTypes.EDUCATION, "Course fee", false));
        transactions.add(new Transaction(-2200.00, LocalDateTime.of(2025, 1, 18, 13, 0), transactionTypes.SHOPPING, "New laptop backpack", false));
        transactions.add(new Transaction(-350.00, LocalDateTime.of(2025, 1, 23, 12, 0), transactionTypes.OTHER_SPENDING, "Streaming subscriptions", false));
        transactions.add(new Transaction(2000.00, LocalDateTime.of(2025, 1, 27, 19, 0), transactionTypes.OTHER_EARNING, "Sold old bike on Blocket", true));
        transactions.add(new Transaction(25000.00, LocalDateTime.of(2025, 2, 25, 10, 0), transactionTypes.SALARY, "Monthly salary", true));
        transactions.add(new Transaction(-9500.00, LocalDateTime.of(2025, 2, 1, 9, 0), transactionTypes.HOUSING, "Rent", false));
        transactions.add(new Transaction(-850.00, LocalDateTime.of(2025, 2, 4, 18, 0), transactionTypes.FOOD, "Groceries at Hemköp", false));
        transactions.add(new Transaction(-380.00, LocalDateTime.of(2025, 2, 7, 13, 0), transactionTypes.OTHER_SPENDING, "Spotify & Netflix", false));
        transactions.add(new Transaction(-1100.00, LocalDateTime.of(2025, 2, 10, 9, 0), transactionTypes.HEALTH, "Dentist appointment", false));
        transactions.add(new Transaction(-900.00, LocalDateTime.of(2025, 2, 12, 11, 0), transactionTypes.TRANSPORT, "Flight to Berlin", false));
        transactions.add(new Transaction(-4500.00, LocalDateTime.of(2025, 2, 15, 14, 0), transactionTypes.SHOPPING, "Gaming laptop", false));
        transactions.add(new Transaction(3000.00, LocalDateTime.of(2025, 2, 18, 16, 0), transactionTypes.OTHER_EARNING, "Sold used furniture", true));
        transactions.add(new Transaction(1000.00, LocalDateTime.of(2025, 2, 20, 16, 0), transactionTypes.OTHER_EARNING, "Sold camera", true));
        transactions.add(new Transaction(-1200.00, LocalDateTime.of(2025, 2, 21, 10, 0), transactionTypes.EDUCATION, "Online course fee", false));
        transactions.add(new Transaction(25000.00, LocalDateTime.of(2025, 3, 25, 10, 0), transactionTypes.SALARY, "Monthly salary", true));
        transactions.add(new Transaction(-9500.00, LocalDateTime.of(2025, 3, 1, 9, 0), transactionTypes.HOUSING, "Rent", false));
        transactions.add(new Transaction(-1250.00, LocalDateTime.of(2025, 3, 6, 18, 0), transactionTypes.FOOD, "Groceries", false));
        transactions.add(new Transaction(-420.00, LocalDateTime.of(2025, 3, 12, 17, 0), transactionTypes.OTHER_SPENDING, "Gym membership", false));
        transactions.add(new Transaction(-650.00, LocalDateTime.of(2025, 3, 20, 19, 0), transactionTypes.TRANSPORT, "Weekend bus trip", false));
        transactions.add(new Transaction(1200.00, LocalDateTime.of(2025, 3, 22, 14, 0), transactionTypes.OTHER_EARNING, "Freelance design work", true));
        transactions.add(new Transaction(25000.00, LocalDateTime.of(2025, 4, 25, 10, 0), transactionTypes.SALARY, "Monthly salary", true));
        transactions.add(new Transaction(-9500.00, LocalDateTime.of(2025, 4, 1, 9, 0), transactionTypes.HOUSING, "Rent", false));
        transactions.add(new Transaction(-1350.00, LocalDateTime.of(2025, 4, 3, 18, 0), transactionTypes.FOOD, "Groceries", false));
        transactions.add(new Transaction(-300.00, LocalDateTime.of(2025, 4, 10, 10, 0), transactionTypes.HEALTH, "Doctor appointment", false));
        transactions.add(new Transaction(-2200.00, LocalDateTime.of(2025, 4, 15, 13, 0), transactionTypes.SHOPPING, "Spring clothes", false));
        transactions.add(new Transaction(600.00, LocalDateTime.of(2025, 4, 20, 15, 0), transactionTypes.GIFT, "Easter gift from family", true));
        transactions.add(new Transaction(25000.00, LocalDateTime.of(2025, 5, 25, 10, 0), transactionTypes.SALARY, "Monthly salary", true));
        transactions.add(new Transaction(-9500.00, LocalDateTime.of(2025, 5, 1, 9, 0), transactionTypes.HOUSING, "Rent", false));
        transactions.add(new Transaction(-1450.00, LocalDateTime.of(2025, 5, 8, 18, 0), transactionTypes.FOOD, "Groceries at ICA", false));
        transactions.add(new Transaction(-350.00, LocalDateTime.of(2025, 5, 12, 20, 0), transactionTypes.OTHER_SPENDING, "Concert tickets", false));
        transactions.add(new Transaction(-890.00, LocalDateTime.of(2025, 5, 20, 17, 0), transactionTypes.TRANSPORT, "Train tickets to Malmö", false));
        transactions.add(new Transaction(2000.00, LocalDateTime.of(2025, 5, 22, 10, 0), transactionTypes.OTHER_EARNING, "Sold old sofa", true));
        transactions.add(new Transaction(25000.00, LocalDateTime.of(2025, 6, 25, 10, 0), transactionTypes.SALARY, "Monthly salary", true));
        transactions.add(new Transaction(-9500.00, LocalDateTime.of(2025, 6, 1, 9, 0), transactionTypes.HOUSING, "Rent", false));
        transactions.add(new Transaction(-1600.00, LocalDateTime.of(2025, 6, 6, 18, 0), transactionTypes.FOOD, "Groceries at Coop", false));
        transactions.add(new Transaction(-250.00, LocalDateTime.of(2025, 6, 10, 12, 0), transactionTypes.OTHER_SPENDING, "Summer BBQ supplies", false));
        transactions.add(new Transaction(-3500.00, LocalDateTime.of(2025, 6, 15, 15, 0), transactionTypes.SHOPPING, "New smartphone", false));
        transactions.add(new Transaction(1200.00, LocalDateTime.of(2025, 6, 20, 11, 0), transactionTypes.OTHER_EARNING, "Freelance project", true));
        transactions.add(new Transaction(25000.00, LocalDateTime.of(2025, 7, 25, 10, 0), transactionTypes.SALARY, "Monthly salary", true));
        transactions.add(new Transaction(-9500.00, LocalDateTime.of(2025, 7, 1, 9, 0), transactionTypes.HOUSING, "Rent", false));
        transactions.add(new Transaction(-1400.00, LocalDateTime.of(2025, 7, 7, 18, 0), transactionTypes.FOOD, "Groceries", false));
        transactions.add(new Transaction(-500.00, LocalDateTime.of(2025, 7, 12, 20, 0), transactionTypes.TRANSPORT, "Ferry tickets to Gotland", false));
        transactions.add(new Transaction(-250.00, LocalDateTime.of(2025, 7, 18, 19, 0), transactionTypes.OTHER_SPENDING, "Outdoor cinema", false));
        transactions.add(new Transaction(1500.00, LocalDateTime.of(2025, 7, 22, 12, 0), transactionTypes.GIFT, "Birthday money", true));
        transactions.add(new Transaction(25000.00, LocalDateTime.of(2025, 8, 25, 10, 0), transactionTypes.SALARY, "Monthly salary", true));
        transactions.add(new Transaction(-9500.00, LocalDateTime.of(2025, 8, 1, 9, 0), transactionTypes.HOUSING, "Rent", false));
        transactions.add(new Transaction(-1300.00, LocalDateTime.of(2025, 8, 4, 18, 0), transactionTypes.FOOD, "Groceries", false));
        transactions.add(new Transaction(-2800.00, LocalDateTime.of(2025, 8, 9, 14, 0), transactionTypes.SHOPPING, "New office desk", false));
        transactions.add(new Transaction(-400.00, LocalDateTime.of(2025, 8, 15, 16, 0), transactionTypes.OTHER_SPENDING, "Streaming subscriptions", false));
        transactions.add(new Transaction(2200.00, LocalDateTime.of(2025, 8, 20, 13, 0), transactionTypes.OTHER_EARNING, "Sold bicycle collection", true));
        transactions.add(new Transaction(25000.00, LocalDateTime.of(2025, 9, 25, 10, 0), transactionTypes.SALARY, "Monthly salary", true));
        transactions.add(new Transaction(-9500.00, LocalDateTime.of(2025, 9, 1, 9, 0), transactionTypes.HOUSING, "Rent", false));
        transactions.add(new Transaction(-1500.00, LocalDateTime.of(2025, 9, 6, 18, 0), transactionTypes.FOOD, "Groceries", false));
        transactions.add(new Transaction(-600.00, LocalDateTime.of(2025, 9, 10, 15, 0), transactionTypes.TRANSPORT, "Flight to Copenhagen", false));
        transactions.add(new Transaction(-220.00, LocalDateTime.of(2025, 9, 15, 20, 0), transactionTypes.OTHER_SPENDING, "Dinner out", false));
        transactions.add(new Transaction(1000.00, LocalDateTime.of(2025, 9, 20, 11, 0), transactionTypes.OTHER_EARNING, "Sold old books", true));
        transactions.add(new Transaction(24000.00, LocalDateTime.of(2024, 12, 25, 10, 0), transactionTypes.SALARY, "Christmas salary", true));
        transactions.add(new Transaction(-9500.00, LocalDateTime.of(2024, 12, 1, 9, 0), transactionTypes.HOUSING, "December rent", false));
        transactions.add(new Transaction(-1200.00, LocalDateTime.of(2024, 11, 15, 18, 0), transactionTypes.FOOD, "Weekly groceries", false));
        transactions.add(new Transaction(-4000.00, LocalDateTime.of(2024, 10, 5, 15, 0), transactionTypes.SHOPPING, "New smartphone", false));
        transactions.add(new Transaction(-750.00, LocalDateTime.of(2024, 9, 22, 14, 0), transactionTypes.TRANSPORT, "Train tickets to Gothenburg", false));
        transactions.add(new Transaction(1000.00, LocalDateTime.of(2024, 8, 30, 12, 0), transactionTypes.OTHER_EARNING, "Freelance gig", true));
        transactions.add(new Transaction(-1800.00, LocalDateTime.of(2024, 7, 10, 10, 0), transactionTypes.EDUCATION, "Summer course fee", false));
        transactions.add(new Transaction(25000.00, LocalDateTime.of(2024, 6, 25, 10, 0), transactionTypes.SALARY, "Monthly salary", true));
        transactions.add(new Transaction(-9500.00, LocalDateTime.of(2024, 5, 1, 9, 0), transactionTypes.HOUSING, "Apartment rent", false));
        transactions.add(new Transaction(-300.00, LocalDateTime.of(2024, 4, 10, 9, 0), transactionTypes.HEALTH, "Doctor appointment", false));
        transactions.add(new Transaction(24000.00, LocalDateTime.of(2024, 3, 25, 10, 0), transactionTypes.SALARY, "Monthly salary", true));
        transactions.add(new Transaction(-9500.00, LocalDateTime.of(2024, 3, 1, 9, 0), transactionTypes.HOUSING, "March rent", false));
        transactions.add(new Transaction(-1300.00, LocalDateTime.of(2024, 3, 5, 18, 0), transactionTypes.FOOD, "Groceries", false));
        transactions.add(new Transaction(-400.00, LocalDateTime.of(2024, 3, 12, 14, 0), transactionTypes.OTHER_SPENDING, "Gym membership", false));
        transactions.add(new Transaction(-2200.00, LocalDateTime.of(2024, 2, 18, 16, 0), transactionTypes.SHOPPING, "Winter clothes", false));
        transactions.add(new Transaction(800.00, LocalDateTime.of(2024, 2, 20, 11, 0), transactionTypes.OTHER_EARNING, "Sold old phone", true));
        transactions.add(new Transaction(24000.00, LocalDateTime.of(2024, 1, 25, 10, 0), transactionTypes.SALARY, "Monthly salary", true));
        transactions.add(new Transaction(-9500.00, LocalDateTime.of(2024, 1, 1, 9, 0), transactionTypes.HOUSING, "January rent", false));
        transactions.add(new Transaction(-900.00, LocalDateTime.of(2024, 1, 7, 12, 0), transactionTypes.TRANSPORT, "Flight to London", false));
        transactions.add(new Transaction(-450.00, LocalDateTime.of(2024, 1, 15, 18, 0), transactionTypes.FOOD, "Restaurants", false));
        transactions.add(new Transaction(-2200.00, LocalDateTime.of(2023, 12, 24, 18, 0), transactionTypes.GIFT, "Christmas gifts", false));
        transactions.add(new Transaction(5000.00, LocalDateTime.of(2023, 11, 5, 11, 0), transactionTypes.OTHER_EARNING, "Side hustle project", true));
        transactions.add(new Transaction(-9500.00, LocalDateTime.of(2023, 10, 1, 9, 0), transactionTypes.HOUSING, "Rent", false));
        transactions.add(new Transaction(-1250.00, LocalDateTime.of(2023, 9, 15, 17, 0), transactionTypes.FOOD, "Groceries at Coop", false));
        transactions.add(new Transaction(-4200.00, LocalDateTime.of(2023, 8, 20, 14, 0), transactionTypes.SHOPPING, "New TV", false));
        transactions.add(new Transaction(20000.00, LocalDateTime.of(2023, 7, 25, 10, 0), transactionTypes.SALARY, "Summer salary", true));
        transactions.add(new Transaction(-350.00, LocalDateTime.of(2023, 6, 3, 13, 0), transactionTypes.OTHER_SPENDING, "Concert tickets", false));
        transactions.add(new Transaction(-600.00, LocalDateTime.of(2023, 4, 15, 9, 0), transactionTypes.TRANSPORT, "Weekend trip", false));
        transactions.add(new Transaction(1500.00, LocalDateTime.of(2023, 2, 10, 16, 0), transactionTypes.GIFT, "Birthday money", true));
        transactions.add(new Transaction(20000.00, LocalDateTime.of(2023, 5, 25, 10, 0), transactionTypes.SALARY, "Monthly salary", true));
        transactions.add(new Transaction(-9500.00, LocalDateTime.of(2023, 5, 1, 9, 0), transactionTypes.HOUSING, "Rent", false));
        transactions.add(new Transaction(-1500.00, LocalDateTime.of(2023, 5, 12, 18, 0), transactionTypes.FOOD, "Groceries at Lidl", false));
        transactions.add(new Transaction(-350.00, LocalDateTime.of(2023, 5, 20, 20, 0), transactionTypes.OTHER_SPENDING, "Cinema & snacks", false));
        transactions.add(new Transaction(20000.00, LocalDateTime.of(2023, 3, 25, 10, 0), transactionTypes.SALARY, "Monthly salary", true));
        transactions.add(new Transaction(-9500.00, LocalDateTime.of(2023, 3, 1, 9, 0), transactionTypes.HOUSING, "Rent", false));
        transactions.add(new Transaction(-800.00, LocalDateTime.of(2023, 3, 11, 19, 0), transactionTypes.TRANSPORT, "Weekend trip tickets", false));
        transactions.add(new Transaction(-600.00, LocalDateTime.of(2023, 3, 15, 17, 0), transactionTypes.HEALTH, "Eye checkup", false));
        transactions.add(new Transaction(-1200.00, LocalDateTime.of(2023, 1, 5, 12, 0), transactionTypes.FOOD, "Groceries", false));
        transactions.add(new Transaction(1500.00, LocalDateTime.of(2023, 1, 10, 16, 0), transactionTypes.GIFT, "New Year gift from relatives", true));
        transactions.add(new Transaction(20000.00, LocalDateTime.of(2023, 1, 25, 10, 0), transactionTypes.SALARY, "Monthly salary", true));
        transactions.add(new Transaction(-9500.00, LocalDateTime.of(2023, 1, 1, 9, 0), transactionTypes.HOUSING, "Rent", false));

        for (Transaction transaction : transactions) {
            accountBalance += transaction.amount;
        }
    }
}