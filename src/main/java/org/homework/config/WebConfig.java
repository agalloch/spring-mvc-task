package org.homework.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Configures the root spring context.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "org.homework.controller" })
@EnableTransactionManagement
public class WebConfig {
}
