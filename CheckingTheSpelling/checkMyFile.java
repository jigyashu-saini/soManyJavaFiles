package CheckingTheSpelling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class checkMyFile {

	// returns string 0 if the word not found, else returns a string containing
	// lines on which the word was found.
	public static String serchWordInFile(String word, File file) {
		String stringToReturn = "";
		// Reading the contents of the file
		Scanner sc = null;
		try {
			sc = new Scanner(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			System.err.println("Exception while adding scanner to file.");
		}
		int lineNumber = 1;
		while (sc.hasNextLine()) {
			String line = sc.nextLine().toUpperCase().replaceAll("\\p{Punct}", "");
			if (line.indexOf(word.toUpperCase()) != -1) {
				stringToReturn += lineNumber + " ";
			}
			lineNumber++;
		}
		if (stringToReturn.length() == 0) {
			stringToReturn = "0";
		}
		return stringToReturn;
	}

	public static void main(String[] args) {
		// for each word in silasMarner.txt, check if it is in words.txt. if it is there
		// do nothing, if not there then print that word with line numbers
		// open SilasMarner.txt
		Scanner sc = null;
		try {
			sc = new Scanner(new FileInputStream(
					"D:\\javaEclipseInstalledHere\\EclipseWorkspace2\\specificationOverviewWrite\\src\\CheckingTheSpelling\\SilasMarner.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("Exception while adding scanner to file.");
		}
		// read each word
		while (sc.hasNext()) {
			// removing all punctuation marks
			String word = sc.next().replaceAll("\\p{Punct}", "");
			String foundAtLine = serchWordInFile(word, new File(
					"D:\\javaEclipseInstalledHere\\EclipseWorkspace2\\specificationOverviewWrite\\src\\CheckingTheSpelling\\words.txt"));
			if (foundAtLine.compareTo("0") == 0) {
				System.out.println("Invailid word \"" + word + "\" found on lines " + serchWordInFile(word, new File(
						"D:\\javaEclipseInstalledHere\\EclipseWorkspace2\\specificationOverviewWrite\\src\\CheckingTheSpelling\\SilasMarner.txt")));
			}
		}

	}
}
