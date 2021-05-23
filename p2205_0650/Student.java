package p2205_0650;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Student {

	private String name;
	private int ID;
	private double[] tests_100;

	// constructor
	public Student(String name, int iD, double[] tests_100) {
		super();
		this.name = name;
		ID = iD;
		this.tests_100 = tests_100;
	}

	public double calculateAverage() {
		double average = 0;
		for (double marks : tests_100) {
			average += marks * 10;
		}
		average /= tests_100.length;
		return average;
	}

	public String Assign_Grade() {
		double average = this.calculateAverage();
		String grade = "";

		if (average < 50) {
			grade = "F";
		} else if (average < 65) {
			grade = "P";
		} else if (average < 75) {
			grade = "C";
		} else if (average < 85) {
			grade = "D";
		} else {
			grade = "HD";
		}
		return grade;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", ID=" + ID + ", tests_100=" + Arrays.toString(tests_100) + "]";
	}

	public static void main(String[] args) {
		// A scanner to read the contents of the file
		Scanner scanner = null;
		try {
			scanner = new Scanner(
					new File("D:\\javaEclipseInstalledHere\\may\\mayQuestions\\src\\p2205_0650\\marks.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("File not foud");
			System.exit(0);
		}

		// an arraylist to store the students
		ArrayList<Student> studentList = new ArrayList<>();

		scanner.nextLine(); // read out the next line that has row markings like ...ID name no.of tests
							// grades...
		while (scanner.hasNextLine()) {
			// pick up the proper values
			int studentID = scanner.nextInt();
			
			String studentName = scanner.next();
			int noOfTests = scanner.nextInt();
			// store the marks into testMarks array
			double[] testMarks = new double[noOfTests];
			for (int i = 0; i < noOfTests; i++) {
				testMarks[i] = scanner.nextDouble();
			}
			Student student = new Student(studentName, studentID, testMarks);
			// Add this student to the arrayList
			studentList.add(student);
		}

		// after having all the students into the arrayList, create a file "grades.txt"
		// and store the required data into it
		File gradeFile = new File("grade.txt");

		FileWriter myWriter;
		try {
			myWriter = new FileWriter(gradeFile);
			myWriter.write(String.format("%-10s %-10s\n", "Name","Grade"));
			for (Student student : studentList) {
				myWriter.write(String.format("%-10s %-10s\n", student.name, student.Assign_Grade()));
			}
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//display all the student with their average
		System.out.printf("%-10s %-10s\n","Name","Grade");
		for (Student student : studentList) {
			System.out.printf("%-10s %-10s\n",student.name,student.Assign_Grade());
		}
		
		double avgWholeClass = 0;
		for (Student student : studentList) {
			avgWholeClass+=student.calculateAverage();
		}
		avgWholeClass/=studentList.size();
		System.out.println("Average of whole calass is: "+avgWholeClass);
		
	}

}
