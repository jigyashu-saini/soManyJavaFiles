package quizWork;

import java.util.Scanner;

class Student {
	int id, level;
	int quizMark;

	Student(int id, int level) {
		this.id = id;
		this.level = level;
	}
}

class Quiz {
	int numberOfQuestions;
	Student student;
	int currentResult;

	Quiz(int numberOfQuestions, Student st) {
		this.numberOfQuestions = numberOfQuestions;
		this.student = st;
		st.quizMark = 0;
	}

	void generateQuestion() {
		int number1, number2;
//		(Math.random()*((max-min)+1))+min; for a random integer between min and max inclusive
		number1 = (int) (Math.random() * ((9 - 1) + 1)) + 1;
		number2 = (int) (Math.random() * ((9 - 1) + 1)) + 1;
		System.out.println("What is the summation of Number1 " + number1 + " and Number2 " + number2);
		currentResult = number1 + number2;
	}

	void checkAnswer(int answer) {
		if (currentResult == answer) {
			student.quizMark++;
			System.out.println("Correct answer.");
		} else {
			System.out.println("Incorrect answer.");
		}
	}
}

class Driver {
	public static void main(String[] args) {
		// two students
		Student s1 = new Student(1234, 3);
		Student s2 = new Student(5678, 3);
		// two quizes
		Quiz q1 = new Quiz(5, s1);
		Quiz q2 = new Quiz(10, s2);

		// a scanner to take input
		Scanner scanner = new Scanner(System.in);

		// for student 1, ask question 5 times, take input and check result
		System.out.println("For student with id: " + q1.student.id + " and level: " + q1.student.level + ":");
		for (int i = 0; i < q1.numberOfQuestions; i++) {
			System.out.print("Q" + (i + 1) + ": ");
			q1.generateQuestion();
			q1.checkAnswer(scanner.nextInt());
		}
		// print s1 score:
		System.out.println("Student with id: " + q1.student.id + " and level: " + q1.student.level
				+ " achieved a score of: " + q1.student.quizMark + " out of " + q1.numberOfQuestions);

		System.out.println();

		// for student 2, ask question 10 times, take input and check result
		System.out.println("For student with id: " + q2.student.id + " and level: " + q2.student.level + ":");
		for (int i = 0; i < q2.numberOfQuestions; i++) {
			System.out.print("Q" + (i + 1) + ": ");
			q2.generateQuestion();
			q2.checkAnswer(scanner.nextInt());
		}
		// print s1 score:
		System.out.println("Student with id: " + q2.student.id + " and level: " + q2.student.level
				+ " achieved a score of: " + q2.student.quizMark + " out of " + q2.numberOfQuestions);

		scanner.close();
	}
	
}
