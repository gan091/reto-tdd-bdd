package co.com.example.service;

import java.util.List;

import co.com.example.entities.Task;

public interface ITaskService {
	public Task save(Task task);
	public List<Task> findAll();

}
