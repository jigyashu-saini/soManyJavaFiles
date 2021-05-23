package homeOwnerVoting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FibreUI {

//	Create a text based user interface class called fibreUI
//	In the main method add code to read the data in the text file and instantiate a homeOwner object called home. The code must:

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
//	Open the text file called data.txt
			scanner = new Scanner(new File(
					"D:\\javaEclipseInstalledHere\\EclipseWorkspace2\\specificationOverviewWrite\\src\\homeOwnerVoting\\dat.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("File dat.txt not found");
			System.exit(0);
		}

		while (scanner.hasNext()) {
			String[] fullData = scanner.nextLine().strip().split("#");
//	extract the id number, surname,street number street name and vote fields for each line in the file.
//	If the fibre vote is yes,instantiate the homeOwner object called home using the fibre static field otherwise use the nofirbre static field
			HomeOwner home = new HomeOwner(fullData[0], fullData[1], fullData[2], fullData[3],
					fullData[4].compareToIgnoreCase("yes") == 0 ? HomeOwner.FIBRE : HomeOwner.NOFIBRE);
//	Display the home object using the toString method in the homeOwner class
			System.out.println(home);
		}
		scanner.close();
	}
}
