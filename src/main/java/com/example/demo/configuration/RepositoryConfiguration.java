package com.example.demo.configuration;

import com.example.demo.model.Employee;
import com.example.demo.model.Field;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RepositoryConfiguration implements RepositoryRestConfigurer
{
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors)
    {
        config.exposeIdsFor(Employee.class);
        config.exposeIdsFor(Field.class);
        cors.addMapping("/**").allowedOrigins("*").allowedHeaders("*").allowedMethods("*");
    }
}