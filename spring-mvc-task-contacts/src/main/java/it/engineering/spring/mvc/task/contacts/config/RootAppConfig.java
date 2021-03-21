package it.engineering.spring.mvc.task.contacts.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = DatabaseConfig.class)
@ComponentScan(basePackages = {
		"it.engineering.spring.mvc.task.contacts.service",
		"it.engineering.spring.mvc.task.contacts.dao",
		"it.engineering.spring.mvc.task.contacts.converter"
})
public class RootAppConfig {

}
