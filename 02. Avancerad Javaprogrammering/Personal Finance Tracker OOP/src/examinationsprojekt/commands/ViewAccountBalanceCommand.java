package examinationsprojekt.commands;

import examinationsprojekt.managers.CurrentStateManager;
import examinationsprojekt.models.Account;
import examinationsprojekt.repositories.AccountFileRepository;
import examinationsprojekt.repositories.IAccountRepository;

import java.util.List;

public class ViewAccountBalanceCommand implements ICommand {
    public void run() {
        IAccountRepository repository = new AccountFileRepository();
        Account accountToPrintBalanceFrom = null;

        if (CurrentStateManager.getCurrentAccount() == null) {
            System.out.println("Select an account before viewing account balance.");
            return;
        } else {
            List<Account> accounts = repository.findAll();
            for (Account account : accounts) {
                if (account.getName().equals(CurrentStateManager.getCurrentAccount().getName())) {
                    accountToPrintBalanceFrom = account;
                }
            }
        }

        if (accountToPrintBalanceFrom == null) {
            System.out.println("Select an account before viewing account balance.");
            return;
        }

        System.out.println("Your current account balance is " + accountToPrintBalanceFrom.getBalance());
    }
}
