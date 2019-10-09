package ua.training.dao;

import ua.training.model.User;

public interface UserDao extends GenericDao<User> {
    User findByEmail(String email);
    User findByLogin(String login);
}
