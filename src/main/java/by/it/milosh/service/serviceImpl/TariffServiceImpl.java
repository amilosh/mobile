package by.it.milosh.service.serviceImpl;

import by.it.milosh.model.Tariff;
import by.it.milosh.model.User;
import by.it.milosh.repository.TariffRepository;
import by.it.milosh.service.service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TariffServiceImpl implements TariffService {

    @Autowired
    private TariffRepository tariffRepository;

    @Override
    public void add(Tariff tariff) {
        tariffRepository.save(tariff);
    }

    @Override
    public Tariff getById(Long id) {
        return tariffRepository.findOne(id);
    }

    @Override
    public List<Tariff> findAll() {
        return tariffRepository.findAll();
    }
}
