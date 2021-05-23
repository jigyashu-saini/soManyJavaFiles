package punchLineWrite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Runner {
	// function that prints all the lines of the file passed to it
	// using Buffered reader that would read each file and store it in the variable named nextLine.
	// when EOF is reached, the reader will read a null value from file and this will terminate the while loop.
	public static void printJock(File file) {
		BufferedReader scanner = null;
		String nextLine = null;
		try {
			scanner = new BufferedReader(new FileReader(file));
			nextLine = scanner.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		while (nextLine != null) {
			System.out.println(nextLine);
			try {
				nextLine = scanner.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// function that prints the last lines of the file passed to it
	// using Buffered reader that would read each file and store it in the variable named nextLine.
	// before reading the next line from file, the value of variable nextLine is stored in variable previousLine.
	// when EOF is reached, the reader will read a null value from file and this will terminate the while loop.
	// the previousLine is then printed to console.
	public static void printPunchLine(File file) {
		BufferedReader scanner = null;
		String nextLine = null;
		String previousLine = null;
		try {
			scanner = new BufferedReader(new FileReader(file));
			nextLine = scanner.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		while (nextLine != null) {
			previousLine = nextLine;
			try {
				nextLine = scanner.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(previousLine);
		try {
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//type the location of jock.dat and punchLine.dat file according to your pc
		printJock(new File(
				"D:\\javaEclipseInstalledHere\\EclipseWorkspace2\\specificationOverviewWrite\\src\\punchLineWrite\\jock.dat"));
		printPunchLine(new File(
				"D:\\javaEclipseInstalledHere\\EclipseWorkspace2\\specificationOverviewWrite\\src\\punchLineWrite\\punchLine.dat"));
	}
}
