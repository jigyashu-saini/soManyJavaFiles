package givenTheFollowing;

import java.io.*; //
import java.util.Scanner; //
import java.util.ArrayList; //
import java.util.Map; //
import java.util.Map.Entry;
import java.util.stream.Collectors; //

public class Runner {
//	reads all words in a file and groups them by length.
//	Print out how many words of each length are in the file.
//	Use collect and Collectors.groupingBy. 
//	Don't print the words.

	public static void main(String[] args) {
		Scanner scanner = null;
		//a scanner that will read from the desired file
		try {
			scanner = new Scanner(new File("D:\\javaEclipseInstalledHere\\EclipseWorkspace2\\specificationOverviewWrite\\src\\givenTheFollowing\\someFile.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("Cant load file");
		}
		
		//an arrayList to store the readings
		ArrayList<String> listOfWords = new ArrayList<>();
		Map<Integer, Long> result = null;
		while(scanner.hasNext()) {
			//read and store all the words into arrayList, after removing punctuation marks
			listOfWords.add(scanner.next().replaceAll("[^a-zA-Z ]", ""));
		}
		
		//count the elements with same key=word_from_the_list.length
		result = listOfWords.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));

		//print the result
		for (Entry<Integer, Long> entry : result.entrySet())
			System.out.println("Total number of words with length " + entry.getKey() + " are: " + entry.getValue());

	}
}
