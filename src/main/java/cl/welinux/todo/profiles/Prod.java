package cl.welinux.todo.profiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import cl.welinux.todo.model.Todo;

@Profile("prod")
@Configuration
public class Prod {
	
	private static final Logger _log = LoggerFactory.getLogger(Prod.class); 
	@Bean
	public Todo getTodo() {
		_log.info("Cargando TODO @Profile({})",this.getClass().getName());
		Todo todo = new Todo();
		todo.setListo(false);
		todo.setTarea("Prod");
		return todo;
	}
}
