package batteries;

import java.util.Scanner;

public class ApplianceInformation {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		Appliance myAppliance = new Appliance();
		BatteryAppliance myBatteryAppliance = new BatteryAppliance();

		String applianceName, manufacturerName, batteryApplianceName, batteryManufacturer;
		int yearBuilt, cost, batteryYearBuilt, batteryCost, numBatteries, numChords;

		applianceName = scnr.nextLine();
		manufacturerName = scnr.nextLine();
		yearBuilt = scnr.nextInt();
		scnr.nextLine();
		cost = scnr.nextInt();
		scnr.nextLine();
		batteryApplianceName = scnr.nextLine();
		batteryManufacturer = scnr.nextLine();
		batteryYearBuilt = scnr.nextInt();
		batteryCost = scnr.nextInt();
		numBatteries = scnr.nextInt();
		numChords = scnr.nextInt();

		myAppliance.setName(applianceName);
		myAppliance.setManufacturer(manufacturerName);
		myAppliance.setYearBuilt(yearBuilt);
		myAppliance.setCost(cost);
		myAppliance.printInfo();

		myBatteryAppliance.setName(batteryApplianceName);
		myBatteryAppliance.setManufacturer(batteryManufacturer);
		myBatteryAppliance.setYearBuilt(batteryYearBuilt);
		myBatteryAppliance.setCost(batteryCost);
		myBatteryAppliance.setNumOfBatteries(numBatteries);
		myBatteryAppliance.setNumOfChords(numChords);
		myBatteryAppliance.printInfo();

		System.out.println(" Number of batteries: " + myBatteryAppliance.getNumOfBatteries());
		System.out.println(" Number of chords: " + myBatteryAppliance.getNumOfChords());
	}
}
