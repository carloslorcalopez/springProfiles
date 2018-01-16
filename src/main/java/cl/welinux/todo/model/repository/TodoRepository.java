package cl.welinux.todo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.welinux.todo.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    Todo findById(Long id);
}
