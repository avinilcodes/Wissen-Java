package com;

import java.util.function.BiFunction;
import java.util.function.Function;

class Employee {
	private int id;
	private String name;

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Employee(int id) {
		super();
		this.id = id;
	}
	@Override
	public String toString() {
		return ("id "+ id+" name "+name+" of");
	}
}

public class Method_Ref_Ex {
	public static void main(String[] args) {
		//BiFunction<Integer, String, Employee> biFunction = (id, name) -> new Employee(id, name);
		//Function<Integer, Employee> function = (id) -> new Employee(id);
		BiFunction<Integer, String, Employee> biFunction1 = Employee::new;
		Function<Integer, Employee> function1 = Employee::new;
		Employee e1 = function1.apply(1);
		Employee e2 = biFunction1.apply(11, "ab");
		System.out.println(e1);
		System.out.println(e2);
	}

}
