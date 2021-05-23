package itaAllAboutRobots;

//the student class
public class Student {
	private String name;
	private int id;
	private double age;
	
	public Student(String name, int id, double age) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected int getId() {
		return id;
	}

	protected double getAge() {
		return age;
	}
}
