package org.homework.config;

import org.homework.repository.ConnectionRepository;
import org.homework.repository.ConnectionRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Configures the application context.
 */
@Configuration
@ImportResource("classpath:META-INF/spring/dataSource-config.xml")
public class AppConfig {

    @Bean
    public ConnectionRepository connectionRepository() {
        return new ConnectionRepositoryImpl();
    }
}
