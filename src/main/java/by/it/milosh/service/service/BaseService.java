package by.it.milosh.service.service;

import java.util.List;

public interface BaseService<T> {

    void save(T t);

    T getById(Long id);

    List<T> findAll();

}
