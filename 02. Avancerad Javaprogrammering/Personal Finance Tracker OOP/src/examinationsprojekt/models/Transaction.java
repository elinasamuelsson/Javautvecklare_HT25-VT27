package examinationsprojekt.models;

import java.time.LocalDateTime;

public class Transaction {
    private final String id;
    private final double amount;
    private final LocalDateTime time;
    private final TransactionTypes type;
    private final String description;

    public Transaction(double amount, LocalDateTime time, TransactionTypes type, String description) {
        this.id = idGenerator();
        this.amount = amount;
        this.time = time;
        this.type = type;
        this.description = description;
    }

    public String getId() { return id; }
    public double getAmount() { return amount; }
    public LocalDateTime getTime() { return time; }
    public TransactionTypes getType() { return type; }
    public String getDescription() { return description; }

    public String idGenerator() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder id = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            id.append(chars.charAt((int) (Math.random() * chars.length())));
        }

        return id.toString();
    }
}
