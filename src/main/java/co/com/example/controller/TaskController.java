package co.com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.example.model.Task;
import co.com.example.service.ITaskService;

@RestController
public class TaskController {
	@Autowired
	private ITaskService servicio;
	
	@PostMapping("/task")
	public ResponseEntity<Task> guardar(@RequestBody Task task, BindingResult result) {
		if(result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio una incidencia: "+ error.getDefaultMessage());				
			}
			return ResponseEntity.badRequest().build();
		}
		Task taskSave = servicio.save(task);
		return ResponseEntity.status(201).body(taskSave);
	}
	
	@GetMapping("/listTask")
	public List<Task> listar(){
		return servicio.findAll();
	}
}