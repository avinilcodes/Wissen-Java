package com.app.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.app.model.Todo;

public class TodoService {

	private Map<String, List<Todo>> todosMap = new HashMap<>();
	private AtomicInteger atomicInteger = new AtomicInteger(0);

	public void addTodo(String user, String title) {
		Todo todo = new Todo(atomicInteger.incrementAndGet(), title);
		List<Todo> todos = todosMap.get(user);
		if (todos == null) {
			todos = new ArrayList<>();
			todos.add(todo);
			todosMap.put(user, todos);
		} else {
			todos.add(todo);
			todosMap.put(user, todos);
		}
	}

	public void editTodo(String user, int id, String newTitle) {
		List<Todo> todos = todosMap.get(user);
		todos.forEach(item -> {
			if (item.getId() == id) {
				item.setTitle(newTitle);
				return;
			}
		});
	}

	public void deleteTodo(String user, int id) {
		List<Todo> todos = todosMap.get(user);
		todos.removeIf(item -> item.getId() == id);
	}

	public void completeTodo(String user, int id) {
		List<Todo> todos = todosMap.get(user);
		todos.forEach(item -> {
			if (item.getId() == id) {
				item.setCompleted(true);
			}
		});

	}

	public void completeAll(String user) {
		List<Todo> todos = todosMap.get(user);
		boolean isAllCompleted = todos.stream().allMatch(item -> item.isCompleted());
		todos.replaceAll(item -> {
			item.setCompleted(!isAllCompleted);
			return item;
		});

	}

	public void clearCompleted(String user) {
		List<Todo> todos = todosMap.get(user);
		todos.removeIf(todo -> todo.isCompleted());
	}

	public List<Todo> get(String user, String filter) {
		List<Todo> todos = todosMap.get(user);
		switch (filter) {
		case "ALL":
			return todos;
		case "ACTIVE":
			return todos.stream().filter(item -> !item.isCompleted()).collect(Collectors.toList());
		case "COMLETED":
			return todos.stream().filter(item -> item.isCompleted()).collect(Collectors.toList());
		default:
			return new ArrayList<>();
		}
	}

	public List<Todo> sort(String user, String property) {
		List<Todo> todos = todosMap.get(user);
		switch (property) {
		case "id":
			return todos.stream().sorted(Comparator.comparingInt(Todo::getId)).collect(Collectors.toList());
		case "title":
			return todos.stream().sorted(Comparator.comparing(Todo::getTitle)).collect(Collectors.toList());
		default:
			return new ArrayList<>();
		}
	}

	public int size(String user) {
		List<Todo> todos = todosMap.get(user);
		return todos.size();
	}

}
