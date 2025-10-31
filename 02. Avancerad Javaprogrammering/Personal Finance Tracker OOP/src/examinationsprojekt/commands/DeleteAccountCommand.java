package examinationsprojekt.commands;

import examinationsprojekt.models.Account;
import examinationsprojekt.repository.FileRepository;
import examinationsprojekt.repository.IRepository;
import examinationsprojekt.repository.ListRepository;
import examinationsprojekt.utils.IReadUserInput;
import examinationsprojekt.utils.ReadUserTerminalInput;

import java.util.List;

public class DeleteAccountCommand implements ICommand {
    private final IReadUserInput input = new ReadUserTerminalInput();

    public void run() {
        IRepository repository = new FileRepository();

        System.out.println("Which of the following accounts do you want to delete?");
        System.out.println();

        List<Account> accounts = repository.read();
        for (Account account : accounts) {
            System.out.print((accounts.indexOf(account) + 1) + ":");
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
