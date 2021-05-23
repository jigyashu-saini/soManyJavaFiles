package electricBillCalculatorGui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ElectricBillGui {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// take the input file
		String inputFile = JOptionPane.showInputDialog(f,
				"Welcome to the electricity Billing Programe. Please enter the name of the input file and click ok.",
				"Input", JOptionPane.QUESTION_MESSAGE);
		// The Output File
		FileWriter fw = null;
		try {
			fw = new FileWriter(new File("D:\\javaEclipseInstalledHere\\EclipseWorkspace2\\specificationOverviewWrite\\src\\electricBillCalculatorGui\\customerBills.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// The program will read all information from an input file.
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(inputFile));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		while (scanner.hasNext()) {
			String accountNumber = scanner.next().strip();
			Boolean lateBill = scanner.nextBoolean();
			char companyClassificationCode = scanner.next().charAt(0);
			double kwhUsed = scanner.nextDouble();
			double kwhPrice;
//			C- $0.0645
//			L- $ 0.0631
//			N- $0.050445
//			S- $0.05012
//			Any other code - Invalid, default to $0.07      
			switch (companyClassificationCode) {
			case 'C':
				kwhPrice = 0.0645;
				break;
			case 'L':
				kwhPrice = 0.0631;
				break;
			case 'N':
				kwhPrice = 0.050445;
				break;
			case 'S':
				kwhPrice = 0.05012;
				break;
			default:
				kwhPrice = 0.07;
				break;
			}

			double amountDue = kwhUsed * kwhPrice;

//			Late bills incur a late fee, which is equal to 15% of the amount due.
			double lateFee = 0;
			if (lateBill) {
				lateFee = (15*amountDue)/100;
			}
			
			try {
				fw.write(String.format("Account Number: %s\n",accountNumber));
				fw.write(String.format("Company classification code: %s\n",companyClassificationCode));
				fw.write(String.format("Total number of KWH used: $%,.02f\n",kwhUsed));
				fw.write(String.format("Amount Due: $%,.02f\n",amountDue));
				if (lateBill) {
					fw.write(String.format("Late Fee: $%,.02f\n",lateFee));
					fw.write(String.format("Total Due: $%,.02f\n",(amountDue+lateFee)));
				}
				for (int i = 0; i < 90; i++) {
					fw.write("*");
					if (i==44) {
						fw.write("\n");
					}
				}
				fw.write("\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(f, "Thank you for using the Electricity Billing Program.\nCustomer Billing Information is stored in the file named customerBills.txt", "ThankYou", JOptionPane.INFORMATION_MESSAGE);
		scanner.close();
		try {
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
}
