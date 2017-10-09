package by.it.milosh.service.service;

import by.it.milosh.model.User;

public interface InitializeService {

    void initializeRoles();

    void initializePhoneNumbers();

    User initializeAdmin(User user);

}
