package org.homework.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * TODO: add comment
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "org.homework.controller" })
public class WebConfig {
}