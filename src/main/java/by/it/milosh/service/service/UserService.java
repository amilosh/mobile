package by.it.milosh.service.service;

import by.it.milosh.model.PhoneNumber;
import by.it.milosh.model.User;

public interface UserService extends BaseService<User> {

    User findUserByUsername(String username);

    void addTariffToUser(User user, Long tariff_id);

    void addNumberToUser(User user, PhoneNumber phoneNumber);

    Long numberOfUsers();

}
