package org.homework.repository;

import org.hibernate.Session;
import org.homework.entity.Connection;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * TODO: add comment
 */
public class UserRepositoryImpl implements UserRepository {
    private EntityManager entityManager;

    @Override
    public void save(final Connection connection) {
        entityManager.persist(connection);
        entityManager.flush();
    }

    @Override
    public List<Connection> getAllConnections() {
        Session session = (Session)entityManager.getDelegate();

        // TODO: add from-to date filter(s)
        List result = session.createCriteria(Connection.class).list();
        return result;
    }
}
