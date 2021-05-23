package homeOwnerVoting;

import java.text.SimpleDateFormat;
import java.util.Date;

//Create a class called homeOwner
//Add fields 
//to store the ID number.
//date of birth,
//surname,
//street number,
//street name and
//vote using appropriate types.
//
//Add constant static fields to set FIBRE to 1 and NOFIBRE to 0.
//
//Add static fields to count the total number of fibre yes votes and fibre no votes.Assign both to 0
//
//Code a parameterized constructor to assign values to the id number,surname,street number, street name and vote fields.
//
//Add code to extract the homeowners's date of birth from the first 6 charcters from the id number. For example. 6908201234081 becomes 690820
//
//Add "19" to the beginning of the date to include the century. for example, 690820 becomes 19690820
//
//Convert the string date to a date object and store the result in the dob field.
//
//Increase the field fibreCount by 1 if the vote has the value of 1 otherwise increase the field nofibreCount by 1.
//
//Add accessor methods for the fibrecount and nofibrecount fields
//
//Add a toString method to display the surname,date of birth, street number and street name fields. if the vote field has the value of fibre then add " voted yes" otherwise add "voted no"
//
public class HomeOwner {
	private String id; // string as id is way out the integer threshold range
	private Date dob;
	private String surname;
	private String streetNumber;
	private String streetName;
	private int vote;

	public final static int FIBRE = 1;
	public final static int NOFIBRE = 0;

	private static int fibreCount = 0;
	private static int noFibreCount = 0;

	public HomeOwner(String id, String surname, String streetNumber, String streetName, int vote) {
		this.id = id;
		this.surname = surname;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.vote = vote;
		// code to create required date object
		// year value is inserted as "the year minus 1900." so there is no need to
		// explictly add a "19"

		this.dob = new Date(Integer.valueOf(id.substring(0, 2)), Integer.valueOf(id.substring(2, 4)) - 1,
				Integer.valueOf(id.substring(4, 6)));
		// increase vote counts appropriately
		if (vote == FIBRE) {
			fibreCount++;
		} else {
			noFibreCount++;
		}
	}

	public static int getFibreCount() {
		return fibreCount;
	}

	public static int getNoFibreCount() {
		return noFibreCount;
	}

	@Override
	public String toString() {
		// Add a toString method to display the surname,date of birth, street number and
		// street name fields. if the vote field has the value of fibre then add " voted
		// yes" otherwise add "voted no"
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
		return surname + " " + sdf.format(dob) + " " + streetNumber + " " + streetName + " "
				+ (vote == FIBRE ? "voted yes." : "voted no.");
	}

}