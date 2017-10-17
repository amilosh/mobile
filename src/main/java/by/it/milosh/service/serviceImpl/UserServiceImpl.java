package by.it.milosh.service.serviceImpl;

import by.it.milosh.model.*;
import by.it.milosh.repository.*;
import by.it.milosh.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TariffRepository tariffRepository;

    @Autowired
    private AddonRepository addonRepository;

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
    public void addTariffToUser(User user, Tariff tariff) {
        user.setTariff(tariff);
        userRepository.save(user);
    }

    @Override
    public void addNumberToUser(User user, PhoneNumber phoneNumber) {
        phoneNumber.setUser(user);
        phoneNumber.setUsed(true);
        phoneNumberRepository.save(phoneNumber);
        user.setPhoneNumber(phoneNumber);
    }

    @Override
    public Long numberOfUsers() {
        return userRepository.numberOfUsers();
    }

    @Override
    public void addAddonToUser(Long userId, Long addonId) {
        User user = userRepository.findOne(userId);
        Addon addon = addonRepository.findOne(addonId);
        user.getAddons().add(addon);
        userRepository.save(user);
    }

    @Override
    public List<Addon> getAddonsOfUser(Long userId) {
        User user = userRepository.findOne(userId);
        List<Addon> addons = user.getAddons();
        return addons;
    }

    @Override
    public List<Addon> getAddonsNonUser(Long userId) {
        User user = userRepository.findOne(userId);
        List<Addon> addonsOfUser = user.getAddons();
        List<Addon> addonsNonUser = addonRepository.findAll();
        addonsNonUser.removeAll(addonsOfUser);
        return addonsNonUser;
    }

    @Override
    public void registrationUser(User user) {
        Role role = roleRepository.getRoleByRoleName(RoleEnum.USER.getType());
        user.getRoles().add(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setBalance(0);
        userRepository.save(user);
    }

    @Override
    public boolean isAdmin(User user) {
        List<Role> roles = user.getRoles();
        boolean isAdmin = false;
        for (Role role : roles) {
            if (role.getRoleName().equals(RoleEnum.ADMIN.getType())) {
                isAdmin = true;
            }
        }
        return isAdmin;
    }

    @Override
    public User connect(User user, Tariff tariffFromForm) {
        Tariff tariff = (Tariff) tariffRepository.findOne(tariffFromForm.getTariffId());
        addTariffToUser(user, tariff);
        setBalance(user, tariff.getCostPerMonth()*(-1));
        PhoneNumber phoneNumber = phoneNumberRepository.findFirstByUsedFalse();
        addNumberToUser(user, phoneNumber);
        userRepository.save(user);
        return user;
    }

    @Override
    public User setBalance(User user, Integer changeBalance) {
        Integer newUserBalance = user.getBalance() + changeBalance;
        user.setBalance(newUserBalance);
        return user;
    }
}
