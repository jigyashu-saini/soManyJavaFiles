package somethingAboutPhoneNumber;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
//import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Driver {

	public static int getPhoneKeypadSpelling(String word) {
		int phoneKeywordSpelling = 0;
		for (int i = 0; i < word.length(); i++) {
			if ("abc".contains("" + word.toLowerCase().charAt(i))) {
				phoneKeywordSpelling *= 10;
				phoneKeywordSpelling += 2;
			} else if ("def".contains("" + word.toLowerCase().charAt(i))) {
				phoneKeywordSpelling *= 10;
				phoneKeywordSpelling += 3;
			} else if ("ghi".contains("" + word.toLowerCase().charAt(i))) {
				phoneKeywordSpelling *= 10;
				phoneKeywordSpelling += 4;
			} else if ("jkl".contains("" + word.toLowerCase().charAt(i))) {
				phoneKeywordSpelling *= 10;
				phoneKeywordSpelling += 5;
			} else if ("mno".contains("" + word.toLowerCase().charAt(i))) {
				phoneKeywordSpelling *= 10;
				phoneKeywordSpelling += 6;
			} else if ("pqrs".contains("" + word.toLowerCase().charAt(i))) {
				phoneKeywordSpelling *= 10;
				phoneKeywordSpelling += 7;
			} else if ("tuv".contains("" + word.toLowerCase().charAt(i))) {
				phoneKeywordSpelling *= 10;
				phoneKeywordSpelling += 8;
			} else if ("wxyz".contains("" + word.toLowerCase().charAt(i))) {
				phoneKeywordSpelling *= 10;
				phoneKeywordSpelling += 9;
			}
		}
		return phoneKeywordSpelling;
	}

	public static void addToMap(Map<Integer, Set<String>> map, String valueWord) {
		// get the code for the word
		int phoneCode = getPhoneKeypadSpelling(valueWord);
		// if phoneCode key already exists, then add valueWord to the set
		if (map.containsKey(phoneCode)) {
			map.get(phoneCode).add(valueWord);
		} else { // else if key with same code does not exists, then create a new entry and put
					// key and values into it
			map.put(phoneCode, new HashSet<>(List.of(valueWord)));
		}
	}

	public static void main(String[] args) {
		// there is a map of key=code and value=set of words that has that key
		Map<Integer, Set<String>> map = new HashMap<>();
		// read from the file of words
		Scanner scanner = null;
		try {
			//ENTER THE FILE PATH ACCORDING TO YOUR OWN SYSTEM
			scanner = new Scanner(new File("C:\\Users\\jigya\\OneDrive\\Desktop\\1000Words.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			e.printStackTrace();
			System.exit(0); // in case of errors exit
		}

		while (scanner.hasNext()) {
			String word = scanner.next();
			addToMap(map, word);
		}

		//if you want to see the key and values, uncomment this block of code
		//and uncomment import java.util.Map.Entry; on the top of file
//		for (Entry<Integer, Set<String>> entry : map.entrySet())
//			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

		// prompt user for number to serch
		System.out.print("Enter a phone code number to serch: ");
		scanner = new Scanner(System.in);
		int phoneCode = scanner.nextInt();
		System.out.println("Words with code " + phoneCode + " are: ");
		for (String word : map.get(phoneCode)) {
			System.out.println(word);
		}
		scanner.close();
	}
}
