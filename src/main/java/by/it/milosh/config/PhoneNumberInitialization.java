package by.it.milosh.config;

import by.it.milosh.model.PhoneNumber;
import by.it.milosh.service.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class PhoneNumberInitialization {

    @Autowired
    private PhoneNumberService phoneNumberService;

    /*
    @PostConstruct
    public void init() {
        if (phoneNumberService.findAll().isEmpty()) {
            for (int i = 0; i < 20; i++) {
                Integer number = (int) (Math.random()*10000000);
                PhoneNumber phoneNumber = new PhoneNumber(number, false);
                phoneNumberService.save(phoneNumber);
            }
        }
    }
    */

}
