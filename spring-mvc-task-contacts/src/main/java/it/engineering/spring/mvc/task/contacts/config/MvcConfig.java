package it.engineering.spring.mvc.task.contacts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import it.engineering.spring.mvc.task.contacts.formatter.ManufacturerDtoFormatter;
import it.engineering.spring.mvc.task.contacts.service.ManufacturerService;

@Configuration
@Import({
	ViewResolverConfig.class
})
@ComponentScan(basePackages = {
		"it.engineering.spring.mvc.task.contacts.controller"
})
@EnableWebMvc			
public class MvcConfig implements WebMvcConfigurer {
	private final ManufacturerService manufacturerService;
	
	@Autowired
	public MvcConfig(ManufacturerService manufacturerService) {
		this.manufacturerService = manufacturerService;
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new ManufacturerDtoFormatter(manufacturerService));
	}
}
