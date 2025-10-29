package examinationsprojekt.commands;

import examinationsprojekt.managers.CurrentStateManager;

public class SearchTransactionCommand implements ICommand {
    public void run() {
        if (CurrentStateManager.getCurrentAccount() == null) {
            System.out.println("Select an account before searching transactions.");
            return;
        }

        System.out.println("search transaction command");
    }
}
