package celciousFearanhiteKelvin;

import java.util.ArrayList;
import java.util.Scanner;

public class TemperatureConverter {
	private static Scanner scanner = new Scanner(System.in);

	public static int getMenuSelection() {
		System.out.print("1.Convert from Celsius\n" + "2.Convert from Fahrenheit\n" + "3.Convert from Kelvin\n"
				+ "4.Quit Program\n\nEnter your choice: ");
		return scanner.nextInt();
	}

	public static void main(String[] args) {
		int menuSelection = 0;

		do {
			menuSelection = getMenuSelection();
			switch (menuSelection) {
			case 1:
				convertFromCelsius();
				break;
			case 2:
				convertFromFahrenheit();
				break;
			case 3:
				convertFromKelvin();
				break;
			case 4:
				break; /* Do nothing. Exit Condition */
			default:
				System.out.println("Please \nEnter a number between 1 and 4");
			}
		} while (menuSelection != 4);
	}

	private static void convertFromKelvin() {
		System.out.print("\nEnter three space saperated values of temperature\nin Kelvin: ");
		ArrayList<Double> listOfTemperature = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			listOfTemperature.add(scanner.nextDouble());
		}

		System.out.printf("%-10s %-10s %-10s\n", "Kelvin", "Farenhite", "Celsius");

		for (Double kelvin : listOfTemperature) {
			System.out.printf("%-10.2f %-10.2f %-10.2f\n", kelvin, kelvin * (9.0 / 5.0) - 459.67, kelvin - 273.15);
		}

		System.out.println();
	}

	private static void convertFromFahrenheit() {
		System.out.print("\nEnter three space saperated values of temperature\nin Farenhite: ");
		ArrayList<Double> listOfTemperature = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			listOfTemperature.add(scanner.nextDouble());
		}

		System.out.printf("%-10s %-10s %-10s\n", "Farenhite", "Celsius", "Kelvin");

		for (Double farenhite : listOfTemperature) {
			System.out.printf("%-10.2f %-10.2f %-10.2f\n", farenhite, (farenhite - 32) * (5.0 / 9.0),
					(farenhite + 459.67) * (5.0 / 9.0));
		}
		System.out.println();
	}

	private static void convertFromCelsius() {
		System.out.print("\nEnter three space saperated values of temperature\nin Celsius: ");
		ArrayList<Double> listOfTemperature = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			listOfTemperature.add(scanner.nextDouble());
		}

		System.out.printf("%-10s %-10s %-10s\n", "Celsius", "Farenhite", "Kelvin");

		for (Double celcius : listOfTemperature) {
			System.out.printf("%-10.2f %-10.2f %-10.2f\n", celcius, celcius * (9.0 / 5.0) + 32, celcius + 273.15);
		}
		System.out.println();
	}

}
