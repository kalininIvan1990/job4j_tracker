package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает механизм банковского сервиса, который включает:
 * добавление пользователя, удаление пользователя, добавление счетов,
 * переводы между счетами.
 */
public class BankService {
    /**
     * Хранение пользователей и их счетов осуществляется в коллекции Map.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя.
     * @param user, который будет добавлен.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод удаляет пользователя по паспортным данным.
     * @param passport паспорт пользователя, который будет удален.
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод добавляет счет к пользователю.
     * @param passport паспорт пользователя, которому добавляется счет.
     * @param account новый счет, который будет добавлен.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод осуществляет поиск пользователя по паспортным данным.
     * @param passport паспортные данные пользователя.
     * @return пользователя User или null, если пользователь не найден.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод осуществляет поиск счета пользователя по реквизитам.
     * @param passport паспортные данные пользователя.
     * @param requisite реквизиты счета, по которым ведется поиск.
     * @return счет пользователя.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод осуществляет перевод денежных средств между счетами.
     * @param sourcePassport паспортные данные отправителя.
     * @param sourceRequisite реквизиты счета отправителя.
     * @param destinationPassport паспортные данные получателя.
     * @param destinationRequisite реквизиты счета получателя.
     * @param amount сумма перевода.
     * @return true, если перевод произведен успешно, если нет - false.
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (destinationAccount != null && sourceAccount != null && amount <= sourceAccount.getBalance()) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Метод возвращает список счетов пользователя.
     * @param user пользователь.
     * @return список счетов пользователя.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
