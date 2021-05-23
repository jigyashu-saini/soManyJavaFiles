package batteries;

// TODO: Define a class: BatteryAppliance that is derived from the Appliance class
public class BatteryAppliance extends Appliance {
// TODO: Declare private fields: numBatteries, numChords
	private int numBatteries, numChords;

// TODO: Define mutator methods -
// setNumOfBatteries(), setNumOfChords()
	public void setNumOfBatteries(int numBatteries) {
		this.numBatteries = numBatteries;
	}

	public void setNumOfChords(int numChords) {
		this.numChords = numChords;
	}

// TODO: Define accessor methods -
// getNumOfBatteries(), getNumOfChords()
	public int getNumOfBatteries() {
		return numBatteries;
	}

	public int getNumOfChords() {
		return numChords;
	}

	// i think as output for number of batteries and chords is given in main method
	// already,
	// we dont need to overrifde the printInfo() method
	// but however, if you need, here it is:
//	@Override
//	public void printInfo() {
//		super.printInfo();
//		System.out.println("Number of Batteries: "+numBatteries);
//		System.out.println("Number of chords: "+numChords);
//	}

}