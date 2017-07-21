import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class BinaryConversion {
	public static void main(String[] args) {
		String[] bin = { "01110011", "01101101", "01100001", "01110010", "01110100", "01111001", "01110000", "01100001",
				"01101110", "01110100", "01110011" };

		String[] bin2 = { "01101110", "01100101", "01110010", "01100100", "01110011", "00110100", "01110101" };

		for (int i = 0; i < bin.length; i++) {
			System.out.print(convertToString(bin[i]));
		}
		System.out.println();
		for (int i = 0; i < bin2.length; i++) {
			System.out.print(convertToString(bin2[i]));
		}

	}

	static int convertToInt(String binary) {
		if (binary.length() != 8) {
			JOptionPane.showMessageDialog(null, "Enter 8 bits, silly!!!");
			return 0;
		}
		if (!Pattern.matches("\2", binary)) {
			JOptionPane.showMessageDialog(null, "Binary can only contain 1s or 0s, silly!!!");
			return 0;
		}
		try {
			int asciiValue = Integer.parseInt(binary, 2);
			return asciiValue;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Enter a binary, silly!!!");
			// question.setText("");
			return 0;
		}
	}

	static String convertToString(String binary) {
		int asciiValue = Integer.parseInt(binary, 2);
		char theLetter = (char) asciiValue;
		return "" + theLetter;
	}

}
