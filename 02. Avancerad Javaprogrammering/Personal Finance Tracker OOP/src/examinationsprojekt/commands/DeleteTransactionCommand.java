package examinationsprojekt.commands;

import examinationsprojekt.managers.CurrentStateManager;

public class DeleteTransactionCommand implements ICommand {
    public void run() {
        if (CurrentStateManager.getCurrentAccount() == null) {
            System.out.println("Select an account before deleting transactions.");
            return;
        }

        System.out.println("delete transaction command");
    }
}
