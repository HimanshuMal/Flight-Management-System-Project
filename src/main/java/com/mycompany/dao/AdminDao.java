
package com.mycompany.dao;

import com.mycompany.exception.FlightException;
import com.mycompany.pojo.Admin;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

public class AdminDao extends DAO {

    public AdminDao() {
    }

    public Admin get(Admin admin) throws FlightException {
        try {
            begin();
            Criteria crit = getSession().createCriteria(Admin.class);
            crit.add(Restrictions.eq("email", admin.getEmail()));
            crit.add(Restrictions.eq("pass", admin.getPass()));
            Admin loggedInAdmin = (Admin) crit.uniqueResult();
            commit();
            return loggedInAdmin;

        } catch (HibernateException e) {
            rollback();
            throw new FlightException("Couldn't get Admin " + admin.getEmail(), e);
        }
    }
}
