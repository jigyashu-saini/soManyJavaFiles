package updateMy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Store {
	public static int count;
	private Employee[] employees = {};

	public Store(int number) {
		try {
			employees = new Employee[number];
		} catch (NegativeArraySizeException ex) {
			System.out.println("*****Array Size cannot be Negative*****");
		}

		count = 0;
	}
	
//	 Also, you need to add two methods to check whether array is empty and array is full.
//	Read options should check whether array is full or not. 
//	Print option should check whether array is empty.
	public boolean isEmployeesListEnpty() {
		return count==0;
	}
	public boolean isEmployeesListFull() {
		return count==employees.length;
	}
	
	//a method to add employee to the employeesList
	public void addEmployee(Employee employee) {
		if (isEmployeesListFull()) {
			System.out.println("The Employee list is full, can not add more employees.");
			return;
		}
		this.employees[count]=employee;
		count++;
	}

	public static void printLine() {
		System.out.println("====================================================================================");
	}

	public static void printTitle(String name) {
		String name1 = name + " Store Management System";
		printLine();
		System.out.printf("%50s\n", name1);
		printLine();
		System.out.printf("%10s | %15s | %15s | %15s | %15s |\n", "Emp#", "Name", "Email", "Phone", "Salary");
		printLine();
	}

	public void readDetails() {
//		using isEmployeesListFull()
		if (isEmployeesListFull()) {
			System.out.println("The Employee list is full, can not add more employees.");
			return;
		}
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		try {
			if (count < employees.length) {
				System.out.println("Enter Details of Employee " + (count + 1));
				System.out.println("1. Regular");
				System.out.println("2. Contractor");
				System.out.print("Enter the type of employee: ");
				int type = Integer.parseInt(sc.nextLine().trim());
				switch (type) {
				case 1 -> {
					employees[count] = new Regular();
					employees[count].readInfo(sc);
					flag = true;
				}
				case 2 -> {
					employees[count] = new Contractor();
					employees[count].readInfo(sc);
					flag = true;
				}
				default -> System.out.println("Invalid option.... please try again");
				}
				if (flag)
					count++;
			} else {
				System.out.println("Already added Maximum number of employees");
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Already added Maximum number of employees");
		} catch (InputMismatchException | NumberFormatException inputException) {
			System.out.println("*****Input Mismatch Exception while reading Selection of process*****");
		}
	}

	/**
	 * Print the details
	 */
	public void printDetails() {
		if (isEmployeesListEnpty()) {
			System.out.println("Employee list is empty.");
			return;
		}
		try {
			for (int i = 0; i < count; i++) {
				employees[i].printInfo();
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}
	}
}