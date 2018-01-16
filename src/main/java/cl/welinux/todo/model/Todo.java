package cl.welinux.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String tarea;
	
	private Boolean listo = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public Boolean getListo() {
		return listo;
	}

	public void setListo(Boolean listo) {
		this.listo = listo;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", tarea=" + tarea + ", listo=" + listo + "]";
	}

}
