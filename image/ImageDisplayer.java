package image;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageDisplayer extends Frame {

	private static final int NORMAL = 1;
	private static final int GRAY_SCALE = 1;

	public ImageDisplayer() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	public void paint(Graphics g) {
		g.drawImage(this.getGrayScaleImage(), getInsets().left, getInsets().top, null);
	}

//	public Dimension getDimension() {
//		return new Dimension(img.getWidth(getParent()), img.getHeight(getParent()));
//	}

	public BufferedImage getRequestedImageFormat(int imageType) {
		switch (imageType) {
		case 1:
			return this.getNormalImage();
		case 2:
			return this.getGrayScaleImage();
		default:
			break;
		}
		return null;
	}

	public BufferedImage getNormalImage() {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("C:\\Users\\jigya\\OneDrive\\Desktop\\doge.jpg"));
		} catch (IOException exc) {
			System.out.println(" Cannot load image file. ");
			System.exit(0);
		}
		return img;
	}

	public BufferedImage getGrayScaleImage() {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("C:\\Users\\jigya\\OneDrive\\Desktop\\doge.jpg"));
		} catch (IOException e) {
			System.out.println(" Cannot load image file. ");
			System.exit(0);
		}
		int width = img.getWidth();
		int height = img.getHeight();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Color c = new Color(img.getRGB(j, i));
				int red = (int) (c.getRed() * 0.299);
				int green = (int) (c.getGreen() * 0.587);
				int blue = (int) (c.getBlue() * 0.114);
				Color newColor = new Color(red + green + blue, red + green + blue, red + green + blue);
				img.setRGB(j, i, newColor.getRGB());
			}
		}
		return img;
	}

	public static void main(String[] args) {
		ImageDisplayer appwin = new ImageDisplayer();
//		appwin.setSize(appwin.getDimension());
		appwin.setTitle("SimplelmageLoad");
		appwin.setVisible(true);
	}
}
