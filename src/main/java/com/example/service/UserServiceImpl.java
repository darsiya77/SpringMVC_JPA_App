package com.example.service;

import com.example.dao.UserDAO;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> scroll() {
        return userDAO.scroll();
    }

    @Override
    public User showUser(int id) {
        return userDAO.showUser(id);
    }

    @Override
    public void save(User person) {
        userDAO.save(person);
    }

    @Override
    public void update(int id, User updatedPerson) {
        userDAO.update(id, updatedPerson);
    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }
}
