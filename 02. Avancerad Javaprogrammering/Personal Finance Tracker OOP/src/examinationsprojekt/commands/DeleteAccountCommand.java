package examinationsprojekt.commands;

import examinationsprojekt.managers.CurrentStateManager;
import examinationsprojekt.models.Account;
import examinationsprojekt.repository.IRepository;
import examinationsprojekt.repository.ListRepository;
import examinationsprojekt.utils.IReadUserInput;
import examinationsprojekt.utils.ReadUserTerminalInput;

public class DeleteAccountCommand implements ICommand {
    private final IReadUserInput input = new ReadUserTerminalInput();

    public void run() {
        IRepository repository = new ListRepository();

        System.out.println("Which of the following accounts do you want to delete?");
        System.out.println();

        for (Account account : repository.read()) {
            System.out.print((repository.read().indexOf(account) + 1) + ":");
            System.out.println("\t" + account.getName() + ", " + account.getType().getTypeDescription());
            System.out.println("\t" + account.getOwner());
            System.out.println();
        }

        int userInput = input.intInput();

        for (Account account : repository.read()) {
            if (userInput == (repository.read().indexOf(account) + 1)) {
                repository.delete(account);
                System.out.println(account.getName() + " deleted.");
            }
        }
    }
}
