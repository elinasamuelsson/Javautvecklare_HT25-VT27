package examinationsprojekt.commands;

import examinationsprojekt.managers.CurrentStateManager;
import examinationsprojekt.models.Account;
import examinationsprojekt.models.Transaction;
import examinationsprojekt.repository.FileRepository;
import examinationsprojekt.repository.IRepository;
import examinationsprojekt.repository.ListRepository;
import examinationsprojekt.utils.IReadUserInput;
import examinationsprojekt.utils.ReadUserTerminalInput;

public class DeleteTransactionCommand implements ICommand {
    IReadUserInput input = new ReadUserTerminalInput();

    public void run() {
        IRepository repository = new FileRepository();
        Account accountToDeleteFrom = null;

        if (CurrentStateManager.getCurrentAccount() == null) {
            System.out.println("Select an account before deleting transactions.");
            return;
        } else {
            for (Account account : repository.read()) {
                if (account.getName().equals(CurrentStateManager.getCurrentAccount().getName())) {
                    accountToDeleteFrom = account;
                }
            }
        }


        String userInput = "";
        while (true) {
            System.out.println("Enter the ID of the transaction you wish to delete.");
            userInput = input.stringInput();

            for (Transaction transaction : accountToDeleteFrom.getTransactionsCopy()) {
                if (transaction.getId().equals(userInput)) {
                    accountToDeleteFrom.removeTransactionFromList(transaction);
                } else {
                    System.out.println("Transaction not found.");
                    System.out.println("Restart transaction deletion and try again.");
                    return;
                }
            }

            repository.update(accountToDeleteFrom);
            System.out.println("Transaction has been deleted.");
            break;
        }
    }
}
