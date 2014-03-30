package org.homework.repository;

import org.homework.entity.Connection;

import java.util.List;

/**
 * TODO: add comment
 */
public interface UserRepository {
    public void save(Connection connection);

    public List<Connection> getAllConnections();
}
