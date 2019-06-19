package com.app.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.app.model.Todo;

public class TodoService {
	
	private Todo todo1;
	List<Todo> todos = new ArrayList<>();
	public void addTodo(String title) {
		todo1 = new Todo(title);
		todos.add(todo1);
		//System.out.println("added to list");
	}
	
	public void editTodo(int id,String newTitle) {
		for(Todo todo:todos) {
			if(todo.getId()==id) {
				todo.setTitle(newTitle);
			}
			break;
		}
	}

	public void deleteTodo(int id) {
		todos.removeIf(todo->todo.getId()==id);
	}
	
	public void completeTodo(int id) {
		for(Todo todo:todos) {
			if(todo.getId()==id) {
				if(todo.isCompleted()) {
					todo.setCompleted(false);
				}else todo.setCompleted(true);
				break;
			}
			
		}
	}
	public void completeAll() {
		for(Todo todo:todos) {
			todo.setCompleted(!todo.isCompleted());
		}
	}
	public void clearCompleted() {
		todos.removeIf(todo->todo.isCompleted());
	}
	
	
	public List<Todo> filter(Predicate<Todo> predicate){
		List<Todo> todos1 = 
				todos.stream()
				.filter(predicate)
				.collect(Collectors.toList());
		return todos1;
	}
	
	public List<Todo> sort(Comparator<Todo> comparator) {
		todos.sort(comparator);
		return todos;
	}
	public void displayAll() {
		for(Todo todo:todos) {
			System.out.println(todo);
		}
	}
}
