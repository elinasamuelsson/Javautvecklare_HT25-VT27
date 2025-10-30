package examinationsprojekt.commands;

import examinationsprojekt.managers.CurrentStateManager;
import examinationsprojekt.models.Account;
import examinationsprojekt.models.Transaction;
import examinationsprojekt.repository.ListRepository;
import examinationsprojekt.utils.IReadUserInput;
import examinationsprojekt.utils.ReadUserTerminalInput;

import java.util.ArrayList;
import java.util.List;

public class SearchTransactionCommand implements ICommand {
    IReadUserInput input = new ReadUserTerminalInput();

    public void run() {
        ListRepository repository = new ListRepository();
        Account accountToSearchFrom = null;

        if (CurrentStateManager.getCurrentAccount() == null) {
            System.out.println("Select an account before searching transactions.");
            return;
        } else {
            for (Account account : repository.read()) {
                if (account.getName().equals(CurrentStateManager.getCurrentAccount().getName())) {
                    accountToSearchFrom = account;
                }
            }
        }

        List<Transaction> searchResults = new ArrayList<>();
        String userInput = "";
        while (true) {
            System.out.println("Enter the phrase you wish to search for.");
            userInput = input.stringInput().toLowerCase();

            for (Transaction transaction : accountToSearchFrom.getTransactionsCopy()) {
                if (transaction.getId().toLowerCase().contains(userInput) ||
                transaction.getDescription().toLowerCase().contains(userInput) ||
                transaction.getType().toString().toLowerCase().contains(userInput) ||
                transaction.getTime().toString().toLowerCase().contains(userInput)) {
                    searchResults.add(transaction);
                }
            }
            printSearchResults(searchResults);
            searchResults.clear();
            return;
        }
    }

    private void printSearchResults(List<Transaction> searchResults) {
        if (searchResults.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction transaction : searchResults) {
                System.out.println("-------------------------------------------");
                System.out.print("Time: \t \t \t" + transaction.getTime().getDayOfMonth() + "-" +
                        transaction.getTime().getMonthValue() + "-" + transaction.getTime().getYear() + ", ");
                System.out.println(transaction.getTime().getHour() + ":" + transaction.getTime().getMinute());
                System.out.println("Amount: \t \t \t" + transaction.getAmount());
                System.out.println("Type: \t \t \t" + transaction.getType().getTypeDescription());
                System.out.println("Description: \t \t" + transaction.getDescription());
                System.out.println("ID: \t \t \t" + transaction.getId());
                System.out.println("-------------------------------------------");
            }
        }
    }
}
