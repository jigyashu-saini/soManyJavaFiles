package updateMy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Driver class
 */
public class Lab7 {
	private static void readEmployeeDetailsFromFile(Store store) {
		System.out.print("Enter the file path: ");
		Scanner scanner = new Scanner(System.in);
		String file = scanner.nextLine();
		try {
			scanner = new Scanner(new File(file));
		} catch (FileNotFoundException e) {
			System.err.println("Can not open the file.");
		}
		while (scanner.hasNext()) {
			String fullDetails = (String) scanner.nextLine();
			Scanner scanner2 = new Scanner(fullDetails);
			char type = scanner2.next().charAt(0);
			if (type=='r') {
				int empNum = scanner2.nextInt();
				String fname = scanner2.next();
				String lname = scanner2.next();
				String email = scanner2.next();
				long phonNum = scanner2.nextLong();
				double salary = scanner2.nextDouble();
				store.addEmployee(new Regular(fname, lname, email, phonNum, empNum, salary));
			} else if (type=='c') {
				int empNum = scanner2.nextInt();
				String fname = scanner2.next();
				String lname = scanner2.next();
				String email = scanner2.next();
				long phonNum = scanner2.nextLong();
				double hourlyRate = scanner2.nextDouble();
				double hours = scanner2.nextDouble();
				store.addEmployee(new Contractor(fname, lname, email, phonNum, empNum, hours, hourlyRate));
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the Store: ");
		String name = sc.nextLine();
		int num = 0;
		do {
			try {
				System.out.print("Enter the number of Employees: ");
				num = Integer.parseInt(sc.nextLine().trim());
			} catch (InputMismatchException | NumberFormatException inputException) {
				System.out.println("*****Input Mismatch Exception while reading the number of Employees*****");
				continue; // continue to run code
			}
		} while (num <= 0);
		Store store = new Store(num);
		int choice = 0;
		do {
			do {
				try {
					System.out.println("1. Read Employee Details from user");
					System.out.println("2. Read Employee Details from file");
					System.out.println("3. Print Employee Details");
					System.out.println("4. Quit");
					System.out.print("Enter Your option: ");
					choice = Integer.parseInt(sc.nextLine().trim());

					switch (choice) {
					case 1 -> store.readDetails();
					case 2 -> readEmployeeDetailsFromFile(store);
					case 3 -> {
						Store.printTitle(name);
						store.printDetails();
					}
					case 4 -> {
						System.out.println("Goodbye... Have a nice day!");
						System.exit(0);
					}
					default -> System.out.println("Invalid option... please try again...");
					}
				} catch (InputMismatchException | NumberFormatException inputException) {
					System.out.println("*****Input Mismatch Exception while reading Selection of process*****");
				}
			} while (choice != 1 && choice != 2 && choice != 3);
		} while (choice != 3);
	}
}
