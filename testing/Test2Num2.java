package testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test2Num2 {

	public static void main(String[] args) {
		Scanner fileInput = null; 
		File f = new File("book.txt");
		
		try {
			fileInput = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.err.println("Can NOT open file: "+f.getAbsolutePath());
			return; //exit program
		}
		
		//create an arrayList of books
		ArrayList<Book> bookList = new ArrayList<Book>();
		
		while (fileInput.hasNext()) {
			String author = (String) fileInput.nextLine();
			String title = (String) fileInput.nextLine();
			String price = (String) fileInput.nextLine();
			
			bookList.add(new Book(author, title, price));
		}	
		
		//output the arrayList in reverse
		System.out.println("***********************************************");
		System.out.println("Printing in reversed order of insertion");
		for (int i = bookList.size()-1; i>=0 ; i--) {
			System.out.println(bookList.get(i).toString());
			System.out.println("__________________");
		}
		
		//sort using Collections.sort
		Collections.sort(bookList);
		
		//print all
		System.out.println("***********************************************");
		System.out.println("\nPrinting in sorted order according to title");
		for (Book book : bookList) {
			System.out.println(book);
			System.out.println("__________________");
		}
		
		//close the file
		fileInput.close();
	}

}
