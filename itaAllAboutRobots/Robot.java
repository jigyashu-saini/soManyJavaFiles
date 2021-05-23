package itaAllAboutRobots;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

//creating a class of Robots for ease of use
public class Robot {
	private int posX;
	private int posY;

	public Robot() {
		this(0, 0);
	}

	public Robot(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
	}

	protected int getPosX() {
		return posX;
	}

	protected int getPosY() {
		return posY;
	}
}

class Runner {
	public static void main(String[] args) {
		// create a arraylist of robots
		// store the distances between all robots in an arrayList
		// remove all 0's from the distance list
		// sort the arrayList
		// print the first element

		// making it user interfaceble
		
		//get number of robots
		Scanner scanner = new Scanner(System.in);
		int numOfRobots;
		do {
			System.out.print("Enter the number of robots: ");
			 numOfRobots = scanner.nextInt();
			if (numOfRobots >= 2 && numOfRobots <= 100000) {
				break;
			} else {
				System.out.println("Number of robots shall be between 2 and 100000 inclusive.");
			}
		} while (true);

		//get xPos
		ArrayList<Integer> xPos = new ArrayList<>();
		do {
			System.out.print("Enter all the X positions(use space to saperate): ");
			for (int i = 0; i < numOfRobots; i++) {
				xPos.add(scanner.nextInt());
			}
			
			boolean vailidEntry = true;
			for (Integer x : xPos) {
				if (x<0 || x>1000000000) {
					System.out.println("xPositio shall be between 0 and 10^9 inclusive: "+x);
					vailidEntry=false;
				}
			}
			if (vailidEntry) break;
		} while (true);
		
		//get yPos
		ArrayList<Integer> yPos = new ArrayList<>();
		do {
			System.out.print("Enter all the Y positions(use space to saperate): ");
			for (int i = 0; i < numOfRobots; i++) {
				yPos.add(scanner.nextInt());
			}
			
			boolean vailidEntry = true;
			for (Integer y : yPos) {
				if (y<0 || y>1000000000) {
					System.out.println("yPositio shall be between 0 and 10^9 inclusive: "+y);
					vailidEntry=false;
				}
			}
			if (vailidEntry) break;
		} while (true);
		
		//adding robots to arrayList so that we could easilt iterate
		ArrayList<Robot> robotList = new ArrayList<Robot>(); ;
		for (int i = 0; i < numOfRobots; i++) {
			robotList.add(new Robot(xPos.get(i), yPos.get(i)));
		}
		
		ArrayList<Integer> resultList = new ArrayList<Integer>(); //this will store the result
		
		//now for each robot, calculate squared Euclidean distance and store it in resultList
		for (Robot robot1 : robotList) {
			for (Robot robot2 : robotList) {
				resultList.add((int) (Math.pow(robot1.getPosX()-robot2.getPosX(), 2)+Math.pow(robot1.getPosY()-robot2.getPosY(), 2)));				
			}
		}
		
		//remove all 0's
		resultList.removeIf(n -> n==0); //means take element as n and remove if n is equals 0
		
		//sort the list
		Collections.sort(resultList);
		
		System.out.println("Shortest distance is: "+resultList.get(0));
		
		scanner.close();
		
	}
}
























