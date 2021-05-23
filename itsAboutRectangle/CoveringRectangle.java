package itsAboutRectangle;

public class CoveringRectangle {
	
	public static Rectangle findingCovering(Rectangle r1, Rectangle r2) {
		
		
		if (r1.getCenterY() > r2.getCenterY() && r1.getCenterX()<r2.getCenterX()) { //case 1: r1 center has higher y vaue and less x value than r2
			return new Rectangle((r2.getCenterX()+ r1.getCenterX())/2, (r1.getCenterY()+ r2.getCenterY())/2, r2.getCenterX()-r1.getCenterX(), r1.getCenterY()-r2.getCenterY());
		} else if(r1.getCenterY() > r2.getCenterY() && r1.getCenterX()>r2.getCenterX()) { //case 2: r1 center has higher y vaue and high x value than r2
			return new Rectangle((r1.getCenterX()+ r2.getCenterX())/2,(r1.getCenterY()+r2.getCenterY())/2, r1.getCenterX()-r2.getCenterX(), r1.getCenterY()-r2.getCenterY());
		} else if(r1.getCenterX() == r2.getCenterX()) { //if x cordinate of center are same 
			double minWidth = r1.getWidth() < r2.getWidth() ? r1.getWidth() : r2.getWidth(); //get min width
			return new Rectangle(r1.getCenterX(), ( r1.getCenterY()+r2.getCenterY() )/2, minWidth, r1.getCenterY()-r2.getCenterY());
		} else //if (r1.getCenterY() == r2.getCenterY()) {
		{
			double minHeight = r1.getHeight() < r2.getHeight() ? r1.getHeight() : r2.getHeight(); //get min width
			return new Rectangle(( r2.getCenterX() + r1.getCenterX() )/2, r1.getCenterY(),r2.getCenterX() - r1.getCenterX(), minHeight);
		}
	}
	
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(3, 8, 33, 8);
		Rectangle r2 = new Rectangle(5, 3, 4, 4);
		System.out.println(r1+"\n"+r2);
		System.out.println(findingCovering(r1, r2));
		
		System.out.println();
		
		r1 = new Rectangle(3, 8, 33, 8);
		r2 = new Rectangle(5, 8, 4, 7);
		System.out.println(r1+"\n"+r2);
		System.out.println(findingCovering(r1, r2));
		
		System.out.println();

		r1 = new Rectangle(3, 8, 2, 8);
		r2 = new Rectangle(3, 3, 4, 4);
		System.out.println(r1+"\n"+r2);
		System.out.println(findingCovering(r1, r2));
		
		System.out.println();

		r1 = new Rectangle(10, 8, 33, 8);
		r2 = new Rectangle(7, 3, 4, 4);
		System.out.println(r1+"\n"+r2);
		System.out.println(findingCovering(r1, r2));
		
	}
}
