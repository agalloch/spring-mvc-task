package org.homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO: add comment
 */
@Controller
public class UserTrackingController {

    @RequestMapping("/connection")
    public void trackUser(@RequestHeader("User-Agent") String userAgent, @RequestHeader("Host") String hostIp) {
        String logMessage = "Log from: [" + hostIp + "] using [" + userAgent + "] at [" + "";
        System.out.println(logMessage);
    }

    @RequestMapping("/connections-list")
    public Object searchConnections() {
        return "";
    }
}
