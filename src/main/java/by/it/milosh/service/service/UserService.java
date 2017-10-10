package by.it.milosh.service.service;

import by.it.milosh.model.PhoneNumber;
import by.it.milosh.model.Addon;
import by.it.milosh.model.User;

import java.util.List;

public interface UserService extends BaseService<User> {

    User findUserByUsername(String username);

    void addTariffToUser(User user, Long tariff_id);

    void addNumberToUser(User user, PhoneNumber phoneNumber);

    Long numberOfUsers();

    void addAddonToUser(Long userId, Long addonId);

    List<Addon> getAddonsOfUser(Long userId);

    List<Addon> getAddonsNonUser(Long userId);

    void registrationUser(User user);

}
