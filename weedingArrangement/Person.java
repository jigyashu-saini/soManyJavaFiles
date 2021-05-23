package weedingArrangement;

import java.time.LocalDate;

//1. Person.java
//
//Create a class named Person that holds the following fields:
//two Strings for the person’s first and last name and 
//a LocalDate object for the person’s birthdate. 
public class Person {
	private String fName;
	private String lName;
	private LocalDate birthdate;
	public Person(String fName, String lName, LocalDate birthdate) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.birthdate = birthdate;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	
	@Override
	public String toString() {
		return String.format("Name:%-15s, Dob:%-10s" , (fName+" "+lName), birthdate);
	}

}
