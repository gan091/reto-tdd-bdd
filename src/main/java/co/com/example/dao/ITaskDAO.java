package co.com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.example.entities.Task;

public interface ITaskDAO extends JpaRepository<Task, Integer>{

}
