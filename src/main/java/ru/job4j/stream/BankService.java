package ru.job4j.stream;

import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users;

    public BankService(Map<User, List<Account>> users) {
        this.users = users;
    }

    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> passport.equals(user.passport()))
                .findFirst()
                .orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        return users.get(user)
                .stream()
                .filter(account -> requisite.equals(account.requisite()))
                .findFirst()
                .orElse(null);
    }

}
