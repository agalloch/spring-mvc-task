package org.homework.controller;

import org.homework.entity.Connection;
import org.homework.repository.ConnectionRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Responsible for handling request and response dispatching.
 */
@Controller
@Transactional
public class UserTrackingController {
    @Autowired
    private ConnectionRepository connectionRepository;


    @RequestMapping(value = "/connection", method = RequestMethod.GET, produces = "text/plain")
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

    @RequestMapping(value = "/connection/{id}", method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public ModelAndView getConnection(@PathVariable("id") Long connectionId) {
        Connection conn = connectionRepository.find(connectionId);

        return new ModelAndView("singleConnection", "connection", conn);
    }

    @RequestMapping(value = "/connections-list", method = RequestMethod.GET, produces = "text/plain")
    @Transactional(readOnly = true)
    public ModelAndView searchConnections(@RequestParam(value = "fromDate", required = false) String fromDate,
                                                  @RequestParam(value = "toDate", required = false) String toDate) {

        final DateTime fromDateObj = (fromDate != null) ? DateTime.parse(fromDate) : null;
        final DateTime toDateObj = (toDate != null) ? DateTime.parse(toDate) : null;

        List<Connection> connections = connectionRepository.getAllConnections(fromDateObj, toDateObj);

        return new ModelAndView("connectionsList", "connections", connections);
    }

    private Connection createConnection(String userAgent, String clientIpAddress, DateTime connectionDateTime) {
        Connection connection = new Connection();
        connection.setClientIp(clientIpAddress);
        connection.setUserAgent(userAgent);
        connection.setUsername("Anonymous");
        connection.setCreationDate(connectionDateTime);
        return connection;
    }
}
