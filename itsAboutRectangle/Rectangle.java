package itsAboutRectangle;

public class Rectangle {
	private double centerX;
	private double centerY;
	private double width;
	private double height;
	
	public Rectangle(double centerX, double centerY, double width, double height) {
		super();
		this.centerX = centerX;
		this.centerY = centerY;
		this.width = width;
		this.height = height;
	}

	public double getCenterX() {
		return centerX;
	}
	
	public double getCenterY() {
		return centerY;
	}
	
	protected double getWidth() {
		return width;
	}

	protected double getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "centerX=" + centerX + ", centerY=" + centerY + ", width=" + width + ", height=" + height;
	}
	
	
}
