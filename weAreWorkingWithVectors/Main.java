package weAreWorkingWithVectors;

public class Main {
	public static void main(String[] args) {
		Vector2D v1 = new Vector2D();
		Vector2D v2 = new Vector2D(v1);
		
		v1.setxCordinate(20);
		
		System.out.println("v1: "+v1);
		System.out.println("v2: "+v2);
		
		v2 = v1.clone();
		System.out.println("v2: "+v2);

		v2.setyCordinate(-30);
		
		System.out.println(Vector2D.A2B(new Point(2, 4), new Point(5, 4)));
		
		System.out.println(v2.length());
		System.out.println(v2.normalize());
		System.out.println(Vector2D.dot(v1, v2));
		System.out.println(v2.dotWith(v1));
		System.out.println(v2.angle(v1));
		System.out.println(v2.getPerp());
		
	}
}
