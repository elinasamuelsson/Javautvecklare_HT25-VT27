package examinationsprojekt.commands;

import examinationsprojekt.managers.CurrentStateManager;
import examinationsprojekt.models.Account;
import examinationsprojekt.repository.FileRepository;
import examinationsprojekt.repository.IRepository;
import examinationsprojekt.repository.ListRepository;

import java.util.List;

public class ViewAccountBalanceCommand implements ICommand {
    public void run() {
        IRepository repository = new FileRepository();
        Account accountToPrintBalanceFrom = null;

        if (CurrentStateManager.getCurrentAccount() == null) {
            System.out.println("Select an account before viewing account balance.");
            return;
        } else {
            List<Account> accounts = repository.read();
            for (Account account : accounts) {
                if (account.getName().equals(CurrentStateManager.getCurrentAccount().getName())) {
                    accountToPrintBalanceFrom = account;
                }
            }
        }

        System.out.println("Your current account balance is " + accountToPrintBalanceFrom.getBalance());
    }
}
