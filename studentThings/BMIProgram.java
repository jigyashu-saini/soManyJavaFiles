package studentThings;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Third, create a class called BMIProgram (with a main method)
//Once your instantiable class (BMI) has been coded and tested thoroughly (BMITest), you can create a user interface program that will use it.
//Create and instantiate a static global List that will be used to hold BMI objects
//Use a menu-driven approach (Option 1 Metric; Option 2 Standard; Option 3 Exit)
//Prompt for weight and height based on option chosen (be sure to use Try/Catch)
//Construct a BMI object with the values entered, or default values if not valid
//Display the results of the entered BMI data (use the toString method from your BMI class)
//Ask the user if they want to write the BMI data to the file. If yes, add the object to the BMI List, then return to Menu. If not, return to Menu.
//At Exit, we need to take the objects in the list and serialize them to the file. The file will be over-written with the objects in the current list.
//Create and open an output file stream
//Serialize the list to the file
//Close the file when done

public class BMIProgram {

	private static List<BMI> bmiList = new ArrayList<BMI>(); // Create and instantiate a static global List that will be
																// used to hold BMI objects

	public static void main(String[] args) {
		// Use a menu-driven approach (Option 1 Metric; Option 2 Standard; Option 3
		// Exit)
		Scanner scanner = new Scanner(System.in);

		// _________________________________________________________________________________
		do {
			int choice = 0;
			do { // input vailid choice
				System.out.println("Choose:\n1.Metric\n2.Standard\n3.Exit");
				try {
					choice = scanner.nextInt();
				} catch (Exception e) {
					System.out.println("Enter vailid choice: 1, 2 or 3\n");
					continue;
				}
				if (choice > 3 || choice < 1)
					System.out.println("Enter vailid choice: 1, 2 or 3\n");
				else
					break;

			} while (true);

			// _________________________________________________________________________________

			// if choice is 3. break the outer while loop.
			if (choice == 3) {
				break;
			}

			// _________________________________________________________________________________

			// in other cases
			// Prompt for weight and height based on option chosen (be sure to use
			// Try/Catch)
			int weight = 0;
			int height = 0;
			boolean vailidInput = true;
			try {
				System.out.print("Enter weight: ");
				weight = scanner.nextInt();

				System.out.print("Enter height: ");
				height = scanner.nextInt();
			} catch (Exception e) {
				vailidInput = false; // as program want us to create a default BMI if inout is invailid
			}

			// _________________________________________________________________________________

			// Construct a BMI object with the values entered, or default values if not
			// valid
			BMI bmi;
			if (vailidInput) {
				bmi = new BMI(weight, height, choice, "FNAME", "LNAME"); // remenber we have not inputed the names as
																			// program did not asked us to
			} else {
				bmi = new BMI();
			}

			// _________________________________________________________________________________
			// Display the results of the entered BMI data (use the toString method from
			// your BMI class)
			System.out.println(bmi + "\n");

			// _________________________________________________________________________________
			// Ask the user if they want to write the BMI data to the file. If yes, add the
			// object to the BMI List, then return to Menu. If not, return to Menu.
			System.out.print("Do you want to save this to file?(y/n): ");
			boolean saveToFile = scanner.next().toLowerCase().contains("y") ? true : false;

			if (saveToFile) {
				bmiList.add(bmi);
			}
		} while (true);

		// _________________________________________________________________________________
		// At Exit, we need to take the objects in the list and serialize them to the
		// file. The file will be over-written with the objects in the current list.
		// Create and open an output file stream

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			// please enter the file name according to your own system
			fos = new FileOutputStream(
					"D:\\javaEclipseInstalledHere\\EclipseWorksapce\\che2\\src\\studentThings\\bmiOutput.txt");
			oos = new ObjectOutputStream(fos);
		} catch (IOException e) {
			System.err.println("Can not open the file! (please change the file name in code and remove this comment)");
			try {
				//remenber to close everything before exiting the program
				fos.close();
				oos.close();
			} catch (IOException e1) {
				System.err.println("Can not close the file!");
			}
			scanner.close();
			return; //if error occures while writing, exit the program
		}
		
		//Serialize the list to the file
		try {
			oos.writeObject(bmiList);
		} catch (IOException e) {
			System.err.println("Failed to write to file.");
		}
		
		//Close the file when done
		try {
			fos.close();
			oos.close();
		} catch (IOException e1) {
			System.err.println("Can not close the file!");
		}
		
		scanner.close();
	}
}
