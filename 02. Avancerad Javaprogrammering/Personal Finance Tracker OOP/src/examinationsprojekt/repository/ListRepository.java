package examinationsprojekt.repository;

import examinationsprojekt.models.Account;

import java.util.ArrayList;
import java.util.List;

public class ListRepository implements IRepository {
    private final List<Account> accounts;

    public ListRepository() {
        this.accounts = new ArrayList<>();
    }

    public boolean create(Account createdAccount) {
        return accounts.add(createdAccount);
    }

    public List<Account> read() {
        return new ArrayList<>(accounts);
    }

    public boolean update(Account updatedAccount) {
        for (Account account : accounts) {
            if (account.getName().equals(updatedAccount.getName())) {
                accounts.set(accounts.indexOf(account), updatedAccount);
                return true;
            }
        }
        return false;
    }

    public boolean delete(Account deletedAccount) {
        return accounts.remove(deletedAccount);
    }
}
