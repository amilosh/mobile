package by.it.milosh.service.serviceImpl;

import by.it.milosh.repository.ServiceRepository;
import by.it.milosh.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public void add(by.it.milosh.model.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public by.it.milosh.model.Service getById(Long id) {
        return serviceRepository.findOne(id);
    }

    @Override
    public List<by.it.milosh.model.Service> findAll() {
        return serviceRepository.findAll();
    }
}
