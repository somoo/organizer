package com.somoo.organizer;

import com.somoo.organizer.persistence.hibernate.conf.HibernateUtils;
import com.somoo.organizer.user.User;
import com.somoo.organizer.user.role.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DummyMain {

    public static void main(String[] args) {

      //  createUser();
        User userOfDb = readUser("admin", "root");
        System.out.println(userOfDb);
    }

    private static User readUser(String login, String pw) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        String hql = "FROM User  U WHERE U.logIn ='" + login + "'";
        Query query = session.createQuery(hql);
        List<User> userList = query.list();
        session.close();
        sessionFactory.close();

        return userList.get(0);
    }

    private static void createUser() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();

        User user = new User();
        user.setId(1234);
        user.setAge(18);
        user.setFirstName("somoo");
        user.setSecondName("boehm");
        user.setLogIn("admin");
        user.setPassWord("root");
        ArrayList<Role> role = new ArrayList<>();
        Role admin = new Role();
        admin.setRole("adm");
        admin.setId("111");
        admin.setUser(user);
        Role userrole = new Role();
        userrole.setRole("use");
        userrole.setId("222");
        userrole.setUser(user);
        role.add(admin);
        role.add(userrole);
        user.setRoles(role);

        session.save(user);
        for (Role r : user.getRoles()) {
            session.save(r);
        }
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
