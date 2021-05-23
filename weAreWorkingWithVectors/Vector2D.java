package weAreWorkingWithVectors;

public class Vector2D {
	private double xCordinate ;
	private double yCordinate ;
	
	public Vector2D(double xCordinate, double yCordinate) {
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;
	}
	
	public Vector2D(Vector2D olderVector) {
		this.xCordinate = olderVector.getxCordinate();
		this.yCordinate = olderVector.getyCordinate();
	}
	
	public Vector2D() {
		this.xCordinate = 1;
		this.yCordinate = 0;
	}
	
	public Vector2D clone() {
		return new Vector2D(this);
	}

	public double getxCordinate() {
		return xCordinate;
	}

	public void setxCordinate(double xCordinate) {
		this.xCordinate = xCordinate;
	}

	public double getyCordinate() {
		return yCordinate;
	}

	public void setyCordinate(double yCordinate) {
		this.yCordinate = yCordinate;
	}
	
	@Override
	public String toString() {
		return "( "+xCordinate+", "+yCordinate+" )";
	}
	
	/////////////////////Services
	public static Vector2D A2B(Point a, Point b) {
		return new Vector2D((b.getX()-a.getX()), (b.getY()-a.getY()));
	}
	
	public double length() { //+ve square_root(x^2 + y^2)
		return Math.sqrt(Math.abs(Math.pow(xCordinate, 2)+Math.pow(yCordinate, 2)));
	}
	
	public Vector2D normalize() {
		return new Vector2D(xCordinate/this.length(), yCordinate/this.length());
	}
	
	public static double dot(Vector2D a, Vector2D b) {
		return (a.xCordinate*b.xCordinate) + (a.yCordinate*b.yCordinate);
	}
	
	public double dotWith(Vector2D b) {
		return dot(this, b);
	}
	
	public double angle(Vector2D b) {
		return Math.cosh(Math.abs(this.dotWith(b))/(this.length()*b.length()));
	}
	
	public Vector2D getPerp() { //the clockwise perpendicular
		return new Vector2D(this.yCordinate, -this.xCordinate);
		}
}

class Point{
	private double x;
	private double y;
	
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
}
