package org.homework.config;

import org.hibernate.SessionFactory;
import org.homework.repository.ConnectionRepository;
import org.homework.repository.ConnectionRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * Configures the application context.
 */
@Configuration
@ImportResource("classpath:META-INF/spring/dataSource-config.xml")
@EnableTransactionManagement
public class AppConfig {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SessionFactory sessionFactory;

    @Bean
    public ConnectionRepository connectionRepository() {
        final ConnectionRepositoryImpl connectionRepository = new ConnectionRepositoryImpl();
        connectionRepository.setSessionFactory(sessionFactory);
        return connectionRepository;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        final HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }
}
