package org.homework.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.homework.entity.Connection;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

/**
 * Default implementation of a connection repository.
 */
public class ConnectionRepositoryImpl implements ConnectionRepository {
    private SessionFactory sessionFactory;

    @Required
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(final Connection connection) {
        getSession().persist(connection);
    }

    @Override
    public List<Connection> getAllConnections(DateTime lowerBoundaryDate, DateTime upperBoundaryDate) {
        Session session = getSession();

        final Criteria criteria = session.createCriteria(Connection.class);

        if (lowerBoundaryDate != null) {
            criteria.add(Restrictions.ge("creationDate", lowerBoundaryDate));
        }
        if (upperBoundaryDate != null) {
            criteria.add(Restrictions.le("creationDate", upperBoundaryDate));
        }

        List result = criteria.list();
        return result;
    }

    @Override
    public Connection find(Long connectionId) {
        return (Connection)getSession().get(Connection.class, connectionId);
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
