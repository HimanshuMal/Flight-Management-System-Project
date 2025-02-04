
package com.mycompany.dao;

import com.mycompany.exception.FlightException;
import com.mycompany.pojo.Flight;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

public class FlightDao extends DAO {

    public FlightDao() {
    }

    public Flight get(Flight flight) throws FlightException {
        try {
            begin();
            Criteria crit = getSession().createCriteria(Flight.class);
            crit.add(Restrictions.eq("flightNo", flight.getFlightNo()));

            Flight checkFlight = (Flight) crit.uniqueResult();
            commit();
            return checkFlight;

        } catch (HibernateException e) {
            rollback();
            throw new FlightException("Couldn't get flight: " + flight.getFlightNo(), e);
        }
    }

    public Flight create(Flight flight) throws FlightException {
        try { flight.setAvailableSeats(flight.getTotalSeats());
            begin();
            getSession().save(flight);
            commit();
            return flight;
        } catch (HibernateException e) {
            rollback();
            throw new FlightException("Exception while creating flight:" + e.getMessage());
        }
    }

    public void delete(Flight flight) throws FlightException {
        try {
            begin();
            getSession().delete("flight", flight);
            commit();

        } catch (HibernateException e) {
            rollback();
            throw new FlightException("Could not delete flight " + flight.getFlightNo(), e);
        }
    }

    public void updateFlight(Flight flight) throws FlightException {
        try {
            begin();
            getSession().update(flight);
            commit();

        } catch (HibernateException e) {
            rollback();
            throw new FlightException("Exception while update flight:" + e.getMessage());
        }
    }

    public Flight getForUpdate(Flight flight) throws FlightException {
        try {
            begin();
            Criteria crit = getSession().createCriteria(Flight.class);
            crit.add(Restrictions.eq("flightNo", flight.getFlightNo()));
            crit.add(Restrictions.eq("source", flight.getSource()));
            crit.add(Restrictions.eq("dest", flight.getDest()));
            crit.add(Restrictions.eq("totalSeats", flight.getTotalSeats()));

            Flight checkFlight = (Flight) crit.uniqueResult();
            commit();
            return checkFlight;

        } catch (HibernateException e) {
            rollback();
            throw new FlightException("Couldn't get flight: " + flight.getFlightNo(), e);
        }
    }

    public List<Flight> getAll() throws FlightException {
        List<Flight> flights = new ArrayList<Flight>();
        try {
            begin();
            Criteria crit = getSession().createCriteria(Flight.class);
            flights = crit.list();
            commit();
            return flights;

        } catch (HibernateException e) {
            rollback();
            throw new FlightException("Couldn't get flight: ", e);
        }
    }
    
    

}
