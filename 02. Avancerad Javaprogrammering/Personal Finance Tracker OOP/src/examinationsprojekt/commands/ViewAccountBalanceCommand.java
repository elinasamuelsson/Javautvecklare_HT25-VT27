package examinationsprojekt.commands;

import examinationsprojekt.managers.CurrentStateManager;
import examinationsprojekt.models.Account;
import examinationsprojekt.repository.ListRepository;

public class ViewAccountBalanceCommand implements ICommand {
    public void run() {
        ListRepository repository = new ListRepository();
        Account accountToPrintBalanceFrom = null;

        if (CurrentStateManager.getCurrentAccount() == null) {
            System.out.println("Select an account before viewing account balance.");
            return;
        } else {
            for (Account account : repository.read()) {
                if (account.getName().equals(CurrentStateManager.getCurrentAccount().getName())) {
                    accountToPrintBalanceFrom = account;
                }
            }
        }

        System.out.println("Your current account balance is " + accountToPrintBalanceFrom.getBalance());
    }
}
