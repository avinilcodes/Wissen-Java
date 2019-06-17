package java8;

enum Gender{
	MALE,FEMALE
}

class Employee{
	private int id;
	private String name;
	private Gender gender;
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	
}

public class Enum_ex {
public static void main(String[] args) {
}
}
