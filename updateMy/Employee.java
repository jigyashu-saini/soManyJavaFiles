package updateMy;

import java.util.Scanner;

public class Employee extends Person {
	private int employeeNumber;

	public Employee(String first, String last, String employee, long phone, int emplNumber) {
		super(first, last, employee, phone);
		employeeNumber = (emplNumber);
	}

	public Employee() {
		super();
		employeeNumber = (0);
	}

	@Override
	public void readInfo(Scanner sc) {
		System.out.print("Enter Employee Number: ");
		employeeNumber = (Integer.parseInt(sc.nextLine().trim()));
		super.readInfo(sc);
	}

	@Override
	public void printInfo() {
		String fullName = (firstName + " " + lastname);
		System.out.printf("%10d |", employeeNumber);
		System.out.printf(" %15s | %15s | %15s |", fullName, email, phoneNumber + "");
	}
}
