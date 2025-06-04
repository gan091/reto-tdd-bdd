package co.com.example;

import co.com.example.model.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
	String title = "Revisión de correos";
	String description = "Revisar los correos electrónicos pendientes";

	@Test
	void validateTitleParameter() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Task("", description));
		assertEquals("El campo title es obligatorio y no puede estar vacío", exception.getMessage());
	}

	@Test
	void validateDescriptionParameter() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Task(title,""));
		assertEquals("El campo description es obligatorio y no puede estar vacío", exception.getMessage());
	}

	@Test
	void validateCompletedParameter() {
		Task task = new Task(title, description);
		assertFalse(task.getCompleted());
	}
}