package by.it.milosh.service.service;

import by.it.milosh.model.CheckInitAdmin;
import by.it.milosh.model.PhoneNumber;

import java.util.List;

public interface PhoneNumberService extends BaseService<PhoneNumber> {

    List<PhoneNumber> findAllUnusedNumbers();

    PhoneNumber findFirstByUsedFalse();

}
