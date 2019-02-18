package com.somoo.organizer.service.impl;

import com.somoo.organizer.persistence.crud.CRUD;
import com.somoo.organizer.persistence.hibernate.conf.HibernateUtils;
import com.somoo.organizer.service.interfaces.UserRepositoryService;
import com.somoo.organizer.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class UserRepositoryServiceImpl implements UserRepositoryService, CRUD<User,String> {

    @Override
    public boolean create(User user) {
        return false;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public Optional<User> read(String login) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        String hql = "FROM User  U WHERE U.logIn ='" + login + "'";
        Query query = session.createQuery(hql);
        List<User> userList = query.list();
        session.close();
        if(userList.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(userList.get(0));
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }
}
