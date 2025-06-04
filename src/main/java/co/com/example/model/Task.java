package co.com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
@Builder(toBuilder = true)
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Campo obligatorio no puede estar vacio")
	@Column(nullable = false, length = 30)
	private String title;
	
	@NotBlank(message = "Campo obligatorio no puede estar vacio")
	@Column(nullable = false, length = 70)
	private String description;
	
	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
	private Boolean completed = false;

	public Task(String title, String description) {
		if (title == null || title.isBlank()) {
			throw new IllegalArgumentException("El campo title es obligatorio y no puede estar vacío");
		}
		if (description == null || description.isBlank()) {
			throw new IllegalArgumentException("El campo description es obligatorio y no puede estar vacío");
		}
		this.title = title;
		this.description = description;
	}
}