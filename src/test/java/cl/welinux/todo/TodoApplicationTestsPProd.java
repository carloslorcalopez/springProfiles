package cl.welinux.todo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import cl.welinux.todo.model.Todo;
import cl.welinux.todo.model.repository.TodoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TodoApplication.class)
@ActiveProfiles(profiles="prod")
public class TodoApplicationTestsPProd {

	private static final Logger _log = LoggerFactory.getLogger(TodoApplicationTestsPProd.class);
	
	@Autowired
	private TodoRepository todoRepository;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void contextLoads() {
		Todo todo = new Todo();
		todo.setListo(false);
		todo.setTarea("Tarea 1");
		todoRepository.save(todo);
		_log.info("========> TODO : {}",todoRepository.count());
		assertEquals("Debe haber solo un TODO",1,todoRepository.count());
		Todo todoCtx = applicationContext.getBean(Todo.class);
		_log.info("========> TODO CTX: {}",todoCtx);
	}

}
