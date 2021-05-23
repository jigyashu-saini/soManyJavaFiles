package weedingArrangement;

import java.time.LocalDate;

//	4. WeddingDriver.java
//
//	In main, create/declare/initialize all objects/variables necessary to create a Wedding object and call the printWeddingInfo method using the object.
//	The driver class should have the following 2 methods:

public class WeddingDriver {

	public static void main(String[] argos) {
	   // create a Wedding object
		Wedding wedding = new Wedding(LocalDate.of(2021, 9, 24), "Bali", "Adam", "tomato", LocalDate.of(2000, 7, 7), "Eve", "potato", LocalDate.of(2001, 9, 14));
	   // call printWeddingInfo to print the details of the wedding
	   printWeddingInfo(wedding);
	}


	public static void printWeddingInfo(Wedding wedding) {
		System.out.println(wedding.toString());
	}
}
