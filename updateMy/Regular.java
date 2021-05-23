package updateMy;

import java.util.Scanner;

public class Regular extends Employee {
	double salary;

	public Regular(String first, String last, String employee, long phone, int emplNumber, double salary) {
		super(first, last, employee, phone, emplNumber);
		this.salary = (salary);
	}

	public Regular() {
		super();
	}

	@Override
	public void readInfo(Scanner sc) {
		super.readInfo(sc);
		System.out.print("Enter annual Salary: ");
		salary = (Double.parseDouble(sc.nextLine().trim()));
	}

	@Override
	public void printInfo() {
		super.printInfo();
		System.out.printf(" %15.2f |\n", (salary / 12));

	}

}