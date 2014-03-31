package org.homework.repository;

import org.homework.entity.Connection;
import org.joda.time.DateTime;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.util.List;

/**
 * Repository that handles all necessary operations to persist and retrieve connection entities.
 */
public interface ConnectionRepository {
    /**
     * Persists a connection entity.
     *
     * @param connection
     */
    public void save(Connection connection);

    /**
     * Retrieves all existing connections.
     * Optionally limits the results depending on {@code fromDate} and {@code toDate} arguments.
     *
     * @param fromDate
     * @param toDate
     * @return
     */
    public List<Connection> getAllConnections(DateTime fromDate, DateTime toDate);
}
