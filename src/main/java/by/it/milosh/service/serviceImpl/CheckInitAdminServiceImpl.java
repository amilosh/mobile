package by.it.milosh.service.serviceImpl;

import by.it.milosh.model.CheckInitAdmin;
import by.it.milosh.model.PhoneNumber;
import by.it.milosh.repository.CheckInitAdminRepository;
import by.it.milosh.service.service.CheckInitAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckInitAdminServiceImpl implements CheckInitAdminService {

    @Autowired
    private CheckInitAdminRepository checkInitAdminRepository;

    @Override
    public void add(CheckInitAdmin checkInitAdmin) {
        checkInitAdminRepository.save(checkInitAdmin);
    }

    @Override
    public CheckInitAdmin getById(Long id) {
        return checkInitAdminRepository.findOne(id);
    }

    @Override
    public List<CheckInitAdmin> findAll() {
        return checkInitAdminRepository.findAll();
    }
}
