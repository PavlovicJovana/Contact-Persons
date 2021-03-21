package it.engineering.spring.mvc.task.contacts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class ViewResolverConfig {

	@Bean
	public ViewResolver tilesViewResolver() {
		System.out.println("==================== TilesViewResolver ====================");
		TilesViewResolver tilesViewResolver = new TilesViewResolver(); 
		return tilesViewResolver;
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		
		tilesConfigurer.setDefinitions(new String[] {
				"/WEB-INF/views/tiles/tiles.xml"
		});
		
		return tilesConfigurer;
	}

}
