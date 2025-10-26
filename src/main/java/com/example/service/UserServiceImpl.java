package com.example.dao;

import com.example.model.User;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @EventListener
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // Проверяем, нет ли уже данных, чтобы избежать дублирования
        Long count = (Long) em.createQuery("select count(u) from User u").getSingleResult();
        if (count == 0) {
            em.persist(new User("UserName1", "UserSurname1", "User1@mail.ru"));
            em.persist(new User("UserName2", "UserSurname2", "User2@mail.ru"));
            em.persist(new User("UserName3", "UserSurname3", "User3@mail.ru"));
            em.persist(new User("UserName4", "UserSurname4", "User4@mail.ru"));

        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> scroll() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public User showUser(int id) {
        return em.find(User.class, id);
    }

    @Transactional
    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        updatedUser.setId(id);
        em.merge(updatedUser);
    }

    @Override
    public void delete(int id) {
        em.createQuery("delete User u where id=:id").setParameter("id", id).executeUpdate();
    }
}
