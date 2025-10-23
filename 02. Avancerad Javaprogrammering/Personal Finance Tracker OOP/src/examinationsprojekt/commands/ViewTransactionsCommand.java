package examinationsprojekt.commands;

import examinationsprojekt.managers.CurrentStateManager;
import examinationsprojekt.models.ViewOptions;

public class ViewTransactionsCommand implements ICommand {
    private final ViewOptions option;

    public ViewTransactionsCommand(ViewOptions option) {
        this.option = option;
    }
    public void run() {
        if (CurrentStateManager.getCurrentAccount() == null) {
            System.out.println("Select an account before viewing transactions.");
            return;
        }

        System.out.println("view transactions command");
    }
}
