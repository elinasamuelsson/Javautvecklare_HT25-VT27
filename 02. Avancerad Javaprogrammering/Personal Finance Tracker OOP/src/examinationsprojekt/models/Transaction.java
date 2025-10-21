package examinationsprojekt.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private final UUID id;
    private final double amount;
    private final LocalDateTime time;
    private final TransactionTypes type;
    private final String description;

    public Transaction(double amount, LocalDateTime time, TransactionTypes type, String description) {
        this.id = UUID.randomUUID();
        this.amount = amount;
        this.time = time;
        this.type = type;
        this.description = description;
    }

    public UUID getId() { return id; }
    public double getAmount() { return amount; }
    public LocalDateTime getTime() { return time; }
    public TransactionTypes getType() { return type; }
    public String getDescription() { return description; }
}
