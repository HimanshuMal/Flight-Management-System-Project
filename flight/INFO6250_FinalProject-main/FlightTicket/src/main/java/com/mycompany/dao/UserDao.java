
package com.mycompany.dao;

import com.mycompany.exception.FlightException;
import com.mycompany.pojo.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

public class UserDao extends DAO {

    public UserDao() {
    }

    public User get(User user) throws FlightException {
        try {
            begin();
            Criteria crit = getSession().createCriteria(User.class);
            crit.add(Restrictions.eq("email", user.getEmail()));
            crit.add(Restrictions.eq("pass", user.getPass()));
            User loggedInUser = (User) crit.uniqueResult();
            commit();
            return loggedInUser;

        } catch (HibernateException e) {
            rollback();
            throw new FlightException("Couldn't get user " + user.getEmail(), e);
        }
    }

    public User getforDelete(User user) throws FlightException {
        try {
            begin();
            Criteria crit = getSession().createCriteria(User.class);
            crit.add(Restrictions.eq("email", user.getEmail()));

            User loggedInUser = (User) crit.uniqueResult();
            commit();
            return loggedInUser;

        } catch (HibernateException e) {
            rollback();
            throw new FlightException("Couldn't get user " + user.getEmail(), e);
        }
    }

    public User create(User user) throws FlightException {
        try {
            begin();
            getSession().save(user);
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new FlightException("Exception while creating user:" + e.getMessage());
        }
    }

    public void delete(User user) throws FlightException {
        try {
            begin();
            getSession().delete(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new FlightException("Could not delete user " + user.getEmail(), e);
        }
    }

    public List<User> getAll() throws FlightException {
        List<User> users = new ArrayList<User>();
        try {
            begin();
            Criteria crit = getSession().createCriteria(User.class);
            users = crit.list();
            commit();
            return users;

        } catch (HibernateException e) {
            rollback();
            throw new FlightException("Couldn't get Users: ", e);
        }

    }
}
