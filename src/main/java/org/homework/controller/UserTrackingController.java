package org.homework.controller;

import org.homework.entity.Connection;
import org.homework.repository.ConnectionRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Responsible for handling request and response dispatching.
 */
@Controller
@Transactional
public class UserTrackingController {
    @Autowired
    private ConnectionRepository connectionRepository;


    @RequestMapping("/connection")
    public @ResponseBody String trackUser(@RequestHeader("User-Agent") String userAgent,
                                          HttpServletRequest request) {
        final String clientIpAddress = request.getRemoteAddr();
        final DateTime connectionDateTime = DateTime.now();
        String logMessage = "Hello, you've logged using '" + userAgent + "' at " + connectionDateTime +
                " from host with IP: " + clientIpAddress;

        final Connection connection = createConnection(userAgent, clientIpAddress, connectionDateTime);
        connectionRepository.save(connection);

        return logMessage;
    }

    @RequestMapping("/connections-list")
    public @ResponseBody String searchConnections(@RequestParam(value = "fromDate", required = false) String fromDate,
                                                  @RequestParam(value = "toDate", required = false) String toDate) {

        final DateTime fromDateObj = (fromDate != null) ? DateTime.parse(fromDate) : null;
        final DateTime toDateObj = (toDate != null) ? DateTime.parse(toDate) : null;

        List<Connection> connections = connectionRepository.getAllConnections(fromDateObj, toDateObj);

        return connections.size() > 0 ? connections.toString() : "There were not results from your search";
    }

    private Connection createConnection(String userAgent, String clientIpAddress, DateTime connectionDateTime) {
        Connection connection = new Connection();
        connection.setClientIp(clientIpAddress);
        connection.setUserAgent(userAgent);
        connection.setUsername("Anonymous");
        connection.setCreationtDate(connectionDateTime);
        return connection;
    }
}
