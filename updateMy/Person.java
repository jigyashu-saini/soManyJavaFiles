package updateMy;

import java.util.Scanner;

public abstract class Person {
	String firstName;
	String lastname;
	String email;
	long phoneNumber;

	public Person() {
		firstName = null;
		lastname = null;
		email = null;
		phoneNumber = 0;
	}

	public Person(String first, String last, String employee, long phone) {
		firstName = first;
		lastname = last;
		email = employee;
		phoneNumber = phone;
	}

	public void readInfo(Scanner sc) {
		System.out.print("Enter First Name: ");
		firstName = (sc.nextLine());
		System.out.print("Enter Last Name: ");
		lastname = sc.nextLine();
		System.out.print("Enter Email : ");
		email = sc.nextLine();
		System.out.print("Enter Phone Number: ");
		phoneNumber = (Long.parseLong(sc.nextLine().trim()));
	}

	public abstract void printInfo();
}