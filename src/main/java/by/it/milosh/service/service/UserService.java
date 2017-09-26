package by.it.milosh.service.service;

import by.it.milosh.model.PhoneNumber;
import by.it.milosh.model.Service;
import by.it.milosh.model.User;

import java.util.List;

public interface UserService extends BaseService<User> {

    User findUserByUsername(String username);

    void addTariffToUser(User user, Long tariff_id);

    void addNumberToUser(User user, PhoneNumber phoneNumber);

    Long numberOfUsers();

    void addServiceToUser(Long user_id, Long service_id);

    List<Service> getServicesOfUser(Long user_id);

    List<Service> getServiceNonUser(Long user_id);

}
