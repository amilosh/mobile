package by.it.milosh.service.serviceImpl;

import by.it.milosh.model.PhoneNumber;
import by.it.milosh.repository.PhoneNumberRepository;
import by.it.milosh.service.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Override
    public void add(PhoneNumber phoneNumber) {
        phoneNumberRepository.save(phoneNumber);
    }

    @Override
    public PhoneNumber getById(Long id) {
        return phoneNumberRepository.findOne(id);
    }

    @Override
    public List<PhoneNumber> findAll() {
        return phoneNumberRepository.findAll();
    }
}
