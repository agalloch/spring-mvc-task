package org.homework.config;

import org.homework.repository.UserRepository;
import org.homework.repository.UserRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO: add comment
 */
@Configuration
public class AppConfig {

    @Bean
    public UserRepository repository() {
        return new UserRepositoryImpl();
    }
}
