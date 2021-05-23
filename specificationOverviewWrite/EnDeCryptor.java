package specificationOverviewWrite;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EnDeCryptor {

	private JFrame frame;
	private JLabel keywordLabel;
	private JTextField keywordTextField;
	private JLabel filenameLabel;
	private JTextField filenameTextField;
	private JButton submitButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnDeCryptor window = new EnDeCryptor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EnDeCryptor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Encription/Decryption Program");
		frame.setResizable(false);
		frame.setBounds(100, 100, 518, 229);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 30 };
		gridBagLayout.rowHeights = new int[] { 30 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		frame.getContentPane().setLayout(gridBagLayout);

		keywordLabel = new JLabel("KEYWORD");
		keywordLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_keywordLabel = new GridBagConstraints();
		gbc_keywordLabel.anchor = GridBagConstraints.WEST;
		gbc_keywordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_keywordLabel.gridx = 1;
		gbc_keywordLabel.gridy = 2;
		frame.getContentPane().add(keywordLabel, gbc_keywordLabel);

		keywordTextField = new JTextField();
		keywordTextField.requestFocusInWindow();
		GridBagConstraints gbc_keywordTextField = new GridBagConstraints();
		gbc_keywordTextField.gridwidth = 2;
		gbc_keywordTextField.insets = new Insets(0, 0, 5, 10);
		gbc_keywordTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_keywordTextField.gridx = 2;
		gbc_keywordTextField.gridy = 2;
		frame.getContentPane().add(keywordTextField, gbc_keywordTextField);
		keywordTextField.setColumns(10);

		filenameLabel = new JLabel("FILENAME");
		filenameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_filenameLabel = new GridBagConstraints();
		gbc_filenameLabel.anchor = GridBagConstraints.WEST;
		gbc_filenameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_filenameLabel.gridx = 1;
		gbc_filenameLabel.gridy = 4;
		frame.getContentPane().add(filenameLabel, gbc_filenameLabel);

		filenameTextField = new JTextField();
		GridBagConstraints gbc_filenameTextField = new GridBagConstraints();
		gbc_filenameTextField.gridwidth = 2;
		gbc_filenameTextField.insets = new Insets(0, 0, 5, 10);
		gbc_filenameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_filenameTextField.gridx = 2;
		gbc_filenameTextField.gridy = 4;
		frame.getContentPane().add(filenameTextField, gbc_filenameTextField);
		filenameTextField.setColumns(10);

		submitButton = new JButton("Process mono clipher");
		submitButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// a variable that will store the value of keyword
				String keyword = keywordTextField.getText();
				String filename = filenameTextField.getText();
				// show error message if keyword or filename is problematic
				if (!checkKeyword(keyword)) {
					JOptionPane.showMessageDialog(frame, "Invailid KEYWORD", "INVAILID", JOptionPane.ERROR_MESSAGE);
					keywordTextField.setText("");
					keywordTextField.requestFocus();
					return;
				}
				if (!checkFilename(filename)) {
					JOptionPane.showMessageDialog(frame, "Invailid FILENAME", "INVAILID", JOptionPane.ERROR_MESSAGE);
					filenameTextField.setText("");
					filenameTextField.requestFocus();
					return;
				}
				//if all correct then encrypt or decrypt
				//encrypt
				if (filename.endsWith("C")) {
					try {
						EnDeCryptor.encrypt(keyword, filename);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(frame, "FILE ERROR", "FILE ERROR", JOptionPane.ERROR_MESSAGE);
						filenameTextField.setText("");
						filenameTextField.requestFocus();
						return;
					}
				} else {
					//decrypt
					try {
						EnDeCryptor.decrypt(keyword, filename);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(frame, "FILE ERROR", "FILE ERROR", JOptionPane.ERROR_MESSAGE);
						filenameTextField.setText("");
						filenameTextField.requestFocus();
						return;
					}
				}
			}
		});
		GridBagConstraints gbc_submitButton = new GridBagConstraints();
		gbc_submitButton.insets = new Insets(0, 0, 5, 5);
		gbc_submitButton.gridx = 1;
		gbc_submitButton.gridy = 6;
		frame.getContentPane().add(submitButton, gbc_submitButton);
	}

	private static boolean checkKeyword(String keyword) {
		// check if empty or contains only blank spaces
		if (keyword.isBlank()) {
			return false;
		}
		// check if all characters are capital and if some character is repeated
		for (int i = 0; i < keyword.length(); i++) {
			if (!Character.isUpperCase(keyword.charAt(i))
					|| (keyword.replace("" + keyword.charAt(i), "").contains(keyword.charAt(i) + ""))) {
				return false;
			}
		}
		// else return true
		return true;
	}

	private static boolean checkFilename(String filename) {
		// if filename contatins P or C in last then only return true
		if (filename.endsWith("P") || filename.endsWith("C")) {
			return true;
		}
		// else return false
		return false;
	}

	private static void encrypt(String keyword, String filename) throws IOException {
//		create an array to store encryption and decryption characters
		char[] alphabeticalChars = new char[26];
		char[] cipherChars = new char[26];
		ArrayList<Character> temp = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			alphabeticalChars[i] = (char) ('A' + i);
			temp.add((char) ('A' + i));
		}
		for (int i = 0; i < keyword.length(); i++) {
			temp.remove(temp.indexOf(keyword.charAt(i)));
		}
		for (int i = 0; i < 26; i++) {
			if (keyword.length() > i) {
				cipherChars[i] = keyword.charAt(i);
			} else {
				cipherChars[i] = temp.get(temp.size() - 1);
				temp.remove(temp.remove(temp.size() - 1));
			}
		}

		System.out.println("Alphabetical: " + Arrays.toString(alphabeticalChars));
		System.out.println("Chipher     : " + Arrays.toString(cipherChars));

//		filename += ".txt";
//		open file
		BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
//		create decrypted file
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("messageD.txt")));
//		get the first character from the file check if its not empty
		int byteFromFile = br.read();
		while (byteFromFile != -1) {
			char charToBeWritten = (char) byteFromFile;
			if (!Character.isWhitespace(charToBeWritten)) {
				int indexOfChar = 0;
				for (int i = 0; i < cipherChars.length; i++) {
					if (cipherChars[i] == charToBeWritten) {
						indexOfChar = i;
						break;
					}
				}
				charToBeWritten = alphabeticalChars[indexOfChar];
			}
			bw.write(charToBeWritten);
			byteFromFile = br.read();
		}
		//close all
		bw.close();
		br.close();
		JOptionPane.showMessageDialog(null, "Successfully Encrypted the file", "Encryption Succesfull", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private static void decrypt(String keyword, String filename) throws IOException {
//		create an array to store encryption and decryption characters
		char[] alphabeticalChars = new char[26];
		char[] cipherChars = new char[26];
		ArrayList<Character> temp = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			alphabeticalChars[i] = (char) ('A' + i);
			temp.add((char) ('A' + i));
		}
		for (int i = 0; i < keyword.length(); i++) {
			temp.remove(temp.indexOf(keyword.charAt(i)));
		}
		for (int i = 0; i < 26; i++) {
			if (keyword.length() > i) {
				cipherChars[i] = keyword.charAt(i);
			} else {
				cipherChars[i] = temp.get(temp.size() - 1);
				temp.remove(temp.remove(temp.size() - 1));
			}
		}

		System.out.println("Alphabetical: " + Arrays.toString(alphabeticalChars));
		System.out.println("Chipher     : " + Arrays.toString(cipherChars));

//		filename += ".txt";
//		open file
		BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
//		create decrypted file
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("messageC.txt")));
//		get the first character from the file check if its not empty
		int byteFromFile = br.read();
		while (byteFromFile != -1) {
			char charToBeWritten = (char) byteFromFile;
			if (!Character.isWhitespace(charToBeWritten)) {
				int indexOfChar = 0;
				for (int i = 0; i < cipherChars.length; i++) {
					if (alphabeticalChars[i] == charToBeWritten) {
						indexOfChar = i;
						break;
					}
				}
				charToBeWritten = cipherChars[indexOfChar];
			}
			bw.write(charToBeWritten);
			byteFromFile = br.read();
		}
		//close all
		bw.close();
		br.close();
		JOptionPane.showMessageDialog(null, "Successfully Decrypted the file", "Decryption Succesfull", JOptionPane.INFORMATION_MESSAGE);
	}

}
