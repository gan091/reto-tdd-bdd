package co.com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.example.dao.ITaskDAO;
import co.com.example.entities.Task;

@Service
public class TaskServiceImpl implements ITaskService{
	@Autowired
	private ITaskDAO dao;

	@Override
	@Transactional
	public Task save(Task task) {
		return dao.save(task);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Task> findAll() {
		return (List<Task>)dao.findAll();
	}
}