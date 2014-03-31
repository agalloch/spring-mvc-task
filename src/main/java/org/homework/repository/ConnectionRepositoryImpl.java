package org.homework.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.homework.entity.Connection;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

/**
 * Default implementation of a connection repository.
 */
public class ConnectionRepositoryImpl implements ConnectionRepository {
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    public void save(final Connection connection) {
        emf.createEntityManager().persist(connection);
    }

    @Override
    public List<Connection> getAllConnections(DateTime lowerBoundaryDate, DateTime upperBoundaryDate) {
        Session session = (Session)emf.createEntityManager().getDelegate();

        final Criteria criteria = session.createCriteria(Connection.class);

        if (lowerBoundaryDate != null) {
            criteria.add(Restrictions.ge("creationDate", lowerBoundaryDate.toDate()));
        }
        if (upperBoundaryDate != null) {
            criteria.add(Restrictions.le("creationDate", upperBoundaryDate.toDate()));
        }

        List result = criteria.list();
        return result;
    }
}
