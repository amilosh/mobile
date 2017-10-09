package by.it.milosh.service.serviceImpl;

import by.it.milosh.model.PhoneNumber;
import by.it.milosh.model.Role;
import by.it.milosh.model.RoleEnum;
import by.it.milosh.model.User;
import by.it.milosh.repository.PhoneNumberRepository;
import by.it.milosh.repository.RoleRepository;
import by.it.milosh.repository.UserRepository;
import by.it.milosh.service.service.InitializeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class InitializeServiceImpl implements InitializeService{

    private final static int NUMBERS_OF_INITIALIZED_PHONENUMBER = 20;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initializeRoles() {
        if (roleRepository.findAll().isEmpty()) {
            roleRepository.save(new Role(RoleEnum.ADMIN.getType()));
            roleRepository.save(new Role(RoleEnum.USER.getType()));
            roleRepository.save(new Role(RoleEnum.ABONENT.getType()));
        }
    }

    @Override
    public void initializePhoneNumbers() {
        if (phoneNumberRepository.findAll().isEmpty()) {
            for (int i = 0; i < NUMBERS_OF_INITIALIZED_PHONENUMBER; i++) {
                Integer number = (int) (Math.random()*10000000);
                PhoneNumber phoneNumber = new PhoneNumber(number, false);
                phoneNumberRepository.save(phoneNumber);
            }
        }
    }

    @Override
    public User initializeAdmin(User user) {
        Role role = roleRepository.getRoleByRoleName(RoleEnum.ADMIN.getType());
        user.getRoles().add(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setBalance(0);
        userRepository.save(user);
        return null;
    }
}
