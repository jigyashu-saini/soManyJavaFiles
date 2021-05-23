package idk;

import java.util.*;

class CourseManager {
//toatl students each section can hold
	static int max_Students;
//mapping of each sections w.r.t to course
	HashMap<String, ArrayList<Section>> courses;

//constructor for CourseManager
	public CourseManager(int max) {
		max_Students = max;
		courses = new HashMap<>();
	}

//class Person which will be used by teacher and students to inherit its properties
	static class Person {
		String name;
		int age;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
	}

//teacher class
	static class Teacher extends Person {
		int id;

		public Teacher(int id, String name, int age) {
			super(name, age);
			this.id = id;

		}

	}

//student class
	static class Student extends Person {
		int id;

		public Student(int id, String name, int age) {
			super(name, age);
			this.id = id;

		}

	}

//section class
	static class Section {
		int section;
		String course;
		Teacher instructor;
		int size;
		HashMap<Integer, Student> students;

//constructor
		public Section(int section, String course, Teacher instructor) {
			this.section = section;
			this.course = course;
			instructor = this.instructor;
			students = new HashMap<>();
			this.size = 0;

		}

//function to add students
		public void addStudent(int id, Student s1) {
			if (students.containsKey(id) || size == max_Students) {
				System.out.println("Adding student to Section is not succesful");

			} else {
				students.put(id, s1);
				size++;
				System.out.println("Adding student to Section is succesful");
			}
		}

//function to remove student
		public void removeStudent(int id) {
			if (!students.containsKey(id) || size == 0) {
				System.out.println("Removing student from Section is not succesful");

			} else {
				students.remove(id);
				size--;
				System.out.println("Removing student from Section is succesful");
			}
		}

	}

// function of course manager to map section with their courses
	public void addSection(String course, Section s) {
		if (!courses.containsKey(course))
			courses.put(course, new ArrayList<Section>());
		courses.get(course).add(s);

	}

//function to display the section w.r.t its courses
	public void DisplaySection() {
		for (String key : courses.keySet()) {
			System.out.print("Courses with sections : ");
			for (Section s : courses.get(key)) {
				System.out.print(s.section + " ");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
//course manager object
		CourseManager cm = new CourseManager(2);

//some students object
		Student s1 = new Student(123, "John", 15);
		Student s2 = new Student(456, "Paul", 16);
		Student s3 = new Student(789, "Chris", 15);
		Student s4 = new Student(901, "Morris", 17);

//some teacher object
		Teacher t1 = new Teacher(1234, "Sophie", 28);
		Teacher t2 = new Teacher(1000, "Alena", 40);

//creating section and mapping them with the courses
		Section sec1 = new Section(11, "M54", t1);
		cm.addSection("M54", sec1);
		Section sec2 = new Section(22, "C11", t2);
		cm.addSection("M55", sec2);

//adding and removing students
		sec1.addStudent(123, s1);
		sec1.addStudent(456, s2);
		sec1.addStudent(789, s3);
		sec1.removeStudent(123);
		sec2.addStudent(901, s4);

//display the section w.r.t its courses
		cm.DisplaySection();
	}
}
