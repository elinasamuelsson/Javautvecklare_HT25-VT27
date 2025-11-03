package examinationsprojekt.commands;

import examinationsprojekt.managers.CurrentStateManager;
import examinationsprojekt.models.Account;
import examinationsprojekt.repository.FileRepository;
import examinationsprojekt.repository.IRepository;
import examinationsprojekt.repository.ListRepository;
import examinationsprojekt.utils.IReadUserInput;
import examinationsprojekt.utils.ReadUserTerminalInput;

import java.util.List;

public class SelectAccountCommand implements ICommand {
    private final IReadUserInput input = new ReadUserTerminalInput();

    public void run() {
        IRepository repository = new FileRepository();

        System.out.println("Which of the following accounts do you want to use?");
        System.out.println();

        List<Account> accounts = repository.read();

        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        for (Account account : accounts) {
            System.out.print((accounts.indexOf(account) + 1) + ":");
            System.out.println("\t" + account.getName() + ", " + account.getType().getTypeDescription());
            System.out.println("\t" + account.getOwner());
            System.out.println();
        }

        int userInput = input.intInput();

        for (Account account : accounts) {
            if (userInput == (accounts.indexOf(account) + 1)) {
                CurrentStateManager.setCurrentAccount(account);
                System.out.println();
                System.out.println(account.getName() + " selected.");
            } else {
                System.out.println();
                System.out.println("Invalid option. Try again.");
            }
        }
    }
}
