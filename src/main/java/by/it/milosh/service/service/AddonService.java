package by.it.milosh.service.service;

import by.it.milosh.model.Addon;

import java.util.List;

public interface AddonService extends BaseService<Addon> {

    List<Addon> getAddonsByUserId(Long userId);

    List<Addon> getAddonsNotUsedByUserId(Long userId);

}
