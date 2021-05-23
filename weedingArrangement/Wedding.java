package weedingArrangement;

import java.time.LocalDate;

//3. Wedding.java
//
//Create a class named Wedding for a wedding planner that includes the 
//date of the wedding using LocalDate,
//the names/DOB of the Couple getting married
//, and a String for the location. 
//

public class Wedding {

	private LocalDate weddingDate;
	private String weddingLocation;
	private Couple couple;
	private Person person1;
	private Person person2;

	public Wedding(LocalDate weddingDate, String weddingLocation, String firstName1, String lastName1, LocalDate dob1,
			String firstName2, String lastName2, LocalDate dob2)
	{
		this.weddingDate = weddingDate;
		this.weddingLocation = weddingLocation;
		person1 = new Person(firstName1, lastName1, dob1);
		person2 = new Person(firstName2, lastName2, dob2);
		couple = new Couple(person1, person2);
	}

	public LocalDate getWeddingDate() {
		return weddingDate;
	}

	public void setWeddingDate(LocalDate weddingDate) {
		this.weddingDate = weddingDate;
	}

	public String getWeddingLocation() {
		return weddingLocation;
	}

	public void setWeddingLocation(String weddingLocation) {
		this.weddingLocation = weddingLocation;
	}

	public Couple getCouple() {
		return couple;
	}

	public void setCouple(Couple couple) {
		this.couple = couple;
	}

	public Person getPerson1() {
		return person1;
	}

	public void setPerson1(Person person1) {
		this.person1 = person1;
	}

	public Person getPerson2() {
		return person2;
	}

	public void setPerson2(Person person2) {
		this.person2 = person2;
	}
	
	@Override
	public String toString() {
		return String.format("Wedding of:\n\t%s\n\ton:%s\n\tat:%s", couple, weddingDate, weddingLocation);
	}

}
