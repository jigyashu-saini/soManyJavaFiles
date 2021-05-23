package p2105_1127;

public class Student {
	private String name;
	private Course[] courses;
	private int[] marks;

	public Student(String name) {
		this.name = name;
		this.courses = new Course[4];
		this.marks[0] = this.marks[1] = this.marks[2] = this.marks[3] = -1;
	}

	public void registerCourse(int courseId) {
		// if not a valid id
		if (!(courseId >= 0 && courseId <= 3)) {
			System.out.println("No such ID in course.");
			return;
		}
		// if a valid id
		Course course = new Course(courseId);
		// check if student has completed the prerequisite, marks > 59
		// if your class Course do not contains a field to store marks, then use the --
		// following commented if statement-- in the next if statement:
		// if (marks[courseId]<59 && course.getCourseId()!=0) {

		if (course.getMarks() < 59 && course.getCourseId() != 0) {
			System.out.println("Student has not registered the prequisite.");
			return;
		}
		this.courses[courseId] = course;
		System.out.println("The registeration for course id " + courseId + " is completed.");
	}

	public void placeExamMark(int courseMarks, int courseId) {
		// if not a valid id
		if (!(courseId >= 0 && courseId <= 3)) {
			System.out.println("No such ID in course.");
			return;
		}
		//if id is valid
		marks[courseId]=courseMarks;
		System.out.println("Marks have been assigned Successfully.");
	}
}

//a placeholder class for "Course", you shall replace the following class with the class "Course" that u might have created already
class Course {

	private int courseId;
	private int marks;

	public Course() {
	}

	public Course(int courseId) {
		this.courseId = courseId;
	}

	public int getMarks() {
		return marks;
	}

	public int getCourseId() {
		return courseId;
	}
}