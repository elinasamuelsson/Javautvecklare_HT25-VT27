package examinationsprojekt.commands;

import examinationsprojekt.managers.CurrentStateManager;

public class AddTransactionCommand implements ICommand {
    public void run() {
        if (CurrentStateManager.getCurrentAccount() == null) {
            System.out.println("Select an account before adding transactions.");
            return;
        }

        System.out.println("add transaction command");
    }
}
