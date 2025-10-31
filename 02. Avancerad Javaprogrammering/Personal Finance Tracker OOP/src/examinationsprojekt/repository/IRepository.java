package examinationsprojekt.repository;

import examinationsprojekt.models.Account;

import java.util.List;

public interface IRepository {
    default boolean create(Account createdAccount) {
        return false;
    }

    default List<Account> read() { //possibly change to only return one account instead of list
        return null;
    }

    default boolean update(Account updatedAccount) {
        return false;
    }

    default boolean delete(Account deletedAccount) {
        return false;
    }
}
