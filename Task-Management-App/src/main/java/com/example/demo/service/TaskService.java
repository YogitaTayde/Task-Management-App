package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Task;
import com.example.demo.exception.TaskServiceException;
import com.example.demo.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	

	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	public Task updateTask(Long id, Task task) {

		Task existingTask = taskRepository.findById(id)
				.orElseThrow(() -> new TaskServiceException("Task not found with id : " + id, HttpStatus.NOT_FOUND));

		existingTask.setTitle(task.getTitle());
		existingTask.setDescription(task.getDescription());
		existingTask.setDueDate(task.getDueDate());
		existingTask.setCompleted(task.isCompleted());

		return taskRepository.save(existingTask);
	}

	public void deleteTask(Long id) {

		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new TaskServiceException("Task not found with id : " + id, HttpStatus.NOT_FOUND));

		taskRepository.delete(task);
	}
}