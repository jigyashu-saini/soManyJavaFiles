package circles;

import java.util.ArrayList;

/**
 * Purpose: class that contains main method, will be used to test the 
 * 			Circle2, OvalCylinder2, Oval2, Cylinder2 class methods and some static methods of this class.
 * @author YOUR_NAMES
 * date: 12-03-2021
 *
 */
public class ClientClass {
	
	//declairing showCenter method
	public static void showCenter(Circle2 shape) {
		System.out.println("Fot this "+shape.getName()+", the center is at "+shape.getCenter());
	}

	public static void main(String[] args) {

		//declairing each class object
		Circle2 circle = new Circle2(2, 4, 10);
		Cylinder2 cylinder = new Cylinder2(10, 15, 5, 10);
		Oval2 oval = new Oval2(25, 10, 7, 6);
		OvalCylinder2 OvalCylinder = new OvalCylinder2(14, 10, 7, 4, 11);
		
		//array list that contains all Circle2 objects
		ArrayList<Circle2> shapesList = new ArrayList<>();
		//adding shaper to list:
		shapesList.add(circle);
		shapesList.add(cylinder);
		shapesList.add(oval);
		shapesList.add(OvalCylinder);
		
		//alling the showCenter for each shape in arrayList
		for (Circle2 shape : shapesList) {
			showCenter(shape);
		}
	}
}
