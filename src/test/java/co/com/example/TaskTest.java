package co.com.example;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import co.com.example.model.Task;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaskTest {

	@Test
	void validarInstanciaTask() {
		String titulo = "";
		String descripcion = "Validar los correos que aun no se han leido";
		
		Task task = new Task();
		task.setTitle(titulo);
		task.setDescription(descripcion);
		
		assertAll("Validacion de instancia",
				() -> assertNotNull(task, "Instancia no nula"),
				() -> assertNotNull(task.getTitle(), "El titulo no debe ser nulo"),
				() -> assertNotNull(task.getDescription(), "La descripcion no debe ser nula")
				);		
	}

}