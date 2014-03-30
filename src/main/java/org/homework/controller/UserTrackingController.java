package org.homework.controller;

import org.homework.repository.UserRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO: add comment
 */
@Controller
public class UserTrackingController {
    @Autowired
    private UserRepository userRepo;


    @RequestMapping("/connection")
    public @ResponseBody String trackUser(@RequestHeader("User-Agent") String userAgent,
                                          HttpServletRequest request) {
        String clientIpAddress = request.getRemoteAddr();
        String logMessage = "Hello, you've logged using '" + userAgent + "' at " + DateTime.now() + " from host with IP: " + clientIpAddress;
        return logMessage;
    }

    @RequestMapping("/connections-list")
    public @ResponseBody String searchConnections() {
        final String response = "[under construction]";
        return response;
    }
}
