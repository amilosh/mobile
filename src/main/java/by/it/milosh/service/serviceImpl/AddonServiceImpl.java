package by.it.milosh.service.serviceImpl;

import by.it.milosh.model.Addon;
import by.it.milosh.repository.AddonRepository;
import by.it.milosh.service.service.AddonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddonServiceImpl implements AddonService {

    @Autowired
    private AddonRepository addonRepository;

    @Override
    public void save(Addon addon) {
        addonRepository.save(addon);
    }

    @Override
    public Addon getById(Long id) {
        return addonRepository.findOne(id);
    }

    @Override
    public List<Addon> findAll() {
        return addonRepository.findAll();
    }

    @Override
    public List<Addon> getAddonsByUserId(Long userId) {
        return addonRepository.getAddonsByUserId(userId);
    }

    @Override
    public List<Addon> getAddonsNotUsedByUserId(Long userId) {
        return addonRepository.getAddonsNotUsedByUserId(userId);
    }
}
