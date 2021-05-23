package updateMy;

import java.util.Scanner;

public class Contractor extends Employee {

	private double hourlyRate;
	private double numHours;

	public Contractor(String first, String last, String employee, long phone, int emplNum, double numHrs, double rate) {
		super(first, last, employee, phone, emplNum);
		hourlyRate = (rate);
		numHours = (numHrs);
	}

	public Contractor() {
		super();
	}

	@Override
	public void readInfo(Scanner sc) {
		super.readInfo(sc);
		System.out.print("Enter Hourly Rate: ");
		hourlyRate = (Double.parseDouble(sc.nextLine().trim()));
		System.out.print("Enter Number of hours: ");
		numHours = (Double.parseDouble(sc.nextLine().trim()));
	}

	@Override
	public void printInfo() {
		super.printInfo();
		System.out.printf(" %15.2f |\n", (numHours * hourlyRate));
	}
}