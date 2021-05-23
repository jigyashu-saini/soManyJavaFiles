package weedingArrangement;

//2. Couple.java
//
//Create a class named Couple that contains two Person objects. 

public class Couple {
	private Person person1;
	private Person person2;
	public Couple(Person person1, Person person2) {
		super();
		this.person1 = person1;
		this.person2 = person2;
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
		return String.format("Couple:\n\t\t%s\n\t\t%s", person1, person2);
	}
	
}
