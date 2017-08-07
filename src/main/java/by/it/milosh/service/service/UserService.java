package by.it.milosh.service.service;

import by.it.milosh.model.User;

public interface UserService extends BaseService<User> {

    User findUserByUsername(String username);

}
