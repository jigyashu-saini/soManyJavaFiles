package foreignExchangeApp;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Drawing extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setSize(300, 550);
		frame.setTitle("Drawing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JButton button = new JButton("Show Chart");
		final JButton button2 = new JButton("Clear Chart");

		final FinalDrawingComponent chart = new FinalDrawingComponent();
		chart.setPreferredSize(new Dimension(250, 250));

		JPanel panel = new JPanel();

		panel.add(button);
		panel.add(button2);
		panel.add(chart);

		frame.add(panel);
		frame.setVisible(true);

		class ButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				try {
					String filename = "D:\\javaEclipseInstalledHere\\EclipseWorkspace2\\specificationOverviewWrite\\src\\foreignExchangeApp\\currencyExchange.txt";
					File input = new File(
							"D:\\javaEclipseInstalledHere\\EclipseWorkspace2\\specificationOverviewWrite\\src\\foreignExchangeApp\\currencyExchange.txt");
					Scanner in = new Scanner(input);
					try {
						chart.changeColor();
						in.nextLine();
						while (in.hasNextLine()) {
							String line = in.nextLine();
							String[] lineContent = line.split(" ");
							chart.appendValues(Integer.parseInt(lineContent[0]), Integer.parseInt(lineContent[1]));
							chart.appendColor(Integer.parseInt(lineContent[2]), Integer.parseInt(lineContent[2]),
									Integer.parseInt(lineContent[4]));
						}
					} finally {
						in.close();
					}

				} catch (IOException e) {
					System.out.println("error file");
				}
			}
		}

		class ClearButtonListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				chart.clearArray();
			}
		}

		ActionListener listener1 = new ButtonListener();
		button.addActionListener(listener1);

		ActionListener listener2 = new ClearButtonListener();
		button2.addActionListener(listener2);
	}
}

class FinalDrawingComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	private ArrayList<Point> values;
	private ArrayList<Color> colors;

	public FinalDrawingComponent() {
		values = new ArrayList<>();
		colors = new ArrayList<>();
	}

	public void appendValues(int x, int y) {
		values.add(new Point(x, y));
		repaint();
	}

	public void clearArray() {
		values.clear();
		repaint();
	}

	public void changeColor() {
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		this.setBackground(new Color(red, green, blue));
		clearArray();
	}

	@Override
	public void paintComponent(Graphics g) {
		g.fillRect(0, 0, getWidth(), getHeight());

		for (int i = 0; i < values.size(); i++) {
			int x = values.get(i).x;
			int y = values.get(i).y;

			Color c = colors.get(i);
			g.setColor(c);
			g.fillOval(x, y, 10, 10);
		}
	}

	public void appendColor(int red, int green, int blue) {
		colors.add(new Color(red, green, blue));
	}
}