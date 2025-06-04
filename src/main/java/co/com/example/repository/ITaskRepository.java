package co.com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.example.model.Task;

public interface ITaskRepository extends JpaRepository<Task, Integer>{

}
