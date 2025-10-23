package examinationsprojekt.commands;

import examinationsprojekt.managers.CurrentStateManager;

public class ViewTransactionsCommand implements ICommand {
    public void run() {
        if (CurrentStateManager.getCurrentAccount() == null) {
            System.out.println("Select an account before viewing transactions.");
            return;
        }

        System.out.println("view transactions command");
    }
}
