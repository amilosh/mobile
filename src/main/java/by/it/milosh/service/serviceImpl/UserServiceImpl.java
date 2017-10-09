package by.it.milosh.service.serviceImpl;

import by.it.milosh.model.PhoneNumber;
import by.it.milosh.model.Tariff;
import by.it.milosh.model.User;
import by.it.milosh.repository.PhoneNumberRepository;
import by.it.milosh.repository.ServiceRepository;
import by.it.milosh.repository.TariffRepository;
import by.it.milosh.repository.UserRepository;
import by.it.milosh.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TariffRepository tariffRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void addTariffToUser(User user, Long tariffId) {
        Tariff tariff = tariffRepository.findOne(tariffId);
        user.setTariff(tariff);
        userRepository.save(user);
    }

    @Override
    public void addNumberToUser(User user, PhoneNumber phoneNumber) {
        //user.setPhoneNumber(phoneNumber);
        //userRepository.save(user);
        phoneNumber.setUser(user);
        phoneNumber.setUsed(true);
        phoneNumberRepository.save(phoneNumber);
    }

    @Override
    public Long numberOfUsers() {
        return userRepository.numberOfUsers();
    }

    @Override
    public void addServiceToUser(Long userId, Long serviceId) {
        User user = userRepository.findOne(userId);
        by.it.milosh.model.Service service = serviceRepository.findOne(serviceId);
        user.getServices().add(service);
        userRepository.save(user);
    }

    @Override
    public List<by.it.milosh.model.Service> getServicesOfUser(Long userId) {
        User user = userRepository.findOne(userId);
        List<by.it.milosh.model.Service> services = user.getServices();
        return services;
    }

    @Override
    public List<by.it.milosh.model.Service> getServiceNonUser(Long userId) {
        User user = userRepository.findOne(userId);
        List<by.it.milosh.model.Service> servicesOfUser = user.getServices();
        List<by.it.milosh.model.Service> servicesNonUser = serviceRepository.findAll();
        servicesNonUser.removeAll(servicesOfUser);
        return servicesNonUser;
    }

}
